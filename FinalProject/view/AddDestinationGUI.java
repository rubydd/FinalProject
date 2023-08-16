package view;

import javax.swing.*;
import java.awt.*;

public class AddDestinationGUI extends JFrame {

    private JTextField locationField;
    private JTextField dateField;

    private void init() {
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setTitle(getClass().getSimpleName());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        this.add(contentPanel);

        JLabel titleLable = new JLabel(getClass().getSimpleName(), SwingConstants.CENTER);
        titleLable.setFont(new Font("微软雅黑", Font.PLAIN, 50));
        titleLable.setBounds(200, 15, 400, 100);
        contentPanel.add(titleLable);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        locationLabel.setBounds(200, 150, 150, 30);
        contentPanel.add(locationLabel);

        locationField = new JTextField();
        locationField.setBounds(360, 150, 240, 30);
        contentPanel.add(locationField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        dateLabel.setBounds(200, 200, 150, 30);
        contentPanel.add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(360, 200, 240, 30);
        contentPanel.add(dateField);

        JButton addDestinationBtn = new JButton("Add Destination");
        addDestinationBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        addDestinationBtn.setBounds(200, 300, 400, 40);
        contentPanel.add(addDestinationBtn);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        resetButton.setBounds(200, 400, 190, 40);
        contentPanel.add(resetButton);

        JButton closeButton = new JButton("Back");
        closeButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        closeButton.setBounds(410, 400, 190, 40);
        contentPanel.add(closeButton);

        addDestinationBtn.addActionListener(e -> {
            addDestination();
        });

        resetButton.addActionListener(e -> {
            resetFields();
        });

        closeButton.addActionListener(e -> {
            dispose();
        });
    }

    private void addDestination() {
        String location = locationField.getText().trim();
        String date = dateField.getText().trim();

        if (location.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean added = DataBase.getInstance().addDestination(location, date);

        if (added) {
            JOptionPane.showMessageDialog(this, "Destination added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            resetFields();
        } else {
            JOptionPane.showMessageDialog(this, "Location already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        locationField.setText("");
        dateField.setText("");
    }

    public AddDestinationGUI() {
        init();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddDestinationGUI();
            }
        });
    }
}
