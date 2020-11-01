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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(posX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(posY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(posX) != Double.doubleToLongBits(other.posX))
			return false;
		if (Double.doubleToLongBits(posY) != Double.doubleToLongBits(other.posY))
			return false;
		return true;
	}
	
}
