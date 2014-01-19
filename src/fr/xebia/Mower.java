package fr.xebia;

public class Mower {

	private int posX;
	private int posY;
	private Direction direction;
	private Lawn lawn;

	public Mower(int posX, int posY, Direction direction, Lawn p) {
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
		this.lawn = p;
	}

	public void avancer() {

		if (isBlocked())
			return;

		switch (this.direction) {
		case N:
			this.posY += 1;
			break;
		case E:
			this.posX += 1;
			break;
		case W:
			this.posX -= 1;
			break;
		case S:
			this.posY -= 1;
			break;
		}
	}

	public void tourner(char direction) {

		if (isBlocked())
			return;

		if (direction == 'D') {
			switch (this.direction) {
			case N:
				this.direction = Direction.E;
				break;
			case E:
				this.direction = Direction.S;
				break;
			case W:
				this.direction = Direction.N;
				break;
			case S:
				this.direction = Direction.W;
				break;
			}
		} else if (direction == 'G') {
			switch (this.direction) {
			case N:
				this.direction = Direction.W;
				break;
			case E:
				this.direction = Direction.N;
				break;
			case W:
				this.direction = Direction.S;
				break;
			case S:
				this.direction = Direction.E;
				break;
			}
		}
	}

	public boolean isBlocked() {
		return !(this.posX >= 0 && this.posX <= lawn.getCornerX() && this.posY >= 0
				&& this.posY <= lawn.getCornerY()) ;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}



	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "[ " + posX + ", " + posY + ", " + direction + "]";
	}

}
