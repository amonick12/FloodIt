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
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainPanel extends JPanel implements ActionListener {

    public final static int SQUARE_SIZE = 40;
    public static int gridSize = 10;
        

    public static Color[] COLORS = new Color[] { Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.ORANGE };
    public static Color[] COLORS1 = new Color[] { Color.BLACK, Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.ORANGE };
    public static Color[] COLORS2 = new Color[] { Color.GREEN, Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.ORANGE };
    public static Color[] COLORS3 = new Color[] { Color.PINK, Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.ORANGE };

    //Panels
    private ButtonPanel buttonPanel;
    private final GamePanel gamePanel;
    private final OptionPanel optionPanel;    
    //Timer
    Timer timer;
    int delay = 0;
    int i = 0;
    
    MainFrame frame;
    int index;
        
    public MainPanel()  {
        //Container content = getContentPane();
        setBackground(Color.WHITE);
        BorderLayout layout = new BorderLayout();
        layout.setVgap(5);
        setLayout(layout);
        
        delay = 1000; //milliseconds
        timer = new Timer(delay, this);
        timer.start();
        
        //gamePanel
        gamePanel = new GamePanel();
	gamePanel.init();
	add(gamePanel, BorderLayout.CENTER);
        
        //optionPanel
	optionPanel = new OptionPanel();
        optionPanel.newGameButton.addActionListener(this);
        //optionPanel.difficulty.addActionListener(this);
        add(optionPanel, BorderLayout.PAGE_END);
        
        //let gamePanel change the optionPanel turn label
        gamePanel.optionPanel = optionPanel;
        //let game panel stop the timer
        gamePanel.mainPanel = this;
        
        
        
        
    }
    
    public void setColors(int index) {
        if (index == 0) { COLORS = COLORS1; }
        if (index == 1) { COLORS = COLORS2; }
        if (index == 2) { COLORS = COLORS3; }
    
        //buttonPanel
        buttonPanel = new ButtonPanel();
        for( int i = 0; i < COLORS.length; i++ ) {    
            buttonPanel.colorButtons[i].addActionListener(this);
        }
	add(buttonPanel, BorderLayout.PAGE_START);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == optionPanel.newGameButton) {
            // Needs to resize the frame
            int choice = optionPanel.difficulty.getSelectedIndex();
            int curGridSize = gridSize;
            if (choice == 0) { gridSize = 8; }
            if (choice == 1) { gridSize = 12; }
            if (choice == 2) { gridSize = 16; }
               
            //new game reset properties
            optionPanel.curTurnCount.setText("Turn: 0");
            optionPanel.timerLabel.setText("Time: 0");
            gamePanel.turnCount = 0;
            gamePanel.init();
            
            timer.stop();
            i = 0;
            timer.start();
            
            //repack the frame if gridSize changed
            if (curGridSize != gridSize) {
                frame.pack();
            }
        
	} else if (source == timer) {
            String timeCount = Integer.toString(i++);
            optionPanel.timerLabel.setText("Time: "+timeCount);
        } else {
            for(int i = 0; i < buttonPanel.colorButtons.length; i++) {
		// determine the clicked color and start to process with it
		if(source == buttonPanel.colorButtons[i]) {
                    gamePanel.process( COLORS[i] );
                    break;
		}
            }
	}

	gamePanel.repaint();
    }
    
}
