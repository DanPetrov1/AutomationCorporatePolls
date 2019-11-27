package system.controller;

import system.current.CurrentUser;
import system.entity.User;
import system.service.UserService;
import system.view.MainMenuWindow;
import system.view.RegistrationWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class AuthorizationListener implements ActionListener {
    private JTextField username;
    private JPasswordField password;
    private JFrame frame;

    public AuthorizationListener(JTextField username, JPasswordField password, JFrame frame) {
        this.username = username;
        this.password = password;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        UserService userService = new UserService();
        try {
            List<User> users = userService.getUser();
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i).getName().equals(this.username.getText()) &&
                        users.get(i).getPassword().equals(String.valueOf(this.password.getPassword()))) {
                    JOptionPane.showMessageDialog(null,  "Авторизация пользователя прошла успешно!",
                            "Авторизация", JOptionPane.INFORMATION_MESSAGE);
                    new MainMenuWindow().run();
                    CurrentUser currentUser = new CurrentUser();
                    CurrentUser.setId(users.get(i).getId());
                    CurrentUser.setName(users.get(i).getName());
                    CurrentUser.setEmail(users.get(i).getEmail());
                    CurrentUser.setPassword(users.get(i).getPassword());
                    frame.dispose();
                    return;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,  "Неверное имя пользователя или пароль!",
                "Ошибка авторизации", JOptionPane.ERROR_MESSAGE);
        username.setText("");
        password.setText("");
    }
}
