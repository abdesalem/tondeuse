package fr.xebia;

import java.util.ArrayList;
import java.util.List;

public class Lawn {

	private int cornerX;

	private int cornerY;

	List<Mower> lstTendeuse;

	public Lawn(int coinX, int coinY) {
		this.cornerX = coinX;
		this.cornerY = coinY;
		lstTendeuse = new ArrayList<Mower>();
	}

	public List<Mower> getLstTendeuse() {
		return lstTendeuse;
	}

	public int getCornerX() {
		return cornerX;
	}

	public int getCornerY() {
		return cornerY;
	}

	public void add(Mower tondeuse) {
		this.lstTendeuse.add(tondeuse);
	}
	
	

}
