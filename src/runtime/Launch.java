
package runtime;

import gui.GameFrame;
import io.FileIO;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Stewart
 */
public class Launch {
    public GameFrame gframe;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws HeadlessException, IOException {
        try {
            FileIO.init();
//            FileIO.readRecords(2);
        } catch (IOException ex) {
            System.err.println("IOException.");
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GameFrame gframe = new GameFrame("Game Library");
    }
    
}
