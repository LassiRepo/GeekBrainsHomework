package ru.elena.clientside;

import javax.swing.*;
import java.awt.*;

public class ThirdClient extends BaseClient {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ThirdClient::new);
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(255, 183, 255);
    }

}
