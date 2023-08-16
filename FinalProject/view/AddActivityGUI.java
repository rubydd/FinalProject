package view;

import javax.swing.*;
import java.awt.*;

public class AddActivityGUI extends JFrame {

    private JTextField activityField;
    private JTextField locationField;
    private JTextField dateField;
    private JTextField attendeesField;
    private JTextField expenseField;
    private JButton addButton;
    private JButton backButton;

    public AddActivityGUI(Destination destination) {
        init(destination);
    }

    private void init(Destination destination) {
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Add Activity");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel activityLabel = new JLabel("Activity:");
        activityLabel.setBounds(50, 50, 100, 30);
        activityField = new JTextField();
        activityField.setBounds(150, 50, 250, 30);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(50, 90, 100, 30);
        locationField = new JTextField();
        locationField.setBounds(150, 90, 250, 30);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 130, 100, 30);
        dateField = new JTextField();
        dateField.setBounds(150, 130, 250, 30);

        JLabel attendeesLabel = new JLabel("Attendees:");
        attendeesLabel.setBounds(50, 170, 100, 30);
        attendeesField = new JTextField();
        attendeesField.setBounds(150, 170, 250, 30);

        JLabel expenseLabel = new JLabel("Expense:");
        expenseLabel.setBounds(50, 210, 100, 30);
        expenseField = new JTextField();
        expenseField.setBounds(150, 210, 250, 30);

        addButton = new JButton("Add");
        addButton.setBounds(100, 250, 100, 30);

        backButton = new JButton("Back");
        backButton.setBounds(250, 250, 100, 30);

        this.setLayout(null);
        this.add(activityLabel);
        this.add(activityField);
        this.add(locationLabel);
        this.add(locationField);
        this.add(dateLabel);
        this.add(dateField);
        this.add(attendeesLabel);
        this.add(attendeesField);
        this.add(expenseLabel);
        this.add(expenseField);
        this.add(addButton);
        this.add(backButton);

        addButton.addActionListener(e -> {
           Activity newActivity = new Activity(activityField.getText(), locationField.getText(), dateField.getText(), attendeesField.getText(), expenseField.getText());
            DataBase.getInstance().addActivityToDestination(destination, newActivity);
            clearFields();
        });

        backButton.addActionListener(e -> dispose());

        this.setVisible(true);
    }

    private void clearFields() {
        activityField.setText("");
        locationField.setText("");
        dateField.setText("");
        attendeesField.setText("");
        expenseField.setText("");
    }
}
