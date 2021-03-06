/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import static holidayflood2.MainPanel.COLORS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aaronmonick
 */
public class GamePanel extends JPanel {
    
    Cell[][] grid;

    int turnCount = 0;
    //to access the optionPanel turn label
    OptionPanel optionPanel;
    MainPanel mainPanel;
    
    public void init() {
        grid = new Cell[ MainPanel.gridSize ][ MainPanel.gridSize ];

	// Populate the grid with random colored squares
	for( int row = 0; row < MainPanel.gridSize; row++ ) {
            for( int col = 0; col < MainPanel.gridSize; col++ ) {
                grid[ row ][ col ] = new Cell( getRandomColor() );
            }
	}
    }
    
    //process one turn
    public void process( Color newColor ) {
        
        //get reference color
        Color referenceColor = grid[ 0 ][ 0 ].color;
        //fill adjacent cells
        if( referenceColor != newColor ) {
            fill( 0, 0, referenceColor, newColor );
            turnCount++;
            String stringCount = Integer.toString(turnCount);
            optionPanel.curTurnCount.setText("Turn: "+ stringCount);
	}
        
        //check if grid is filled
        boolean completed = true;
	TEST: for( int row = 0; row < MainPanel.gridSize; row++ ) {
                for( int col = 0; col < MainPanel.gridSize; col++ ) {
                    if( grid[ row ][ col ].color != grid[ 0 ][ 0 ].color ) {
			completed = false;
			break TEST;
                    }
		}
            }
        
        //display message if game was completed
        if( completed ) {
            repaint();
            
            mainPanel.timer.stop();
            int endTime = mainPanel.i-1;
            
            JFrame frame = new JFrame("InputDialog Example #1");

            // prompt the user to enter their name
            String name = JOptionPane.showInputDialog(frame, "What's your name?");

            // get the user's input. note that if they press Cancel, 'name' will be null
            System.out.printf("The user's name is '%s'.\n", name);

            //System.exit(0);
            String scoreCards[] = new String[100];
            
            String scoreCard;
            scoreCard = name+" finished in "+endTime+" seconds and needed "+turnCount+" turns";
            scoreCards[0] = scoreCard;
            String filename = "highscore.xml";

            XML_240 x = new XML_240();
            x.openReaderXML(filename);
            int index = 1;
            String ss = (String) x.ReadObject();
            //System.out.println(ss);
            while(!ss.matches("end")) {
                scoreCards[index] = ss;
                ss = (String) x.ReadObject();
                index++;
            }
            
            x.closeReaderXML();
            
            x.openWriterXML(filename);
            
            for (int i = 0; i < index; i++) {
                x.writeObject(scoreCards[i]);
            }
            x.writeObject("end");
            x.closeWriterXML();
            String message = "Congratulations, " + name + "! You finished in " + endTime + " second and you needed " + turnCount + " turns.\n\n\t";
            for (int j = 1; j < index; j++) {
                message += scoreCards[j];
                message += "\n\t";
            }
            JOptionPane.showMessageDialog( this, message, "Complete", JOptionPane.PLAIN_MESSAGE );
            
            //restart the game
            optionPanel.curTurnCount.setText("Turn: 0");
            optionPanel.timerLabel.setText("Time: 0");
            turnCount = 0;
            //init();
	}
    }

    //recursively fills all adjuacent squares of the shape color
    private void fill(int row, int col, Color referenceColor, Color newColor) {
        
        if( grid[ row ][ col ].color == referenceColor ) {

            grid[ row ][ col ].color = newColor;
            if( row < MainPanel.gridSize - 1 ) {
                fill( row + 1, col, referenceColor, newColor );
            }
            if( col < MainPanel.gridSize - 1 ) {
		fill( row, col + 1, referenceColor, newColor );
            }
            if( row > 0 ) {
            	fill( row - 1, col, referenceColor, newColor );
            }
            if( col > 0 ) {
            	fill( row, col - 1, referenceColor, newColor );
            }
	}
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension( MainPanel.SQUARE_SIZE * MainPanel.gridSize, MainPanel.SQUARE_SIZE * MainPanel.gridSize );
    }
    
    //draws the grid and its cells
    @Override
    protected void paintComponent( final Graphics g ) {
	super.paintComponent( g );

	// The coordinates of each square
	int x = 0;
	int y = 0;

	for( Cell[] row : grid ) {
            for( int col = 0; col < MainPanel.gridSize; col++ ) {
		row[ col ].draw( (Graphics2D)g, x, y );
		x += MainPanel.SQUARE_SIZE;
            }

            x = 0;
            y += MainPanel.SQUARE_SIZE;
	}
    }
    
    public static Color getRandomColor() {
	return COLORS[ new Random().nextInt( COLORS.length ) ];
    }
}
