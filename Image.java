package mouton;

import java.util.HashSet;

public class Image {
	
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
	
	@Override
	public String toString() {
		String out = "    -> " + nom + ":\n";
		for (Forme forme: image) {
			out += "        -> " + forme.toString() + " " + forme.infos_generales() + "\n";
		}
		return out;
	}
}
