package mouton;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Classe Image recensant des formes uniques
 * stockées dans une liste issue de la collection HashSet.
 */
public class Image implements Calculs, Transformations{
	
	private HashSet<Forme> image = new HashSet<Forme>();
	private String nom;

	/**
	 * Chaque nouvelle image est une liste vide
	 * prête à recevoir des formes.
	 * Ce constructeur donne un nom par défaut à l'image.
	 */
	public Image() {
		this.nom = "Image (nom par défaut)";
	}
	
	/**
	 * Chaque nouvelle image est une liste vide
	 * prête à recevoir des formes.
	 * Ce constructeur donne un nom donné en paramètre à l'image.
	 * @param nom Nom de l'image créée.
	 */
	public Image(final String nom) {
		this.nom = nom;
	}
	
	/**
	 * Cette méthode permet d'ajouter une forme à l'image
	 * si elle n'y est pas encore présente.
	 * @param forme Objet à ajouter à la liste.
	 */
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
	public double mesurer_aire() {
		double somme = 0;
		for (Forme forme: image) {
			somme += forme.mesurer_aire();
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
	
	public ArrayList<Forme> trier_image_selon_perimetre() {
		ArrayList<Forme> trier = new ArrayList<Forme>(this.image);
		for (int i = 0; i < trier.size(); i++) {
			double min = Double.POSITIVE_INFINITY;
			int min_index = i;
			for (int j = i; j < trier.size(); j++) {
				double perimetre = trier.get(j).mesurer_perimetre();
				if (perimetre < min) {
					min = perimetre;
					min_index = j;
				}
			}
			Forme temp = trier.get(min_index);
			trier.set(min_index, trier.get(i));
			trier.set(i, temp);
		}
		return trier;
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
