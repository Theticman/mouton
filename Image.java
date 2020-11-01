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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
}
