package system.view;

import system.current.CurrentUser;
import system.entity.ContactInformation;
import system.entity.Poll;
import system.service.ContactInformationService;
import system.service.PollCategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePollListener implements ActionListener {
    private JTextField nameOfCategory;
    private JTextField name;
    private JTextField description;

    public CreatePollListener(JTextField nameOfCategory, JTextField name, JTextField description) {
        this.nameOfCategory = nameOfCategory;
        this.name = name;
        this.description = description;
    }

    public void actionPerformed(ActionEvent e) {
        Poll newPoll = new Poll();
        newPoll.setName(name.getText());
        newPoll.setDescription(description.getText());
        newPoll.setMaxResult(0);
        newPoll.setContactInformation(new ContactInformationService().findByUserId(CurrentUser.getId()));
        newPoll.setPollCategory(new PollCategoryService().findByCategoryName(nameOfCategory.getText()));
    }
}
