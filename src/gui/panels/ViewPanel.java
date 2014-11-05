
package gui.panels;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Class: GameFrame
 * @author Kevin Stewart <kevinjstew@gmail.com>
 */
public class ViewPanel extends JPanel {
    
    JTextArea viewPane;
    
    public ViewPanel() {
        viewPane = new JTextArea();
        JScrollPane viewScroll = new JScrollPane(viewPane);
        
        
        viewScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        viewScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        viewScroll.setPreferredSize(new Dimension(350,300));
        add(viewScroll);
    }
    
    public void appendTo(String append) {
        viewPane.append(append);
    }
    
    public void resetText() {
        viewPane.setText("");
    }
    
    
}
