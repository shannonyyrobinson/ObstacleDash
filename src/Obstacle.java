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

public abstract class Obstacle implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public Obstacle() {
        xPos = 10;
        yPos = 10;
        width = 10;
        height = 10;
    }

    public Obstacle(int x, int y) {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public Obstacle(int x, int y, int w, int h) {
        //add code here
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public void setPos(int x, int y) {
        //add code here
        xPos = x;
        yPos = y;
    }

    public void setX(int x) {
        //add code here
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getX() {
        return xPos;  
    }

    public int getY() {
        return yPos;  
    }

    public void setWidth(int w) {
        //add code here
        width = w;
    }

    public void setHeight(int h) {
        //add code here
        height  = h;
    }

    public int getWidth() {
        return width;  
    }

    public int getHeight() {
        return height;  
    }

    public abstract void move(String direction);

    public abstract void draw(Graphics window);

    public String toString() {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}