package mouton;

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

	protected abstract double mesurer_air();
}