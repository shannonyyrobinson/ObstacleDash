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

import java.awt.Color;
import java.awt.Graphics;


public class Obstacle extends Block implements Collidable
{
    private int speed;
    private Color color;
   
    
    public Obstacle()
    {
        super(800,350,50,100,Color.black);
        speed = 3;
        
    }
    
    public Obstacle(Color c){
        super (800, 350, 50, 100);
        speed = 3;
        color = c;
    }
    
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    public void setColor(Color c)
    {
        color = c;
    }
    
    public void move(Graphics window)
    {
        draw(window, Color.DARK_GRAY);
        setX(getX() - speed);
        draw(window); 
    }

    public boolean didCollideTop(Block obstacle)
    {
        return (obstacle.getY()+obstacle.getHeight() >= getY());
    }
    
    public boolean didCollideBottom(Block obstacle)
    {
        return (obstacle.getY() <= getY()+getHeight());
    }
    
    public boolean didCollideLeft(Block obstacle)
    {
        return (obstacle.getX()+obstacle.getWidth() >= getX());
    }

    public boolean didCollideRight(Block obstacle)
    {

        return (obstacle.getX() <= getX()+getWidth());
    }

}
