
package gui.panels;

import gui.GameFrame;
import gui.GuiConstants;
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
 * Class: AddCard
 * @author Kevin Stewart <kevinjstew@gmail.com>
 */
public class AddCard extends JPanel implements GuiConstants {

    private JTextField nameBox;
    private JTextField systemBox;
    private JTextField genreBox;
    private JTextField yearBox;
    private JTextField priceBox;
    private JTextField ratingBox;
    
    public AddCard() {
        
        //Name, Genre, Year, Platform, Price, Rating
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel nameLabel = new JLabel("Game name:");
        JLabel systemLabel = new JLabel("System:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel priceLabel = new JLabel("Price:");
        JLabel ratingLabel = new JLabel("Rating (1-9):");
        
        nameBox = new JTextField("", 15);
        systemBox = new JTextField("", 15);
        genreBox = new JTextField("", 15);
        yearBox = new JTextField("", 15);
        priceBox = new JTextField("", 6);
        ratingBox = new JTextField("", 1);
        JButton saveButton = new JButton("Save");
        // Anonymous (Lambda) ActionListener for Save Button
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nametemp = nameBox.getText();
                String genretemp =genreBox.getText();
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
                        FileIO.writeRecord(new Game(
                                nametemp, ratetemp, yeartemp, genretemp, systemp, pricetemp));
                                
                    } catch (IOException ex) {
                        Logger.getLogger(AddCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        saveButton.setMnemonic('s');
        
        c.ipadx = PADDING;
        c.ipady = PADDING;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        
        
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
        add(saveButton, c);
    }

    /**
     * @return the nameBox
     */
    public JTextField getNameBox() {
        return nameBox;
    }

    /**
     * @return the systemBox
     */
    public JTextField getSystemBox() {
        return systemBox;
    }

    /**
     * @return the genreBox
     */
    public JTextField getGenreBox() {
        return genreBox;
    }

    /**
     * @return the yearBox
     */
    public JTextField getYearBox() {
        return yearBox;
    }

    /**
     * @return the priceBox
     */
    public JTextField getPriceBox() {
        return priceBox;
    }

    /**
     * @return the ratingBox
     */
    public JTextField getRatingBox() {
        return ratingBox;
    }
}
