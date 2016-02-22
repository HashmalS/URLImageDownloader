package com.hashmals.imagedownloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by HashmalS on 21.02.2016.
 * @author Sergey Soroka
 */
public class UserFrame extends JFrame {
    private JPanel searchPanel;
    private JSplitPane splitPane;
    private LinkExtractor extractor;
    private JButton button;
    private JScrollPane listScrollPane;
    private Logger log;

    public UserFrame() {
        super("4chan Thread Image Downloader");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        searchPanel = new SearchPanel();
        getContentPane().add(searchPanel).setVisible(true);

        listScrollPane = new JScrollPane();

        button = SearchPanel.getSearchButton();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    extractor = new LinkExtractor( SearchPanel.getLinkField().getText());
                }
                catch (IOException ex) {
                    log.log(Level.SEVERE, ex.getMessage());
                }
                JList list = extractor.getList();
                listScrollPane = new JScrollPane(list);
                listScrollPane.repaint();
                listScrollPane.revalidate();
            }
        });


        listScrollPane.setPreferredSize(new Dimension(100, 300));

        JScrollPane imageScrollPane = new JScrollPane();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, imageScrollPane);
        splitPane.setMinimumSize(new Dimension(300, 300));
        splitPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        getContentPane().add(splitPane).setVisible(true);
    }
}
