package mouton;

public class Ligne extends Forme implements Calculs{
	
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
		// TODO Auto-generated method stub
		return epaisseur * Math.sqrt(Math.pow(point1.posX - point2.posX, 2) + Math.pow(point1.posY - point2.posY, 2));
	}
}
