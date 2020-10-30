package mouton;

public class Point {
	
	protected double posX = (int) (Math.random() * 20);
	protected double posY = (int) (Math.random() * 20);

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
