/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import static holidayflood2.MainPanel.COLORS;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aaronmonick
 */
class ButtonPanel extends JPanel {

    final JButton[] colorButtons = new JButton[ COLORS.length ];
    
    ButtonPanel() {
        GridLayout gridLayout = new GridLayout(1, COLORS.length);
        setLayout(gridLayout);
            
        for( int i = 0; i < MainPanel.COLORS.length; i++ ) {    
            
            JButton button = new JButton();
            button.setPreferredSize( new Dimension( 10, 40 ) );
            button.setBackground( COLORS[i] );
            add( button );
            colorButtons[i] = button;
	}
    }
}
