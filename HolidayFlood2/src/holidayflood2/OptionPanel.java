/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aaronmonick
 */
public class OptionPanel extends JPanel {
    
    JButton newGameButton;
    JComboBox difficulty;
    String[] gridChoices = {"8x8", "10x10", "12x12"};
    JLabel curTurnCount;
    JLabel timerLabel;
    
    
    OptionPanel() {
           
        timerLabel = new JLabel("Time: 0");
        add(timerLabel);
        
        difficulty = new JComboBox(gridChoices);
        difficulty.setSelectedIndex(1);
        add(difficulty);
        
        newGameButton = new JButton("New Game");
	add(newGameButton);
        
        curTurnCount = new JLabel("Turn: 0");
        add(curTurnCount);
        
        
    }
}
