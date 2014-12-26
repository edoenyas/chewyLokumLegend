package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameenginetest {
	
	
	public static void main (String[] args) {
		
		 int level;
		 final Board board = new Board();

			final JFrame levelFrame = new JFrame();
			JLabel levels = new JLabel ("Choose Level");
			levels.setBounds(50,25,100,25);
			JButton level1 = new JButton("Level 1");
			level1.setBounds(40,80,100,30);
			level1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					board.level = 1;
					levelFrame.dispose();
					System.out.println(board.level);
					
				}
			});
			JButton level2 = new JButton("Level 2");
			level2.setBounds(150, 80, 100, 30);
			level2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) {
					board.level = 2;
					levelFrame.dispose();
					System.out.println(board.level);
				}
			});
			
			levelFrame.add(levels);
			levelFrame.setSize(300, 200);
			levelFrame.add(level1);
			levelFrame.add(level2);
			levelFrame.setLayout(null);
			levelFrame.setLocationRelativeTo(null);
			levelFrame.setVisible(true);
			levelFrame.setAlwaysOnTop(true);
			

			

		}
	
	

	}


