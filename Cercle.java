package mouton;

public class Cercle extends Ellipse implements Calculs, Transformations{
	
	public Cercle(final Point centre, final double rayon) {
		super(centre, rayon, rayon);
	}
	
	public Cercle(final int centre_x, final int centre_y, final double rayon) {
		super(centre_x,centre_y,rayon,rayon);
	}
	
	@Override
	public String toString() {
		return "Cercle [Centre: " + centre.toString() + "; Rayon: " + this.demi_grand_axe + "]";
	}

	@Override
	public double mesurer_perimetre() {
		return 2 * Math.PI * this.demi_grand_axe;
	}

	@Override
	public double mesurer_air() {
		return Math.PI * this.demi_grand_axe*this.demi_grand_axe;
	}

	@Override
	public void appliquer_homotetie(final double scale) {
		this.origine.posX *= scale;
		this.origine.posY *= scale;
		this.centre.posX *= scale;
		this.centre.posY *= scale;
		this.demi_grand_axe *= scale;
		this.demi_petit_axe *= scale;
	}

	@Override
	public void translater(final double dx, final double dy) {
		this.origine.posX += dx;
		this.origine.posY += dy;
		this.centre.posX += dx;
		this.centre.posY += dy;

	}

	@Override
	public void rotater(final int angle) {
		this.rot += angle;
	}

	@Override
	public void symetrie_centrale(final Point centre) {
		this.origine.posX += 2*(centre.posX - this.origine.posX);
		this.origine.posY += 2*(centre.posY - this.origine.posY);
		this.centre.posX += 2*(centre.posX - this.centre.posX);
		this.centre.posY += 2*(centre.posY - this.centre.posY);
		this.rot += 180;
	}

	@Override
	public void symetrie_axiale(final Point point1, final Point point2) {
		double x = ((point1.posX*point2.posY - point2.posX*point1.posY)*(point2.posY - point1.posY) - (this.origine.posY*(point2.posY - point1.posY) - this.origine.posX*(point1.posX - point2.posX)*(point1.posX - point2.posX))) / (Math.pow(point1.posX - point2.posX, 2) + (Math.pow(point2.posY - point1.posY, 2)));
		double y = ((point1.posX*point2.posY - point2.posX*point1.posY)*(point1.posX - point2.posX) - (this.origine.posY*(point2.posY - point1.posY) - this.origine.posX*(point1.posX - point2.posX)*(point2.posY - point1.posY))) / (Math.pow(point1.posX - point2.posX, 2) + (Math.pow(point2.posY - point1.posY, 2)));
		this.origine.posX += 2*(x - this.origine.posX);
		this.origine.posY += 2*(y - this.origine.posY);
		this.centre.posX += 2*(x - this.centre.posX);
		this.centre.posY += 2*(y - this.centre.posY);
	}
}
