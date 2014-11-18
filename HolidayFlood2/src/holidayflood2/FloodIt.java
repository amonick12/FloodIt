/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import java.awt.event.ActionListener;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author aaronmonick
 */
public class FloodIt {
    static ActionListener MainPanel;
    
        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new MainFrame();
    }
}
