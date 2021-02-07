package ru.elena;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWindow extends JFrame {
    public MyWindow() {
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
        JTextField inputField = new JTextField();
        bottomPanel.add(inputField, BorderLayout.CENTER);

        // Кнопка
        JButton sendButton = new JButton();
        sendButton.setPreferredSize(new Dimension(100, 50));
        sendButton.setText("Отправить");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Поле чата
        JTextArea chatField = new JTextArea();
        chatField.setEnabled(false);
        chatField.setMargin(new Insets(0,10,0,0));
        mainPanel.add(chatField, BorderLayout.CENTER);
        Color textColour = Color.BLACK;
        chatField.setDisabledTextColor(textColour);
        Color backgroundColour = new Color(247, 205, 141);
        chatField.setBackground(backgroundColour);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inputField.getText().trim().length() > 0) {
                    chatField.setText(chatField.getText() + "\n" + inputField.getText());
                    inputField.setText("");
                }
            }
        });

        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputField.postActionEvent();
            }
        });

        add(mainPanel);
        setVisible(true);

    }
}
