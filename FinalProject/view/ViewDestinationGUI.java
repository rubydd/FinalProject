package view;

import javax.swing.*;
import java.awt.*;

public class ViewDestinationGUI extends JFrame {
    
    private JList<Destination> destinationsList;
    private DefaultListModel<Destination> listModel;
    private JButton editButton;
    private JButton backButton;
    
    public ViewDestinationGUI() {
        init();
    }
    
    private void init() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("View Destinations");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        listModel = new DefaultListModel<>();
        for (Destination d : DataBase.getInstance().getDestinations()) {
            listModel.addElement(d);
        }

        destinationsList = new JList<>(listModel);
        destinationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        destinationsList.setLayoutOrientation(JList.VERTICAL);
        
        JScrollPane listScrollPane = new JScrollPane(destinationsList);
        listScrollPane.setBounds(100, 50, 600, 400);
        
        editButton = new JButton("Edit Destination");
        editButton.setBounds(100, 500, 200, 40);
        
        backButton = new JButton("Back");
        backButton.setBounds(500, 500, 200, 40);

        this.setLayout(null);
        this.add(listScrollPane);
        this.add(editButton);
        this.add(backButton);
        
        backButton.addActionListener(e -> dispose());
        
        editButton.addActionListener(e -> {
            Destination selectedDestination = destinationsList.getSelectedValue();
            if (selectedDestination != null) {
                new EditDestinationGUI(selectedDestination);
            }
        });
        
        this.setVisible(true);
    }
}
