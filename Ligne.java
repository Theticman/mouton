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
		this.epaisseur *= scale;
	}

	@Override
	public void translater(final double dx, final double dy) {
		this.origine.posX = this.origine.posX + dx;
		this.origine.posY = this.origine.posY + dy;
	}

	@Override
	public void rotater(final int angle) {
		this.rot += angle;
	}

	@Override
	public void symetrie_centrale(final Point centre) {
		this.origine.posX += 2*(centre.posX - this.origine.posX);
		this.origine.posY += 2*(centre.posY - this.origine.posY);
		this.rot = this.rot + 180;
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
}
