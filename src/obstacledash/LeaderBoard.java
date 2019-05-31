/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacledash;

/**
 *                                                                             
 * @author shann
 */
public interface LeaderBoard {
    public void setName(String name);
    public String getName();
    
    public void setHighscore(int highscore);
    public int getHighscore();
}
