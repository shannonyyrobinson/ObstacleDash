package obstacledash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shann
 */
public interface Collidable
{
    public boolean didCollideTop(Block block);
    public boolean didCollideBottom(Block block);
    public boolean didCollideLeft(Block block);
    public boolean didCollideRight(Block block);
    
}
