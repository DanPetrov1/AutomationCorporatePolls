package system.controller;

import system.view.MainMenuWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuListener implements ActionListener {
    private JFrame frame;

    public MainMenuListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        new MainMenuWindow().run();
        frame.dispose();
    }
}
