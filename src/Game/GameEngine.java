package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameEngine {
	
	private int level;
	private Board board;

	public GameEngine() {
		final JFrame levelFrame = new JFrame();
		JLabel levels = new JLabel ("Choose Level");
		levels.setBounds(50,25,100,25);
		JButton level1 = new JButton("Level 1");
		level1.setBounds(40,60,100,30);
		level1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				board.level = 1;
				levelFrame.dispose();
			}
		});
		JButton level2 = new JButton("Level 2");
		level2.setBounds(80, 60, 100, 30);
		level2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				board.level = 2;
				levelFrame.dispose();
			}
		});
		
		levelFrame.add(levels);
		levelFrame.setSize(300, 300);
		levelFrame.add(level1);
		levelFrame.add(level2);
		levelFrame.setLayout(null);
		levelFrame.setLocationRelativeTo(null);
		levelFrame.setVisible(true);
		levelFrame.setAlwaysOnTop(true);
		
		
		final JFrame gameFrame = new JFrame("Chewy Lokum Legend");
		ChewyLokumLegend game = new ChewyLokumLegend();
		
		
		

		
	}

}
