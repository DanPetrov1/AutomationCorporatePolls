package system.controller;

import system.controller.ExitListener;
import system.controller.MainMenuListener;
import system.controller.UpdateProfileListener;
import system.view.CreatePollListener;

import javax.swing.*;

public class CreatePollWindow {
    private JButton submit;
    private JButton back;
    private JButton exit;
    private JFrame frame;
    private JLabel pollName;
    private JLabel categoryName;
    private JLabel pollDescription;
    private JTextField name;
    private JTextField nameOfCategory;
    private JTextField description;

    public CreatePollWindow() {
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

        pollName.setBounds(100, 50, 100,30);
        categoryName.setBounds(100, 100, 100,30);
        pollDescription.setBounds(100,150,100,30);

        panel.add(pollName);
        panel.add(categoryName);
        panel.add(pollDescription);

        name.setBounds(200, 50, 150, 30);
        nameOfCategory.setBounds(200, 100, 150, 30);
        description.setBounds(200,150,150,30);

        panel.add(name);
        panel.add(nameOfCategory);
        panel.add(description);

        submit.setBounds(50, 200, 150,30);
        back.setBounds(225, 200, 150,30);
        exit.setBounds(325, 250, 100,30);

        panel.add(submit);
        panel.add(exit);

        frame.getContentPane().add(panel);
    }

    private void constructFrame() {
        frame = new JFrame("Создание нового опроса");

        submit = new JButton("Подтвердить");
        back = new JButton("Назад");
        exit = new JButton("Выход");
        categoryName = new JLabel("Тема: ");
        pollName = new JLabel("Название опроса: ");
        pollDescription = new JLabel("Вопрос: ");
        name = new JTextField();
        nameOfCategory = new JTextField();
        description = new JTextField();

        submit.addActionListener(new CreatePollListener(nameOfCategory, name, description));
        back.addActionListener(new MainMenuListener(frame));
        exit.addActionListener(new ExitListener());
    }

    public void run() {
        frame.setVisible(true);
    }
}
