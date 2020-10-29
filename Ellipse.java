package mouton;

public class Ellipse extends Forme implements Calculs{
	
	private Point centre;
	protected double demi_grand_axe;
	private double demi_petit_axe;
	
	public Ellipse(final Point centre, final double demi_grand_axe, final double demi_petit_axe) {
		super();
		this.centre = centre;
		this.demi_grand_axe = demi_grand_axe;
		this.demi_petit_axe = demi_petit_axe;
	}
	
	public Ellipse(final int centre_x, final int centre_y, final double demi_grand_axe, final double demi_petit_axe) {
	super();
	this.centre = new Point(centre_x,centre_y);
	this.demi_grand_axe = demi_grand_axe;
	this.demi_petit_axe = demi_petit_axe;
	}
	
	public Point getCentre() {
		return centre;
	}

	@Override
	public String toString() {
		return "Ellipse [Centre: " + centre.toString() + "; Demi grand axe: " + demi_grand_axe + "; Demi petit axe: " + demi_petit_axe + "]";
	}

	@Override
	public double mesurer_perimetre() {
		return Math.PI * (3*(this.demi_grand_axe + this.demi_petit_axe) - Math.sqrt((3*this.demi_grand_axe + this.demi_petit_axe)*(this.demi_grand_axe + 3*this.demi_petit_axe)));
	}

	@Override
	public double mesurer_air() {
		return Math.PI * this.demi_grand_axe * this.demi_petit_axe;
	}
}