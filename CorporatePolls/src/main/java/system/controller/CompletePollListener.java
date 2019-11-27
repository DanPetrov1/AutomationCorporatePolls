package system.controller;

import system.current.CurrentUser;
import system.entity.Poll;
import system.entity.PollForm;
import system.entity.User;
import system.service.PollCategoryService;
import system.service.PollFormService;
import system.service.UserService;
import system.view.CompletePollWindow;
import system.current.CurrentUser;
import system.view.PollWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CompletePollListener implements ActionListener {
    private Poll poll;
    private List<Poll> pollList;
    private JFrame frame;
    private JTextField pollResult;

    public CompletePollListener(Poll poll, List<Poll> pollList, JFrame frame, JTextField pollResult) {
        this.poll = poll;
        this.pollList = pollList;
        this.frame = frame;
        this.pollResult = pollResult;
    }

    public void actionPerformed(ActionEvent e) {
        if (Integer.parseInt(pollResult.getText()) > poll.getMaxResult()
                || Integer.parseInt(pollResult.getText()) < 0) {
            JOptionPane.showMessageDialog(null,  "Введён неправильный результат!",
                    "Ответ на вопрос", JOptionPane.ERROR_MESSAGE);
            new CompletePollWindow(poll, pollList).run();
        }
        else {
            PollForm pollForm = new PollForm();
            pollForm.setPoll(poll);
            pollForm.setUser(new UserService().findUserById(CurrentUser.getId()));
            try {
                new PollFormService().add(pollForm);
                new PollWindow(pollList, poll.getPollCategory().getName());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        frame.dispose();
    }
}
