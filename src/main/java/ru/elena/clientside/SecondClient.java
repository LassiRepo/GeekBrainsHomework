package ru.elena.clientside;

import javax.swing.*;
import java.awt.*;

public class SecondClient extends BaseClient {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SecondClient::new);
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(0, 189, 148);
    }

}
