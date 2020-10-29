package mouton;

import java.util.HashSet;

public class Dessin implements Calculs{
	
	private HashSet<Image> dessin = new HashSet<Image>();
	private String nom;
	
	public Dessin() {
		this.nom = "Dessin (nom par défaut)";
	}
	
	public Dessin(final String nom) {
		this.nom = nom;
	}
	
	public void ajouter_image(final Image image) {
		dessin.add(image);
	}

	@Override
	public String toString() {
		String out = "-> "+ nom + ":\n";
		for (Image image: dessin) {
			out += image.toString() + "\n";
		}
		return out;
	}
	
	@Override
	public double mesurer_perimetre() {
		double somme = 0;
		for (Image image: dessin) {
			somme += image.mesurer_perimetre();
		}
		return somme;
	}

	@Override
	public double mesurer_air() {
		double somme = 0;
		for (Image image: dessin) {
			somme += image.mesurer_air();
		}
		return somme;
	}
}
