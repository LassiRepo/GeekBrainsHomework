package ru.elena.clientside;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClient extends JFrame {
    private final static String IP_ADDRESS = "localhost";
    private final static int SERVER_PORT = 8081;

    private JTextField msgInputField;
    private JTextArea chatArea;

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private boolean isAuthorized;

    public BaseClient() {
        try {
            connection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        prepareGUI();
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }



    private void connection() throws IOException {
        socket = new Socket(IP_ADDRESS, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        setAuthorized(false);
        Thread thread = new Thread(() -> {
            try {
                while (true){

                    String serverMassage = dis.readUTF();
                    if (serverMassage.startsWith("/authok")) {
                        setAuthorized(true);
                        chatArea.append(serverMassage + "\n");
                        break;
                    }
                    chatArea.append(serverMassage + "\n");
                }
                while (true) {

                    String serverMassage = dis.readUTF();
                    if (serverMassage.equals("/q")) {
//                        dos.writeUTF(serverMassage);
                        break;
                    }

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
                    chatArea.append(dtf.format(LocalDateTime.now()) + ": " + serverMassage + "\n");
                }
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }

            System.out.println("FRAME CLOSE CONNECTION");
            closeConnection();
            dispose();
        });
//        thread.setDaemon(true);
        thread.start();
    }

    private void sendMassageToServer() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                String messageToServer = msgInputField.getText();
                dos.writeUTF(messageToServer);
                msgInputField.setText("");
            } catch (IOException ignored) {
            }
        }

    }

    private void prepareGUI() {
        setTitle("Мой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 400, 600, 600);

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Нижняя панель
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 50));

        // Добавляем нижнюю панель в основноую панель
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Поле для ввода текста
        msgInputField = new JTextField();
        bottomPanel.add(msgInputField, BorderLayout.CENTER);

        // Кнопка
        JButton sendButton = new JButton();
        sendButton.setPreferredSize(new Dimension(100, 50));
        sendButton.setText("Отправить");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Поле чата
        chatArea = new JTextArea();
        chatArea.setEnabled(false);
        chatArea.setMargin(new Insets(0, 10, 0, 0));
        mainPanel.add(chatArea, BorderLayout.CENTER);

        Color textColour = Color.BLACK;
        chatArea.setDisabledTextColor(textColour);

        Color backgroundColour = getBackgroundColor();
        chatArea.setBackground(backgroundColour);
        msgInputField.addActionListener(e -> {
            sendMassageToServer();
        });

        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendMassageToServer();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    System.out.println("CLOSE ACTION");
                    dos.writeUTF("/q");
                    closeConnection();
                } catch (IOException ignored) {
                }
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    protected Color getBackgroundColor() {
        return new Color(255, 255, 255);
    }

    private void closeConnection() {

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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
