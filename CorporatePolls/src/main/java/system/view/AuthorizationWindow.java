package system.view;

import system.controller.AuthorizationListener;
import system.controller.ExitListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorizationWindow {
    private JButton submit;
    private JButton registration;
    private JButton exit;
    private JFrame frame;
    private JLabel login;
    private JLabel userPassword;
    private JTextField name;
    private JPasswordField password;

    public AuthorizationWindow() {
        constructFrame();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    private void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocation(600,100);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        login.setBounds(100, 50, 100,30);
        userPassword.setBounds(100, 100, 100,30);

        panel.add(login);
        panel.add(userPassword);

        name.setBounds(200, 50, 150, 30);
        password.setBounds(200, 100, 150, 30);

        password.setEchoChar('*');
        panel.add(name);
        panel.add(password);

        submit.setBounds(50, 150, 150,30);
        registration.setBounds(225, 150, 200, 30);
        exit.setBounds(325, 200, 100,30);

        panel.add(submit);
        panel.add(registration);
        panel.add(exit);

        frame.getContentPane().add(panel);
    }

    private void constructFrame() {
        frame = new JFrame("Авторизация в систему");

        submit = new JButton("Подтвердить");
        registration = new JButton("Зарегистрироваться");
        exit = new JButton("Выход");
        login = new JLabel("Логин: ");
        userPassword = new JLabel("Пароль: ");
        name = new JTextField();
        password = new JPasswordField();

        submit.addActionListener(new AuthorizationListener(name, password, frame));
        registration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegistrationWindow().run();
                frame.dispose();
            }
        });
        exit.addActionListener(new ExitListener());
    }

    public void run() {
        frame.setVisible(true);
    }
}
