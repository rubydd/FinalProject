package view;

import javax.swing.*;
import java.awt.*;

public class EditDestinationGUI extends JFrame {

    private JTextField locationField;
    private JTextField dateField;
    private JButton editButton;
    private JButton backButton;
    private JButton addActivityButton;
    private JButton addAccommodationButton;

    public EditDestinationGUI(Destination destination) {
        init(destination);
    }

    private void init(Destination destination) {
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Edit Destination");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(50, 50, 100, 30);
        locationField = new JTextField(destination.getLocation());
        locationField.setBounds(150, 50, 300, 30);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 90, 100, 30);
        dateField = new JTextField(destination.getDate());
        dateField.setBounds(150, 90, 300, 30);

        editButton = new JButton("Save");
        editButton.setBounds(50, 150, 100, 30);
        
        addActivityButton = new JButton("Add Activity");
        addActivityButton.setBounds(170, 150, 130, 30);

        addAccommodationButton = new JButton("Add Accommodation");
        addAccommodationButton.setBounds(310, 150, 170, 30);

        backButton = new JButton("Back");
        backButton.setBounds(490, 150, 100, 30);

        this.setLayout(null);
        this.add(locationLabel);
        this.add(locationField);
        this.add(dateLabel);
        this.add(dateField);
        this.add(editButton);
        this.add(addActivityButton);
        this.add(addAccommodationButton);
        this.add(backButton);

        editButton.addActionListener(e -> {
            destination.setLocation(locationField.getText());
            destination.setDate(dateField.getText());
            DataBase.getInstance().updateDestination(destination);
        });

        addActivityButton.addActionListener(e -> {
            new AddActivityGUI(destination);
        });

        addAccommodationButton.addActionListener(e -> {
            new AddAccommodationGUI(destination);
        });

        backButton.addActionListener(e -> dispose());

        this.setVisible(true);
    }
}
