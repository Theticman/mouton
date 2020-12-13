package mouton;

/**
 * Classe Point permettant de centraliser
 * la création d'un point.
 */
public class Point {
	
	protected double posX = (int) (Math.random() * 20);
	protected double posY = (int) (Math.random() * 20);

	/**
	 * Un premier constructeur sans paramètre,
	 * attribuant des coordonnées aléatoires.
	 */
	public Point() {
	}
	
	/**
	 * Un constructeur attribuant au point créé, un abscisse
	 * et une ordonnée.
	 * @param posX - Abscisse du nouveau point.
	 * @param posY - Ordonnée du nouveau point.
	 */
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
