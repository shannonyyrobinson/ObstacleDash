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
        super(700,350,50,100,Color.green);
        speed = 3;
        
    }
    
    public Obstacle(Color c){
        super (700, 350, 50, 100);
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
    
    public void increaseSpeed() //Shannon
    {
        speed = speed + 1;
    }
    
    public int getSpeed() //Chloe
    {
        return speed;
    }
    
    public void move(Graphics window)
    {
        draw(window, Color.BLUE);
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
