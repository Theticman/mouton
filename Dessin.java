package mouton;

import java.util.HashSet;

public class Dessin {
	
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
}
