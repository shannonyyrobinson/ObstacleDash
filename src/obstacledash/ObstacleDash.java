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
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ObstacleDash extends Canvas implements KeyListener, Runnable
{
    private boolean[] keys;
    private BufferedImage back;
    private int score;
    private boolean jump;
    private Player player;
    private Obstacle obstacle;
    private LeaderBoard leaderBoard;

    public ObstacleDash()
    {
        keys = new boolean[2];

        setBackground(Color.DARK_GRAY);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);
        
        player = new Player();
        obstacle = new Obstacle();
        
        leaderBoard = new LeaderBoard();
    }

    public void paint(Graphics window)
    {
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null)
        {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();
        
        // ground
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(0, 450, 800, 200);
        
        // score
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(350, 0, 200, 150);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("CURRENT SCORE: " + score, 375, 50);
        graphToBack.drawString("HIGH SCORE: " + leaderBoard.get(), 375, 100);
        
        // jump
        player.draw(graphToBack);
        if(jump == true)
        {
            player.move(graphToBack);
            if(player.getY() == 150)
                player.setSpeed(-5);
            if(player.getY() == 400)
            {
                jump = false;
                player.setSpeed(5);
            }
        }
        
        // re draw obstacle
        obstacle.move(graphToBack);
        if(obstacle.getX()+obstacle.getWidth() <= 0)
        {
            obstacle.draw(graphToBack,Color.white);
            obstacle.setHeight((int) (Math.random()*50) + 50);
            obstacle.setX(800);
            obstacle.setY(400-(obstacle.getHeight()-50));
            obstacle.move(graphToBack);
            
            score++;
        }
        
        // collision
        if(obstacle.didCollideBottom(player) == true
        && obstacle.didCollideTop(player) == true
        && obstacle.didCollideLeft(player) == true
        && obstacle.didCollideRight(player) == true)
        {
            obstacle.setSpeed(0);
            player.setSpeed(0);
            try {
                leaderBoard.save(score);
            } catch (IOException ex) {
                Logger.getLogger(ObstacleDash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // level
        if(score == 5)
            obstacle.setSpeed(3);
        if(score == 10)
            obstacle.setSpeed(4);
        if(score == 20)
            obstacle.setSpeed(5);
        if(score == 40)
            obstacle.setSpeed(6);
        
        if (keys[0] == true)
        {
            jump = true;
        }
        if (keys[1] == true)
        {
            score = 0;
            obstacle.draw(graphToBack,Color.DARK_GRAY);
            obstacle.setHeight((int) (Math.random()*50) + 50);
            obstacle.setX(800);
            obstacle.setY(400-(obstacle.getHeight()-50));
            obstacle.move(graphToBack);
            obstacle.setSpeed(2);
            
            player.draw(graphToBack, Color.DARK_GRAY);
            player.setY(400);
            player.draw(graphToBack);
            
            
        }
        twoDGraph.drawImage(back, null, 0, 0);
    }
    
    public void update(Graphics window)
    {
        paint(window);
    }

    public void keyPressed(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case KeyEvent.VK_SPACE:
                keys[0] = true;
                break;
            case 'Q':
                keys[1] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case KeyEvent.VK_SPACE:
                keys[0] = false;
                break;
            case 'Q':
                keys[1] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void run()
    {
        try{
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
