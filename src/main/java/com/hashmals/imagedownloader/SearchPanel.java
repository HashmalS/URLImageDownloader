package com.hashmals.imagedownloader;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HashmalS on 21.02.2016.
 * @author Sergey Soroka
 */
public class SearchPanel extends JPanel {
    private static final String labelText = "Enter link:";
    private static JTextField linkField;
    private static JButton searchButton;

    public SearchPanel() {
        setLayout(new FlowLayout());
        setSize(500, 100);

        JLabel label = new JLabel(labelText, JLabel.TRAILING);
        add(label);

        linkField = new JTextField();
        label.setLabelFor(linkField);
        linkField.setPreferredSize(new Dimension(250, 20));
        add(linkField);

        searchButton = new JButton();

        Icon searchIcon = new ImageIcon("src/main/resources/Images/5-search-icon.png");
        searchButton.setIcon(searchIcon);
        add(searchButton);
    }
}
