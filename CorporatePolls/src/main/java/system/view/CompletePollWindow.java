package system.view;

import system.controller.CompletePollListener;
import system.entity.Poll;

import javax.swing.*;
import java.util.List;

public class CompletePollWindow {
    private JFrame frame;
    private JLabel mainLabel;
    private JLabel result;
    private JTextField pollResult;
    private JButton submit;
    private Poll poll;
    private List<Poll> pollList;

    public CompletePollWindow(Poll poll, List<Poll> pollList) {
        this.poll = poll;
        this.pollList = pollList;
        constructFrame();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    private void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocation(600,100);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        mainLabel.setBounds(100, 50, 100, 100);
        panel.add(mainLabel);
        result.setBounds(100,150,100,30);
        panel.add(result);
        pollResult.setBounds(100,200,100,30);
        panel.add(pollResult);
        submit.setBounds(100,250, 100, 30);
        panel.add(submit);

        frame.getContentPane().add(panel);
    }

    private void constructFrame() {
        frame = new JFrame("Прохождение опроса");
        mainLabel = new JLabel("Опрос №" + poll.getId() + '\n' + poll.getDescription());
        result = new JLabel("Введите результат:");
        pollResult = new JTextField();
        submit = new JButton("Подтвердить");
        submit.addActionListener(new CompletePollListener(poll, pollList, frame, pollResult));
    }


    public void run() {
        frame.setVisible(true);
    }
}
