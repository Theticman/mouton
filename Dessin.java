package mouton;

import java.util.HashSet;
import java.util.ArrayList;

/**
 * Classe Dessin recensant des images uniques
 * stockées dans une liste issue de la collection HashSet.
 */
public class Dessin implements Calculs, Transformations{
	
	private HashSet<Image> dessin = new HashSet<Image>();
	private String nom;
	
	/**
	 * Chaque nouveau dessin est une liste vide
	 * prête à recevoir des images.
	 * Ce constructeur donne un nom par défaut au dessin.
	 */
	public Dessin() {
		this.nom = "Dessin (nom par défaut)";
	}
	
	/**
	 * Chaque nouveau dessin est une liste vide
	 * prête à recevoir des images.
	 * Ce constructeur donne un nom donné en paramètre au dessin.
	 * @param nom Nom du dessin créé.
	 */
	public Dessin(final String nom) {
		this.nom = nom;
	}
	
	/**
	 * Cette méthode permet d'ajouter une image au dessin
	 * si elle n'y est pas encore présente.
	 * @param image Objet à ajouter à la liste.
	 */
	public void ajouter_image(final Image image) {
		dessin.add(image);
	}

	public HashSet<Image> getDessin() {
		return dessin;
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
	public double mesurer_aire() {
		double somme = 0;
		for (Image image: dessin) {
			somme += image.mesurer_aire();
		}
		return somme;
	}

	@Override
	public void appliquer_homotetie(double scale) {
		for (Image image: dessin) {
			image.appliquer_homotetie(scale);
		}		
	}

	@Override
	public void translater(double dx, double dy) {
		for (Image image: dessin) {
			image.translater(dx, dy);
		}	
	}

	@Override
	public void rotater(int angle) {
		for (Image image: dessin) {
			image.rotater(angle);
		}	
	}

	@Override
	public void symetrie_centrale(Point point) {
		for (Image image: dessin) {
			image.symetrie_centrale(point);
		}
	}

	@Override
	public void symetrie_axiale(Point point1, Point point2) {
		for (Image image: dessin) {
			image.symetrie_axiale(point1, point2);
		}
	}
	
	public Dessin copie_dessin() {
		Dessin Nouveau_dessin = new Dessin("Nouveau dessin");
		for (Image image: this.dessin) {
			Nouveau_dessin.ajouter_image(image);
		}
		return Nouveau_dessin;
	}
	
	public Dessin copie_dessin(final String nom) {
		Dessin Nouveau_dessin = new Dessin(nom);
		for (Image image: this.dessin) {
			Nouveau_dessin.ajouter_image(image);
		}
		return Nouveau_dessin;
	}

	public ArrayList<Image> trier_dessin_selon_aire() {
		ArrayList<Image> trier = new ArrayList<Image>(this.dessin);
		for (int i = 0; i < trier.size(); i++) {
			double min = Double.POSITIVE_INFINITY;
			int min_index = i;
			for (int j = i; j < trier.size(); j++) {
				double aire = trier.get(j).mesurer_aire();
				if (aire < min) {
					min = aire;
					min_index = j;
				}
			}
			Image temp = trier.get(min_index);
			trier.set(min_index, trier.get(i));
			trier.set(i, temp);
		}
		return trier;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dessin == null) ? 0 : dessin.hashCode());
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
		Dessin other = (Dessin) obj;
		if (dessin == null) {
			if (other.dessin != null)
				return false;
		} else if (!dessin.equals(other.dessin))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
}
