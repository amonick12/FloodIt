/*
 * Flood It
 */

package holidayflood2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainPanel extends JPanel implements ActionListener {

    public final static int SQUARE_SIZE = 30;
    public static int gridSize = 12;
        
    public final static Color[] COLORS = new Color[] { Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE };

    //Panels
    private final ButtonPanel buttonPanel;
    private final GamePanel gamePanel;
    private final OptionPanel optionPanel;    
    
    MainFrame frame;
        
    public MainPanel()  {
        //Container content = getContentPane();
        setBackground( Color.WHITE );
        BorderLayout layout = new BorderLayout();
        layout.setVgap( 10 );
        setLayout( layout );
        
        //gamePanel
        gamePanel = new GamePanel();
	gamePanel.init();
	add( gamePanel, BorderLayout.CENTER );
        
        //optionPanel
	optionPanel = new OptionPanel();
        optionPanel.newGameButton.addActionListener(this);
        //optionPanel.difficulty.addActionListener(this);
        add(optionPanel, BorderLayout.PAGE_END);
        
        //let gamePanel change the optionPanel turn label
        gamePanel.optionPanel = optionPanel;
        
        //buttonPanel
        buttonPanel = new ButtonPanel();
        for( int i = 0; i < COLORS.length; i++ ) {    
            buttonPanel.colorButtons[i].addActionListener(this);
        }
	add( buttonPanel, BorderLayout.PAGE_START );
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if( source == optionPanel.newGameButton ) {
            // Needs to resize the frame
            int choice = optionPanel.difficulty.getSelectedIndex();
            if (choice == 0) { gridSize = 8; }
            if (choice == 1) { gridSize = 10; }
            if (choice == 2) { gridSize = 12; }
                    
            //new game reset properties
            optionPanel.curCount.setText("Turn: 0");
            gamePanel.turnCount = 0;
            gamePanel.init();
            frame.pack();
            
	} else {
            for( int i = 0; i < buttonPanel.colorButtons.length; i++ ) {
		// determine the clicked color and start to process with it
		if( source == buttonPanel.colorButtons[i] ) {
                    gamePanel.process( COLORS[i] );
                    break;
		}
            }
	}

	gamePanel.repaint();
    }
    
}
