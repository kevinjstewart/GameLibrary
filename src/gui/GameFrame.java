
package gui;

import static gui.GuiConstants.ADD_PANEL_TEXT;
import static gui.GuiConstants.EDIT_PANEL_TEXT;
import gui.panels.AddCard;
import gui.panels.EditCard;
import gui.panels.ViewPanel;
import io.FileIO;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Class: GameFrame
 * @author Kevin Stewart <kevinjstew@gmail.com>
 */

public class GameFrame extends JFrame implements GuiConstants, ActionListener {

    private AddCard add;
    private EditCard edit;
    private ViewPanel view;
    private JButton refreshButton;

    
    /*
        The layout of edit is pretty messed up due to a last minute change
        but everything works pretty well other than that
    */
    
    
    
    public GameFrame(String title) throws HeadlessException, IOException {
        // JFrame formalities
        super(title);
        setSize(new Dimension(500,450));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // init panels
        add = new AddCard();
        edit = new EditCard();
        view = new ViewPanel();
        
        // Creates refresh button and add listener
        refreshButton = new JButton("Refresh Game List");
        refreshButton.setActionCommand(REFRESH_BUTTON_TEXT);
        refreshButton.addActionListener((ActionEvent e) -> {
            if (e.getActionCommand().equals(REFRESH_BUTTON_TEXT)) {
                try {
                    refreshEntries();
                } catch (IOException ex) {
                    Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        refreshButton.setMnemonic('r');
        
        c.ipadx = PADDING;
        c.ipady = PADDING;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 2;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        String[] topBoxContents = {ADD_PANEL_TEXT, EDIT_PANEL_TEXT};
        JComboBox topBox = new JComboBox(topBoxContents);
        // Centers the text in the JComboBox 
        ((JLabel)topBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        topBox.addItemListener((ItemEvent e) -> {
            JComboBox localCombo = (JComboBox)e.getSource();
            String selectedItem = localCombo.getSelectedItem().toString();
            switch (selectedItem) {
                case ADD_PANEL_TEXT:
                    edit.setVisible(false);
                    add.setVisible(true);
                    validate();
                    try {
                        refreshEntries();
                    } catch (IOException asd) {
                        System.err.println("sad");
                    }
                    break;
                case EDIT_PANEL_TEXT:
                    add.setVisible(false);
                    edit.setVisible(true);
                    validate();
                    try {
                        refreshEntries();
                    } catch (IOException asd) {
                        System.err.println("sad");
                    }
                    break;
                default:
                    System.err.println("Default triggered, should never happen!");
                    break;
            }
        });
        topBox.setEditable(false);
        topBox.setVisible(true);
        add(topBox, c);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 0;
        c.weighty = 0;
        add(add,c);
        add(edit, c);
        edit.setVisible(false);
        c.gridx++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.EAST;
        add(view, c);
        c.gridy++;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridwidth = 2;
        add(refreshButton, c);
        refreshButton.setVisible(true);
        
        validate();
        pack();
        setVisible(true);
        refreshEntries();
    }
    
    
    /**
     * Refreshes view pane with entries
     * @throws IOException 
     */
    public void refreshEntries() throws IOException {
        view.resetText();
        for (int i = 0; i < FileIO.getTotalRecords(); i++) {
            String[] a = FileIO.readRecords(i);
            view.appendTo(a[0] + "\n");
            view.appendTo(a[1] + "\n");
            view.appendTo(a[2]+"\n");
            view.appendTo(a[3]+"\n");
            view.appendTo(a[4]+"\n");
            view.appendTo(a[5] + "\n\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    
}
