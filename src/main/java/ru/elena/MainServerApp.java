package ru.elena;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServerApp {

    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8181)) {
            System.out.println("Server start");
            socket = serverSocket.accept();
            System.out.println("Client ready");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    String consoleMessage;
                    try {
                        consoleMessage = reader.readLine();
                        if (consoleMessage != null) {
                            dos.writeUTF(consoleMessage);
                            if (isCloseCommand(consoleMessage)) {
                                System.out.println("BEFORE CONSOLE THREAD CLOSED: " + consoleMessage);
                                reader.close();
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                String clientMassage = dis.readUTF();
                System.out.println(clientMassage);
                dos.writeUTF(clientMassage);

                if (isCloseCommand(clientMassage)) {
                    System.out.println("SERVER CLOSE CONNECTION");
                    closeConnection(socket, dis, dos);
                    break;
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static boolean isCloseCommand(String command) {
        return command != null && command.equalsIgnoreCase("/q");
    }

    private static void closeConnection(Socket s, DataInputStream dis, DataOutputStream dos) {

        try {
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

