/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package obstacledash;

import javax.swing.JFrame;
import java.awt.Component;

/**
 *
 * @author shann
 */
public class ObstacleDash extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    public ObstacleDash()
	{
		
		setSize(WIDTH,HEIGHT);

		ObstacleDash game = new ObstacleDashGame();

		((Component)game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);

		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		ObstacleDash run = new ObstacleDash();
	}
}
