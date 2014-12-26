package Domain;

import javax.swing.JButton;

//import javax.swing.ImageIcon;

public class Lokum {

	
	private int coordX;
	private int coordY;
	private int lokumID;
	private JButton loki;// 0-rose, 1-coconut, 2-brown hazelnut, 3-greenpistachio 
	
	
	//private ImageIcon image;

	//public abstract void destroy(Lokum[][] boardState);
	
	public void setButton(JButton lok) {
		this.loki = lok;
		
	}
	
	public JButton getButton() {
		return loki;
	}
	

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int Xcoord) {
		this.coordX = Xcoord;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	public void setLokum(int id, int x, int y) {
		this.setCoordX(x);
		this.setCoordY(y);
		this.setLokumID(id);
		
		
	}

	public int getLokumID() {
		return lokumID;
	}

	public void setLokumID(int lokumID) {
		this.lokumID = lokumID;
	}

//	public void setImage(ImageIcon image) {
//		this.image = image;
//	}
}
