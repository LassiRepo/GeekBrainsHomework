package ru.elena.clientside;

import javax.swing.*;
import java.awt.*;

public class FirstClient extends BaseClient {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FirstClient::new);
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(247, 205, 141);
    }

}
