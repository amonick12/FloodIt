/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holidayflood2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author stephenjohnwrightfarrington
 */
public class StartPanel extends JPanel
{
    //JPanel startPanel = new JPanel();
    //MainFrame frame;
    JLabel title = new JLabel("Holiday Flood");
    JButton halloweenButton = new JButton("Halloween");
    JButton christmasButton = new JButton("Christmans");
    JButton easterButton = new JButton("Easter");
    //boolean drawMainPanel = false;
    //String selectedHoliday = "";
    
    public StartPanel(){
        //ImageIcon blackIcon = new ImageIcon("black.png");
        //JLabel blackIconLabel = new JLabel(blackIcon);
        //add(blackIconLabel);
        //JButton blackButton = new JButton(blackIcon);
        //add(blackButton);
        add(title);
        add(halloweenButton);
        add(christmasButton);
        add(easterButton);
    }
    
//    public boolean getDrawMainPanel()
//    {
//        return drawMainPanel;
//    }
//    
//    public String getSelectedHoliday()
//    {
//        return selectedHoliday;
//    }
    


    
     
}
