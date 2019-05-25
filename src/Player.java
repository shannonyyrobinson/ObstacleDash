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

public class Player extends Obstacle{
    private int speed;

   public Player()
   {
	  this(10, 10);
   }

   public Player(int x, int y)
   {
	   super(x, y, 10, 10, Color.BLACK);
	   setSpeed(5);
   }
   
   public Paddle (int x, int y, int spee)
   {
	   super(x, y, 10, 10, Color.BLACK);
	   setSpeed(spee);
   }
   
   public Player (int x, int y, int width, int height, int spee)
   {
	   super (x, y, width, height, Color.BLACK);
	   setSpeed(spee);
   }
   
   public Player (int x, int y, int width, int height, Color col, int spee)
   {
	   super (x, y, width, height, col);
	   setSpeed(spee);
   }
   
   public void setSpeed(int spee)
   {
	   speed = spee;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()-speed);
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()+speed);
	   draw(window);
   }

   public int getSpeed()
   {
	   return speed;
   }   
   
   public String toString()
   {
	   return super.toString()+" "+speed;
   }
}
