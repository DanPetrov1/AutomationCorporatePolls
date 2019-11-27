package system.view;

import system.controller.AddPollWindowListener;
import system.controller.MainMenuListener;
import system.entity.Poll;
import system.service.PollService;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollWindow {
    private ArrayList<Poll> pollList;
    private ArrayList<JLabel> headersArrayList;
    private ArrayList<JLabel> labelArrayList;
    private ArrayList<JButton> buttonArrayList;
    private JButton back;
    private String type;
    private JFrame frame;

    public PollWindow(List<Poll> pollList, String type) throws SQLException {
        this.pollList = new ArrayList<Poll>();
        this.pollList.addAll(pollList);
        this.type = type;
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

        for (int i = 0; i < labelArrayList.size(); i++) {
            headersArrayList.get(i).setBounds(100,50 + i * 100, 100,30);
            labelArrayList.get(i).setBounds(100, 80 + i * 100, 300,30);
            panel.add(labelArrayList.get(i));
            buttonArrayList.get(i).setBounds(100, 110 + i * 100, 300, 30);
            panel.add(buttonArrayList.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);
        frame.getContentPane().add(panel);
    }

    private void constructFrame() {
        frame = new JFrame("Опросы по теме " + type);
        headersArrayList = new ArrayList<JLabel>();
        labelArrayList = new ArrayList<JLabel>();
        buttonArrayList = new ArrayList<JButton>();

        for (int i = 0; i < pollList.size(); i++) {
            headersArrayList.add(new JLabel(pollList.get(i).getId() + " " + pollList.get(i).getName()));
            labelArrayList.add(new JLabel(pollList.get(i).getDescription()));
            buttonArrayList.add(new JButton("Пройти опрос"));
            buttonArrayList.get(i).addActionListener(new AddPollWindowListener(pollList.get(i), frame, pollList));
        }

        back = new JButton("Назад");
        back.addActionListener(new MainMenuListener(frame));
    }

    public void run() {
        frame.setVisible(true);
    }
}
