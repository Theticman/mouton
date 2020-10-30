package mouton;

public class Ligne extends Forme implements Calculs, Transformations{
	
	private Point point1;
	private Point point2;
	double epaisseur;
	
	public Ligne(Point point1, Point point2, double epaisseur) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.epaisseur = epaisseur;
	}
	
	public Ligne(final int point1_x, final int point1_y, final int point2_x, final int point2_y, final double epaisseur) {
		super();
		this.point1 = new Point(point1_x, point1_y);
		this.point2 = new Point(point2_x, point2_y);
		this.epaisseur = epaisseur;
	}

	@Override
	public String toString() {
		return "Ligne [Point1: " + point1.toString() + "; Point2: " + point2.toString() + "; Epaisseur: " + epaisseur + "]";
	}

	@Override
	public double mesurer_perimetre() {
		return 2 * (epaisseur + Math.sqrt(Math.pow(point1.posX - point2.posX, 2) + Math.pow(point1.posY - point2.posY, 2)));
	}

	@Override
	public double mesurer_air() {
		return epaisseur * Math.sqrt(Math.pow(point1.posX - point2.posX, 2) + Math.pow(point1.posY - point2.posY, 2));
	}
	
	@Override
	public void appliquer_homotetie(final double scale) {
		this.origine.posX *= scale;
		this.origine.posY *= scale;
		this.point1.posX *= scale;
		this.point1.posY *= scale;
		this.point2.posX *= scale;
		this.point2.posY *= scale;
		this.epaisseur *= scale;
	}

	@Override
	public void translater(final double dx, final double dy) {
		this.origine.posX += dx;
		this.origine.posY += dy;
		this.point1.posX += dx;
		this.point1.posY += dy;
		this.point2.posX += dx;
		this.point2.posY += dy;
	}

	@Override
	public void rotater(final int angle) {
		this.rot += angle;
	}

	@Override
	public void symetrie_centrale(final Point centre) {
		this.origine.posX += 2*(centre.posX - this.origine.posX);
		this.origine.posY += 2*(centre.posY - this.origine.posY);
		this.point1.posX += 2*(centre.posX - this.point1.posX);
		this.point1.posY += 2*(centre.posY - this.point1.posY);
		this.point2.posX += 2*(centre.posX - this.point2.posX);
		this.point2.posY += 2*(centre.posY - this.point2.posY);
	}

	@Override
	public void symetrie_axiale(final Point point1, final Point point2) {
		double x = ((point1.posX*point2.posY - point2.posX*point1.posY)*(point2.posY - point1.posY) - (this.origine.posY*(point2.posY - point1.posY) - this.origine.posX*(point1.posX - point2.posX)*(point1.posX - point2.posX))) / (Math.pow(point1.posX - point2.posX, 2) + (Math.pow(point2.posY - point1.posY, 2)));
		double y = ((point1.posX*point2.posY - point2.posX*point1.posY)*(point1.posX - point2.posX) - (this.origine.posY*(point2.posY - point1.posY) - this.origine.posX*(point1.posX - point2.posX)*(point2.posY - point1.posY))) / (Math.pow(point1.posX - point2.posX, 2) + (Math.pow(point2.posY - point1.posY, 2)));
		this.origine.posX += 2*(x - this.origine.posX);
		this.origine.posY += 2*(y - this.origine.posY);
		this.point1.posX += 2*(x - this.point1.posX);
		this.point1.posY += 2*(y - this.point1.posY);
		this.point2.posX += 2*(x - this.point2.posX);
		this.point2.posY += 2*(y - this.point2.posY);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(epaisseur);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((point1 == null) ? 0 : point1.hashCode());
		result = prime * result + ((point2 == null) ? 0 : point2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ligne other = (Ligne) obj;
		if (Double.doubleToLongBits(epaisseur) != Double.doubleToLongBits(other.epaisseur))
			return false;
		if (point1 == null) {
			if (other.point1 != null)
				return false;
		} else if (!point1.equals(other.point1))
			return false;
		if (point2 == null) {
			if (other.point2 != null)
				return false;
		} else if (!point2.equals(other.point2))
			return false;
		return true;
	}
}
