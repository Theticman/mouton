package mouton;

public class Cercle extends Ellipse implements Calculs{
	
	public Cercle(final Point centre, final double rayon) {
		super(centre, rayon, rayon);
	}
	
	public Cercle(final int centre_x, final int centre_y, final double rayon) {
		super(centre_x,centre_y,rayon,rayon);
	}
	
	@Override
	public String toString() {
		return "Cercle [Centre: " + this.getCentre() + "; Rayon: " + this.demi_grand_axe + "]";
	}

	@Override
	public double mesurer_perimetre() {
		return 2 * Math.PI * this.demi_grand_axe;
	}

	@Override
	public double mesurer_air() {
		return Math.PI * this.demi_grand_axe*this.demi_grand_axe;
	}
}
