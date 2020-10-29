package mouton;

abstract class Forme extends Point {

	protected Point origine = new Point((int) (Math.random() * 20),(int) (Math.random() * 20));
	protected int rot = (int) (Math.random() * 360);
	protected double echelle = 1.0;
	
	public Forme() {
	}
	
	public Forme(final int posX, final int posY, final int rot, final double echelle) {
		this.origine.posX = posX;
		this.origine.posY = posY;
		this.rot = rot;
		this.echelle = echelle;
	}

	public String infos_generales() {
		return "(Origine: (" + this.origine.posX + "," + this.origine.posY + "); Rotation: " + rot + "; Echelle: " + echelle + ")";
	}

	protected abstract double mesurer_perimetre();

	protected abstract double mesurer_air();
}