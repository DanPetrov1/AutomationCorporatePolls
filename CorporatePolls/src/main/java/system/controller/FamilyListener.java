package system.controller;

import system.current.CurrentUser;
import system.entity.Poll;
import system.entity.PollForm;
import system.service.PollService;
import system.view.PollWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class FamilyListener implements ActionListener {
    private JFrame jFrame;

    public FamilyListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public void actionPerformed(ActionEvent e) {
        PollService pollService = new PollService();
        try {
            List<Poll> pollList = pollService.getAllByCategoryId(1);
            List<PollForm> pollFormList = pollService.getPollFormByUserId(CurrentUser.getId());
            for (int i = 0; i < pollList.size(); i++) {
                for (int j = 0; j < pollFormList.size(); j++) {
                    if (pollFormList.get(j).getPoll() == pollList.get(i)) {
                        pollList.remove(i);
                    }
                }
            }
            if (pollList.size() < 1) {
                JOptionPane.showMessageDialog(null,  "Нет ни одного не пройденного " +
                                "опроса на данную тему!",
                        "Опросы на тему \"Семья\"", JOptionPane.ERROR_MESSAGE);
            } else {
                jFrame.dispose();
                new PollWindow(pollList, "Family").run();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
