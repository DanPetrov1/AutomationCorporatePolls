package system.view;

import system.controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuWindow {
    private JFrame frame;
    private JLabel type;
    private JButton addPoll;
    private JButton family;
    private JButton work;
    private JButton culture;
    private JButton edit;
    private JButton exit;

    public MainMenuWindow() {
        constructFrame();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    private void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocation(600,100);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        type.setBounds(100, 50, 400,30);
        panel.add(type);

        family.setBounds(100,100,100,30);
        work.setBounds(225,100,100,30);
        culture.setBounds(350,100,100,30);
        panel.add(family);
        panel.add(work);
        panel.add(culture);

        edit.setBounds(200,200,200,30);
        exit.setBounds(200,300,100,30);
        panel.add(edit);
        panel.add(exit);

        frame.getContentPane().add(panel);
    }

    private void constructFrame() {
        frame = new JFrame("Главное меню");

        type = new JLabel("Выберите раздел для прохождения опросов:");
        family = new JButton("Семья");
        work = new JButton("Работа");
        culture = new JButton("Культура");
        edit = new JButton("Редактировать профиль");
        exit = new JButton("Выход");
        addPoll = new JButton("Добавить опрос");

        addPoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreatePollWindow().run();
            }
        });
        family.addActionListener(new FamilyListener(frame));
        work.addActionListener(new WorkListener(frame));
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new EditProfileWindow().run();
            }
        });
    }

    public void run() {
        frame.setVisible(true);
    }
}

