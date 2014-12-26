package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Game.Board;

public class ChewyLokumLegend extends Canvas implements Runnable {


	
	public static final int WIDTH = 700, HEIGHT = 700;
	
	public static Board board = new Board();
	static JButton specialSwap;
	static JLabel noSpecial;


	
	

	
	
	private void start() {
		// TODO Auto-generated method stub
	board.start();

	}
	
	
	private void stop() {
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	
	}
	 public static void openGame() {
			

			
			final JFrame gameFrame = new JFrame("Chewy Lokum Legend");
			gameFrame.setSize(WIDTH, HEIGHT);
			gameFrame.setLayout(null);
			gameFrame.setLocationRelativeTo(null);
			gameFrame.setVisible(true);
			
			final ChewyLokumLegend game = new ChewyLokumLegend();
			game.setBounds(100, 100, WIDTH-50, HEIGHT-50);
//			game.setBackground(Color.RED);
			
			gameFrame.add(game);
			game.start();
			for (int i =0; i<9;i++) {
				for (int j=0; j<9; j++) {
					gameFrame.add(board.boardState[i][j].getButton());
				}
			}
			System.out.println("chosen level is : " +board.level);
			JButton exit = new JButton("Exit");
			exit.setBounds(10,10,30,30);
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					openLevel();
					gameFrame.dispose();
				}
			});
			specialSwap = new JButton("Special Swap " );
			
			specialSwap.setBounds(50, 10, 150, 50);
			noSpecial = new JLabel (""+ board.numOfSpecialSwaps);
			noSpecial.setSize(50,60);
			specialSwap.add(noSpecial);
			
			specialSwap.addActionListener(new ActionListener(){
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent event){
					board.numOfSpecialSwaps--;
					board.isSpecialSwap = true;
					
					System.out.println("numOfSpecialSwaps: " + board.numOfSpecialSwaps);
					noSpecial.hide();
					noSpecial = new JLabel (" "+ board.numOfSpecialSwaps);
					noSpecial.setSize(70,55);
					specialSwap.add(noSpecial);
				  
					
				}
			});
			
			gameFrame.add(specialSwap);
			gameFrame.add(exit);
			
	 }
	
	 public static void openLevel() {
		
		 final JFrame levelFrame = new JFrame();
			JLabel levels = new JLabel ("Choose Level");
			levels.setBounds(50,25,100,25);
			JButton level1 = new JButton("Level 1");
			level1.setBounds(40,60,100,30);
			level1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					board.level = 1;
					openGame();
					levelFrame.dispose();
					
				}
			});
			JButton level2 = new JButton("Level 2");
			level2.setBounds(150, 60, 100, 30);
			level2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) {
					board.level = 2;
					openGame();
					levelFrame.dispose();
				}
			});
			
			JButton exit = new JButton("Exit");
			exit.setBounds(10,10,30,30);
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					System.exit(0);
				}
			});
			
			levelFrame.add(levels);
			levelFrame.setSize(400, 200);
			levelFrame.add(level1);
			levelFrame.add(level2);
			levelFrame.add(exit);
			levelFrame.setLayout(null);
			levelFrame.setLocationRelativeTo(null);
			levelFrame.setVisible(true);
			levelFrame.setAlwaysOnTop(true);
			
			
		  
	 }

	public static void main(String[] args) {
		openLevel();
		
		
		
				
		

		
	}
		
	

	








	private void render(Graphics graph, int i) {
		// TODO Auto-generated method stub

	}

	private void init() {
		// TODO Auto-generated method stub

	}

}
