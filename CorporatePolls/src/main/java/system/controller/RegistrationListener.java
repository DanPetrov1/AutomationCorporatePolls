package system.controller;

import system.entity.User;
import system.service.UserService;
import system.view.AuthorizationWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class RegistrationListener implements ActionListener {
    private JFrame frame;
    private JTextField name;
    private JPasswordField password;
    private JTextField email;
    private User newUser;

    public RegistrationListener(JFrame frame, JTextField name, JPasswordField password, JTextField email) {
        this.frame = frame;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void actionPerformed(ActionEvent e) {
        UserService userService = new UserService();
        try {
            newUser = new User();
            newUser.setName(name.getText());
            newUser.setPassword(String.valueOf(password.getPassword()));
            newUser.setEmail(email.getText());
            System.out.println(newUser.toString());
            List<User> users = userService.getUser();
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i).equals(newUser)) {
                    JOptionPane.showMessageDialog(null,  "Данный пользователь уже существует!",
                            "Ошибка регистрации", JOptionPane.ERROR_MESSAGE);
                    name.setText("");
                    password.setText("");
                    email.setText("");
                    return;
                }
            }
            userService.add(newUser);
            JOptionPane.showMessageDialog(null,  "Пользователь успешно зарегистрирован!",
                    "Регистрация", JOptionPane.INFORMATION_MESSAGE);
            new AuthorizationWindow().run();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        frame.dispose();
    }
}
