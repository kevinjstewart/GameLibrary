
package gui.panels;

import gui.GuiConstants;
import static gui.GuiConstants.PADDING;
import io.FileIO;
import io.Game;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class: EditCard
 * @author Kevin Stewart <kevinjstew@gmail.com>
 */
public class EditCard extends JPanel implements GuiConstants {
    
    JTextField editRecord;
    JTextField nameBox;
    JTextField systemBox;
    JTextField genreBox;
    JTextField yearBox;
    JTextField priceBox;
    JTextField ratingBox;
    JButton editButton;
    
    public EditCard() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel nameLabel = new JLabel("Game name:");
        JLabel systemLabel = new JLabel("System:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel priceLabel = new JLabel("Price:");
        JLabel ratingLabel = new JLabel("Rating (1-9):");
        
        editRecord = new JTextField("Record to edit (ex 1, 2)", 15);
        nameBox = new JTextField("", 15);
        systemBox = new JTextField("", 15);
        genreBox = new JTextField("", 15);
        yearBox = new JTextField("", 15);
        priceBox = new JTextField("", 6);
        ratingBox = new JTextField("", 1);
        editButton = new JButton("Edit Entry");
        
        editButton.addActionListener((ActionEvent e) -> {
            if (editRecord.getText().matches("\\d+")) {
                int editChoice = Integer.parseInt(editRecord.getText());
                String nametemp = nameBox.getText();
                String genretemp = genreBox.getText();
                String ratetemp = ratingBox.getText();
                String yeartemp = yearBox.getText();
                String systemp = systemBox.getText();
                String pricetemp = priceBox.getText();
                if (nametemp.length() > 30 ||
                        systemp.length() > 30 ||
                        genretemp.length() > 15 ||
                        yeartemp.length() > 4 ||
                        pricetemp.length() > 10 ||
                        ratetemp.length() > 1) {
                    
                    JOptionPane.showMessageDialog(null,"Please enter values of a valid length");
                    
                } else {
                    try {
                        FileIO.modifyRecords(editChoice ,new Game(
                                nametemp, ratetemp, yeartemp, genretemp, systemp, pricetemp));
                    } catch (IOException ex) {
                        Logger.getLogger(EditCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid record number to edit.");
            }
            editButton.setMnemonic('e');
                

        });
        
        c.ipadx = PADDING;
        c.ipady = PADDING;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        
        add(editRecord, c);
        c.gridy++;
        add(nameLabel, c);
        c.gridy++;
        add(nameBox, c);
        c.gridy++;
        add(systemLabel, c);
        c.gridy++;
        add(systemBox, c);
        c.gridy++;
        add(genreLabel, c);
        c.gridy++;
        add(genreBox, c);
        c.gridy++;
        add(yearLabel, c);
        c.gridy++;
        add(yearBox, c);
        c.gridy++;
        add(priceLabel, c);
        c.gridy++;
        add(priceBox, c);
        c.gridy++;
        add(ratingLabel, c);
        c.gridy++;
        add(ratingBox, c);
        c.gridy++;
        add(editButton, c);
    }
    
    public void disappear() {
        this.setVisible(false);
    }
}
