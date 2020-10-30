package mouton;

import java.util.HashSet;

public class Image implements Calculs, Transformations{
	
	private HashSet<Forme> image = new HashSet<Forme>();
	private String nom;

	public Image() {
		this.nom = "Image (nom par défaut)";
	}
	
	public Image(final String nom) {
		this.nom = nom;
	}
	
	public void ajouter_forme(final Forme forme) {
		image.add(forme);
	}
	
	public HashSet<Forme> getImage() {
		return image;
	}

	@Override
	public String toString() {
		String out = "    -> " + nom + ":\n";
		for (Forme forme: image) {
			out += "        -> " + forme.toString() + " " + forme.infos_generales() + "\n";
		}
		return out;
	}

	@Override
	public double mesurer_perimetre() {
		double somme = 0;
		for (Forme forme: image) {
			somme += forme.mesurer_perimetre();
		}
		return somme;
	}

	@Override
	public double mesurer_air() {
		double somme = 0;
		for (Forme forme: image) {
			somme += forme.mesurer_air();
		}
		return somme;
	}

	@Override
	public void appliquer_homotetie(double scale) {
		for (Forme forme: image) {
			forme.appliquer_homotetie(scale);
		}		
	}

	@Override
	public void translater(double dx, double dy) {
		for (Forme forme: image) {
			forme.translater(dx, dy);
		}	
	}

	@Override
	public void rotater(int angle) {
		for (Forme forme: image) {
			forme.rotater(angle);
		}	
	}

	@Override
	public void symetrie_centrale(Point point) {
		for (Forme forme: image) {
			forme.symetrie_centrale(point);
		}
	}

	@Override
	public void symetrie_axiale(Point point1, Point point2) {
		for (Forme forme: image) {
			forme.symetrie_axiale(point1, point2);
		}
	}
}
