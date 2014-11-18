/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author aaronmonick
 */
public class MainFrame extends JFrame {
    MainPanel mainPanel;
    
    MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        super("Holiday Flood");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        
        
        mainPanel = new MainPanel();
        add(mainPanel);
        mainPanel.frame = this;        
                
        pack();
	setResizable( true );
	setVisible( true );
    }
}
