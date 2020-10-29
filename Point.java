package mouton;

public class Point {
	
	protected double posX = 0;
	protected double posY = 0;

	public Point() {
	}
	
	public Point(final double posX, final double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public String toString() {
		return "(" + this.posX + "," + this.posY + ")";
	}
	
}
