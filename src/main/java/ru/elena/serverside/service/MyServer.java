package ru.elena.serverside.service;


import ru.elena.serverside.interfaces.AuthenticationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private final int PORT = 8081;
    private List<ClientHandler> clientsList;
    private AuthenticationService authService;

    public AuthenticationService getAuthService() {
        return this.authService;
    }

    public MyServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            this.authService = new AuthenticationServiceImpl();
            authService.start();
            clientsList = new ArrayList<>();

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(this, socket);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void sendMessageToClients(String message) {
        for (ClientHandler c : clientsList) {
            c.sendMessage(message);
        }
    }

    public synchronized void sendPrivateMessageToClient(String sender, String receiver, String message) {
        clientsList.forEach(clientHandler -> {
            if (clientHandler.getName().equalsIgnoreCase(sender) ||
                    clientHandler.getName().equalsIgnoreCase(receiver)) {
                clientHandler.sendMessage(message);
            }});
        }

        public synchronized void subscribe (ClientHandler c){
            clientsList.add(c);
        }

        public synchronized void unsubscribe (ClientHandler c){
            clientsList.remove(c);
        }

        public boolean isNickBusy (String nick){
            return clientsList.stream()
                    .anyMatch(a -> a.getName().equals(nick));
        }
    }
