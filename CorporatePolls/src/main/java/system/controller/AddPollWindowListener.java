package system.controller;

import system.entity.Poll;
import system.view.CompletePollWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddPollWindowListener implements ActionListener {
    private Poll poll;
    private List<Poll> pollList;
    private JFrame frame;

    public AddPollWindowListener(Poll poll, JFrame frame, List<Poll> pollList) {
        this.poll = poll;
        this.pollList = pollList;
    }

    public void actionPerformed(ActionEvent e) {
        new CompletePollWindow(poll, pollList).run();
        frame.dispose();
    }
}
