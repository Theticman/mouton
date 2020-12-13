package mouton;

/**
 * Classe abstraite Forme donnant à toutes les
 * formes, un point d'origine et une rotation.
 */
abstract class Forme extends Point {

	protected Point origine = new Point();
	protected int rot = (int) (Math.random() * 360);
	
	public Forme() {
	}
	
	public Forme(final int posX, final int posY, final int rot, final double echelle) {
		this.origine.posX = posX;
		this.origine.posY = posY;
		this.rot = rot;
	}

	public String infos_generales() {
		return "(Origine: (" + this.origine.posX + "," + this.origine.posY + "); Rotation: " + rot + ")";
	}
	

	protected abstract double mesurer_perimetre();

	protected abstract double mesurer_aire();

	protected abstract void appliquer_homotetie(double scale);

	protected abstract void translater(double dx, double dy);

	protected abstract void rotater(int angle);

	protected abstract void symetrie_centrale(Point point);

	protected abstract void symetrie_axiale(Point point1, Point point2);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
		result = prime * result + rot;
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
		Forme other = (Forme) obj;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (rot != other.rot)
			return false;
		return true;
	}
}