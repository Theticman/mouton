package mouton;

/**
 * Classe Ellipse descendante de la classe Forme.
 */
public class Ellipse extends Forme implements Calculs, Transformations{
	
	protected Point centre;
	protected double demi_grand_axe;
	protected double demi_petit_axe;
	
	/**
	 * Constructeur prenant un point déjà existant pour centre.
	 * @param centre Point central de l'ellipse.
	 * @param demi_grand_axe Demi grand axe de l'ellipse.
	 * @param demi_petit_axe Demi petit axe de l'ellipse.
	 */
	public Ellipse(final Point centre, final double demi_grand_axe, final double demi_petit_axe) {
		super();
		this.centre = centre;
		this.demi_grand_axe = demi_grand_axe;
		this.demi_petit_axe = demi_petit_axe;
	}
	
	/**
	 * Constructeur prenant les coordonnées d'un point non existant.
	 * @param centre_x Centre abscisse.
	 * @param centre_y Centre ordonnée.
	 * @param demi_grand_axe Demi grand axe de l'ellipse.
	 * @param demi_petit_axe Demi petit axe de l'ellipse.
	 */
	public Ellipse(final int centre_x, final int centre_y, final double demi_grand_axe, final double demi_petit_axe) {
		super();
		this.centre = new Point(centre_x,centre_y);
		this.demi_grand_axe = demi_grand_axe;
		this.demi_petit_axe = demi_petit_axe;
	}


	@Override
	public String toString() {
		return "Ellipse [Centre: " + centre.toString() + "; Demi grand axe: " + demi_grand_axe + "; Demi petit axe: " + demi_petit_axe + "]";
	}

	/**
	 * Mesure du périmètre en utilisant: https://calculis.net/aire/ellipse.
	 * @return Renvoi un double périmètre de l'objet.
	 */
	@Override
	public double mesurer_perimetre() {
		return Math.PI * (3*(this.demi_grand_axe + this.demi_petit_axe) - Math.sqrt((3*this.demi_grand_axe + this.demi_petit_axe)*(this.demi_grand_axe + 3*this.demi_petit_axe)));
	}

	/**
	 * Mesure de l'aire en utilisant: 2*demi_grand_axe*demi_petit_axe.
	 * @return Renvoi un double air de l'objet.
	 */
	@Override
	public double mesurer_aire() {
		return Math.PI * this.demi_grand_axe * this.demi_petit_axe;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(demi_grand_axe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(demi_petit_axe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Ellipse other = (Ellipse) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (Double.doubleToLongBits(demi_grand_axe) != Double.doubleToLongBits(other.demi_grand_axe))
			return false;
		if (Double.doubleToLongBits(demi_petit_axe) != Double.doubleToLongBits(other.demi_petit_axe))
			return false;
		return true;
	}
	
}