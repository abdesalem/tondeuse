package fr.program;

import org.junit.Before;
import org.junit.Test;

import fr.program.Direction;
import fr.program.Lawn;
import fr.program.Mower;

public class MowerTest {

	Mower mower;
	Lawn lawn;

	@Before
	public void init() {
		lawn = new Lawn(5, 5);
		mower = new Mower(1, 3, Direction.N, lawn);
	}

	@Test
	public void turnMowerToNorth() {
		mower.tourner('D');
		assert mower.getDirection() == Direction.E;
	}
	
	@Test
	public void avancer(){
		mower.avancer();
		assert mower.getPosX()==6;
	}
}
