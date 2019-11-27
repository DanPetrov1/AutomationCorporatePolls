package system.view;

import system.controller.ExitListener;
import system.controller.MainMenuListener;
import system.controller.RegistrationListener;
import system.controller.UpdateProfileListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfileWindow {
    private JButton submit;
    private JButton back;
    private JButton exit;
    private JFrame frame;
    private JLabel login;
    private JLabel userPassword;
    private JLabel userEmail;
    private JTextField name;
    private JPasswordField password;
    private JTextField email;

    public EditProfileWindow() {
        constructFrame();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    private void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,350);
        frame.setLocation(600,100);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        login.setBounds(100, 50, 100,30);
        userPassword.setBounds(100, 100, 100,30);
        userEmail.setBounds(100,150,100,30);

        panel.add(login);
        panel.add(userPassword);
        panel.add(userEmail);

        name.setBounds(200, 50, 150, 30);
        password.setBounds(200, 100, 150, 30);
        email.setBounds(200,150,150,30);

        password.setEchoChar('*');
        panel.add(name);
        panel.add(password);
        panel.add(email);

        submit.setBounds(50, 200, 150,30);
        back.setBounds(225, 200, 150,30);
        exit.setBounds(325, 250, 100,30);

        panel.add(submit);
        panel.add(exit);

        frame.getContentPane().add(panel);
    }

    private void constructFrame() {
        frame = new JFrame("Профиль пользователя");

        submit = new JButton("Подтвердить");
        back = new JButton("Назад");
        exit = new JButton("Выход");
        login = new JLabel("Логин: ");
        userPassword = new JLabel("Пароль: ");
        userEmail = new JLabel("Email");
        name = new JTextField();
        password = new JPasswordField();
        email = new JTextField();

        submit.addActionListener(new UpdateProfileListener(name, password, email));
        back.addActionListener(new MainMenuListener(frame));
        exit.addActionListener(new ExitListener());
    }

    public void run() {
        frame.setVisible(true);
    }
}
