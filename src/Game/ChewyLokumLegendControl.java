package Game;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChewyLokumLegendControl {
	private static boolean running = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Board board = new Board();
		board.start();
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				System.out.println("id :" + board.boardState[i][j].getLokumID() + " - coords : (" + i + "," + j +")" );
				
			}}

	//asks the user if he wants to start to write start, then checks if the string is start makes running true so game enters the while loop.	
		String op =  JOptionPane.showInputDialog("to start write start :");
		
	    if (op.equals("start")){
	    	running = true;
     	
	    
	    while (running) {
     		
     		
     		
     		
	// getting the coordinates for the first lokum and setting it to firstPressedLokum from boardState.	
		int lokum1X;
		Scanner sx = new Scanner(System.in);
		System.out.println("Enter the Xcoord for your first lokum(0-8) :");
		lokum1X = sx.nextInt();
//		board.firstPressedLokum.setCoordX(lokum1X);
		int lokum1Y;
		Scanner sy = new Scanner(System.in);
		System.out.println("Enter the Ycoord for your first lokum(0-8) :");
		lokum1Y = sy.nextInt();
//		board.firstPressedLokum.setCoordY(lokum1Y);
		board.firstPressedLokum = board.boardState[lokum1X][lokum1Y];
		
		
	// getting the cordinates for the second lokum and setting to secondPressedLokum from boardState.	
		int lokum2X;
		Scanner sx2 = new Scanner(System.in);
		System.out.println("Enter the Xcoord for your second lokum(0-8) :");
		lokum2X = sx2.nextInt();
//		board.firstPressedLokum.setCoordX(lokum1X);
		int lokum2Y;
		Scanner sy2 = new Scanner(System.in);
		System.out.println("Enter the Ycoord for your second lokum(0-8) :");
		lokum2Y = sy2.nextInt();
//		board.firstPressedLokum.setCoordY(lokum1Y);
		board.secondPressedLokum = board.boardState[lokum2X][lokum2Y];
		
		
	//swapping the selected two lokums, if combination generated print out the combination code, type and the board with its final form	
		board.swap(board.boardState, board.firstPressedLokum, board.secondPressedLokum);
		board.moveDown(board.boardState);
		System.out.println("number of lokums combined :" + board.combinationCode + ", combination type : " + board.combinationType);
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				System.out.println("id :" + board.boardState[i][j].getLokumID() + " - coords : (" + i + "," + j +")" );
				
			}}
	//asks the user if she wants to stop or not, if he types stop, game terminates. If he types any other thing game continues.
		String operation = JOptionPane.showInputDialog("if you want to stop write stop, to continue write any key :");
		if (operation.equals("stop")) {
			running = false;
		}} 
		}
     	System.exit(0);
		
		
		
	}

}
