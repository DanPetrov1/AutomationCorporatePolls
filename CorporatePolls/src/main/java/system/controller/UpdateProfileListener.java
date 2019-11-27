package system.controller;

import system.entity.User;
import system.service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateProfileListener implements ActionListener {
    private JTextField name;
    private JPasswordField password;
    private JTextField email;
    private UserService userService;

    public UpdateProfileListener(JTextField name, JPasswordField password, JTextField email) {
        this.name = name;
        this.password = password;
        this.email = email;
        userService = new UserService();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (name.getText().equals("") || String.valueOf(password.getPassword()).equals("") ||
                    email.getText().equals("")) {
                JOptionPane.showMessageDialog(null,  "Данный пользователь уже существует или" +
                                " Вы ничего не отредактировали!",
                        "Ошибка редактирования", JOptionPane.ERROR_MESSAGE);
                return;
            }
            User updateUser = new User();
            updateUser.setName(name.getText());
            updateUser.setPassword(String.valueOf(password.getPassword()));
            updateUser.setEmail(email.getText());
            ArrayList<User> userList = new ArrayList<User>(userService.getUser());
            for (User user : userList) {
                if (user.equals(updateUser)) {
                    JOptionPane.showMessageDialog(null,  "Данный пользователь уже существует или" +
                                    " Вы ничего не отредактировали!",
                            "Ошибка редактирования", JOptionPane.ERROR_MESSAGE);
                    name.setText("");
                    password.setText("");
                    email.setText("");
                    return;
                }
            }
            userService.update(updateUser);
            JOptionPane.showMessageDialog(null,  "Профиль отредактирован!",
                    "Редактирование", JOptionPane.INFORMATION_MESSAGE);
            name.setText("");
            password.setText("");
            email.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
