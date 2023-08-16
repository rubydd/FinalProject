package view;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MainGUI extends JFrame {

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

        JButton addDestinationBtn = new JButton("Add Destination");
        addDestinationBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        addDestinationBtn.setBounds(200, 300, 400, 40);
        contentPanel.add(addDestinationBtn);

        JButton viewDestinationBtn = new JButton("View Destinations");
        viewDestinationBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        viewDestinationBtn.setBounds(200, 350, 400, 40);
        contentPanel.add(viewDestinationBtn);

        JButton exportButton = new JButton("Export to Text File");
        exportButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        exportButton.setBounds(200, 400, 400, 40);
        contentPanel.add(exportButton);

        JButton backButton = new JButton("Close");
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setBounds(200, 450, 400, 40);
        contentPanel.add(backButton);


        backButton.addActionListener(e -> {
            dispose();
        });

       exportButton.addActionListener(e -> {
            if (exportDestinations()) {
            JOptionPane.showMessageDialog(null, "Destinations exported successfully!");
            }
        });

        viewDestinationBtn.addActionListener(e -> {
            new ViewDestinationGUI();
        });

        addDestinationBtn.addActionListener(e -> {
            new AddDestinationGUI();
        });
    }
    
    private boolean exportDestinations() {
        DataBase db = DataBase.getInstance();
        List<Destination> destinations = db.getDestinations();

        if (destinations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No destinations to export!");
            return false;
        }

        StringBuilder sb = new StringBuilder();

        for (Destination destination : destinations) {
            sb.append(destination.toString()).append("\n");

            for (Activity activity : destination.getActivityList()) {
                sb.append("\t").append(activity.toString()).append("\n");
            }

            for (Accommodation accommodation : destination.getAccommodationList()) {
                sb.append("\t").append(accommodation.toString()).append("\n");
            }

            sb.append("\n");
        }

        File file = new File("destinations.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public MainGUI() {
        init();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }
}
