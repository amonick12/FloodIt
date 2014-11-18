/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aaronmonick
 */
public class GamePanel extends JPanel {
    
    Cell[][] grid = new Cell[ MainPanel.gridSize ][ MainPanel.gridSize ];

    int turnCount = 0;
    
    public void init() {
	// Populate the grid with random colored squares
	for( int row = 0; row < grid.length; row++ ) {
            for( int col = 0; col < MainPanel.gridSize; col++ ) {
                grid[ row ][ col ] = new Cell( MainPanel.getRandomColor() );
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
	}
        
        //check if grid is filled
        boolean completed = true;
	TEST: for( int row = 0; row < grid.length; row++ ) {
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
            JOptionPane.showMessageDialog( this, "Congratulations. You needed " + turnCount + " turns.", "Completed", JOptionPane.PLAIN_MESSAGE );
            
            //restart the game
            init();
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
}
