package ru.elena.serverside.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private static final String PRIVATE_MARK = "/w";
    private static final String QUIT_MARK = "/q";
    private static final String AUTH_MARK = "/auth";
    private static final String SUCCEED_AUTH_MARK = "/authok ";

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String name;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    closeConnection();
                }

            }).start();
        } catch (IOException e) {
            System.out.println("Server problem");
            ;
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String authStr = dis.readUTF();

            if (authStr.startsWith(AUTH_MARK)) {
                String[] arr = authStr.split("\\s");

                if (arr.length > 2) {
                    String nick = myServer
                            .getAuthService()
                            .getNickByLoginAndPassword(arr[1], arr[2]);

                    if (nick.isEmpty()) {
                        sendMessage("Wrong login/password");
                    } else {
                        if (myServer.isNickBusy(nick)) {
                            sendMessage(nick + " is busy");
                        } else {
                            sendMessage((SUCCEED_AUTH_MARK + nick));
                            name = nick;
                            myServer.sendMessageToClients(nick + " Joined to chat");
                            myServer.subscribe(this);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return name;
    }

    private void readMessage() throws IOException {
        while (true) {
            String messageFromClient = dis.readUTF();

            if (messageFromClient.equals(QUIT_MARK)) {
                sendMessage(messageFromClient);
                return;
            } else if (messageFromClient.contains(PRIVATE_MARK)) {
                String[] messageParts = messageFromClient.split(" ");

                if(messageParts.length > 2) {
                    myServer.sendPrivateMessageToClient(
                            getName(),
                            messageParts[1],
                            messageFromClient.replace(PRIVATE_MARK + " " + messageParts[1] + " ", ""));
                }
            } else {
                myServer.sendMessageToClients(name + ": " + messageFromClient);
            }
        }
    }

    private void closeConnection() {
        myServer.unsubscribe(this);
        myServer.sendMessageToClients(name + " leave chat");
    }
}
