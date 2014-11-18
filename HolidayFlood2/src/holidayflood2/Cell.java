/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author aaronmonick
 */
public class Cell {
    
    public Color color;
 
    public Cell(Color color) {
        this.color = color;
    }
    
    public void draw(Graphics2D g2d, int row, int col) {
        g2d.setColor( color );
        g2d.fillRect( row, col, MainPanel.SQUARE_SIZE, MainPanel.SQUARE_SIZE );
        g2d.drawRect( row, col, MainPanel.SQUARE_SIZE, MainPanel.SQUARE_SIZE );
    }
}
