/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package holidayflood2;

/**
 *
 * @author aaronmonick
 */
public class Score {
    public String name;
    public int gridSize, numOfTurns, time;
    
    public Score(String name, int gridSize, int numOfTurns, int time) {
        this.name = name;
        this.gridSize = gridSize;
        this.numOfTurns = numOfTurns;
        this.time = time;
    }
}
