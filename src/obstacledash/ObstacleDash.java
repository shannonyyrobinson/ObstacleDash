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
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

public class ObstacleDash extends Canvas implements KeyListener, Runnable {

    private boolean[] keys;
    private BufferedImage back;
    private int score;
    private boolean jump;

    private Obstacle obstacle;
    private LeaderBoard leaderBoard;
    private int[] obstacleHeight;
    private Player player;

    private boolean jumped;
    int increasesp;
    int ospeedafter;
    int pspeedafter;
    boolean paused = false;

    public ObstacleDash() {
        keys = new boolean[4];

        obstacleHeight = new int[4];
        for (int i = 1; i <= 4; i++) {
            obstacleHeight[i - 1] = 25 * i;
        }

        setBackground(Color.DARK_GRAY);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);

        player = new Player();
        obstacle = new Obstacle();

        leaderBoard = new LeaderBoard();

        increasesp = 0;
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(350, 0, 200, 150);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("LEADERBOARD", 375, 10);
        graphToBack.drawString("CURRENT SCORE: " + score, 375, 50);
        graphToBack.drawString("HIGH SCORE: " + leaderBoard.get(), 375, 100);
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(0, 450, 800, 200);

        player.draw(graphToBack);
        if (jump == true) {
            player.move(graphToBack);
            if (player.getY() == 250) {
                player.setSpeed(-2);
            }
            if (player.getY() == 400) {
                jump = false;
                player.setSpeed(5);
            }
        }

        obstacle.move(graphToBack);
        if (obstacle.getX() + obstacle.getWidth() <= 0) {
            score++;
            increasesp = 0; //Chloe
            if (obstacle.getSpeed() < 8 && score % 5 == 0 && increasesp < 1) { //Chloe
                obstacle.increaseSpeed(); //Shannon
                increasesp++; //Chloe
            }
            obstacle.draw(graphToBack, Color.DARK_GRAY);
            obstacle.setHeight(obstacleHeight[(int) (Math.random() * 4)]);
            obstacle.setX(800);
            obstacle.setY(400 - (obstacle.getHeight() - 50));
            obstacle.move(graphToBack);

        }

        if (obstacle.didCollideBottom(player) == true && obstacle.didCollideTop(player) == true && obstacle.didCollideLeft(player) == true
                && obstacle.didCollideRight(player) == true) {
            //Michael
            if (player.loseLife()) {
                obstacle.setSpeed(0);
                player.setSpeed(0);
                graphToBack.setColor(Color.GREEN);
                graphToBack.drawString("GAMEOVER", 400, 300); //Shannon
                try {
                    leaderBoard.save(score);
                } catch (IOException ex) {
                    Logger.getLogger(ObstacleDash.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                player.movePast(graphToBack, obstacle.getX() + obstacle.getWidth() + 5);
            }
        }

        if (keys[0] == true) {
            jump = true;
        }

        //restarts the game
        if (keys[1] == true) {
            score = 0;
            obstacle.draw(graphToBack, Color.DARK_GRAY);
            obstacle.setHeight((int) (Math.random() * 50) + 50);
            obstacle.setX(800);
            obstacle.setY(400 - (obstacle.getHeight() - 50));
            obstacle.move(graphToBack);
            obstacle.setSpeed(3);
            player.draw(graphToBack, Color.DARK_GRAY);
            player.setY(400);
            player.draw(graphToBack);
            player.setLives(3); //Shannon
        }

        if (paused == false) {
            ospeedafter = obstacle.getSpeed();
            pspeedafter = player.getSpeed();
            if (player.getY() < 450) {
                jumped = true;
            }
        }

        //Chloe - pauses the game
        if (keys[2] == true) {
            paused = true;
            //ospeedafter = obstacle.getSpeed();
            //pspeedafter = player.getSpeed();
            obstacle.setX(obstacle.getX());
            obstacle.setY(obstacle.getY());
            player.setX(player.getX());
            player.setY(player.getY());
            obstacle.setSpeed(0);
            player.setSpeed(0);
            //debug
            System.out.println(ospeedafter);
            System.out.println(pspeedafter);
            
            //lynne
            graphToBack.setColor(Color.BLUE);
            graphToBack.drawString("PAUSE", 400, 300);

        }

        if (keys[3] == true) {
            obstacle.setSpeed(ospeedafter);
            player.setSpeed(pspeedafter);
            if (jumped == true) {
                player.move(graphToBack);
                if (player.getY() == 250) {
                    player.setSpeed(-2);
                }
                if (player.getY() == 400) {
                    jump = false;
                    player.setSpeed(5);
                }
                obstacle.move(graphToBack);
                player.move(graphToBack);
                paused = false;
            }
        }
            twoDGraph.drawImage(back, null, 0, 0);
        }
    

    

    public void update(Graphics window) {
        paint(window);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case KeyEvent.VK_SPACE:
                keys[0] = true;
                break;
            case KeyEvent.VK_ENTER:
                keys[1] = true;
                break;
            //Chloe - pause game
            case KeyEvent.VK_P:
                keys[2] = true;
                break;
            //Chloe - resume game
            case KeyEvent.VK_R:
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case KeyEvent.VK_SPACE:
                keys[0] = false;
                break;
            case KeyEvent.VK_ENTER:
                keys[1] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
