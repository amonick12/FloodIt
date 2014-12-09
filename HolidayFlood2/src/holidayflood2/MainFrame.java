/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author aaronmonick
 */
public class MainFrame extends JFrame implements ActionListener {
    MainPanel mainPanel;
    StartPanel startPanel;
    
    MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        super("Holiday Flood");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        
        startPanel = new StartPanel();
        add(startPanel);
        startPanel.halloweenButton.addActionListener(this);
        startPanel.christmasButton.addActionListener(this);
        startPanel.easterButton.addActionListener(this);
        
        mainPanel = new MainPanel();
        //add(mainPanel);
        mainPanel.frame = this;        
        //mainPanel.setVisible(false);
        
        pack();
	setResizable(true);
	setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == startPanel.halloweenButton) {
            mainPanel.setColors(0);
        }
        if (source == startPanel.christmasButton) {
            mainPanel.setColors(1);
        }
        if (source == startPanel.easterButton) {
            mainPanel.setColors(2);
        }
        
        remove(startPanel);
        add(mainPanel);
        pack();
    }
}
