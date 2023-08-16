package view;

import javax.swing.*;
import java.awt.*;

public class AddAccommodationGUI extends JFrame {

    private JTextField accommodationNameField;
    private JTextField accommodationTypeField;
    private JButton addButton;
    private JButton backButton;

    public AddAccommodationGUI(Destination destination) {
        init(destination);
    }

    private void init(Destination destination) {
        this.setSize(600, 250);
        this.setLocationRelativeTo(null);
        this.setTitle("Add Accommodation");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel accommodationNameLabel = new JLabel("Accommodation:");
        accommodationNameLabel.setBounds(50, 50, 120, 30);
        accommodationNameField = new JTextField();
        accommodationNameField.setBounds(180, 50, 200, 30);

        JLabel accommodationTypeLabel = new JLabel("Expense:");
        accommodationTypeLabel.setBounds(50, 90, 120, 30);
        accommodationTypeField = new JTextField();
        accommodationTypeField.setBounds(180, 90, 200, 30);

        addButton = new JButton("Add");
        addButton.setBounds(100, 150, 150, 30);

        backButton = new JButton("Back");
        backButton.setBounds(300, 150, 150, 30);

        this.setLayout(null);
        this.add(accommodationNameLabel);
        this.add(accommodationNameField);
        this.add(accommodationTypeLabel);
        this.add(accommodationTypeField);
        this.add(addButton);
        this.add(backButton);

        addButton.addActionListener(e -> {
            Accommodation newAccommodation = new Accommodation(accommodationNameField.getText(), accommodationTypeField.getText());
            DataBase.getInstance().addAccommodationToDestination(destination, newAccommodation);
            accommodationNameField.setText("");
            accommodationTypeField.setText("");
        });

        backButton.addActionListener(e -> dispose());

        this.setVisible(true);
    }
}
