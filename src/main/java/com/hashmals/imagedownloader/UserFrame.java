package com.hashmals.imagedownloader;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HashmalS on 21.02.2016.
 * @author Sergey Soroka
 */
public class UserFrame extends JFrame {
    private JPanel searchPanel;
    private JSplitPane splitPane;

    public UserFrame() {
        super("4chan Thread Image Downloader");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        searchPanel = new SearchPanel();
        getContentPane().add(searchPanel).setVisible(true);

        JList listScroll = new JList();
        JScrollPane listScrollPane = new JScrollPane(listScroll);
        listScrollPane.setPreferredSize(new Dimension(100, 300));

        JScrollPane imageScrollPane = new JScrollPane();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, imageScrollPane);
        splitPane.setMinimumSize(new Dimension(300, 300));
        splitPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        getContentPane().add(splitPane).setVisible(true);
    }
}
