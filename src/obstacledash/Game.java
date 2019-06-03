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
import javax.swing.JFrame;
import java.awt.Component;

public class Game extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private static ObstacleDash game;

    public Game()
    {
        super("ObstacleDash");
        setSize(WIDTH,HEIGHT);

        game = new ObstacleDash();
        ((Component)game).setFocusable(true);
        getContentPane().add(game);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}