package mouton;

import java.util.HashSet;

public class Dessin implements Calculs, Transformations{
	
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
	public double mesurer_air() {
		double somme = 0;
		for (Image image: dessin) {
			somme += image.mesurer_air();
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
	
	public Dessin copie_dessin(final Dessin dessin) {
		Dessin Nouveau_dessin = new Dessin("Nouveau dessin");
		for (Image image: dessin.getDessin()) {
			Nouveau_dessin.ajouter_image(image);
		}
		return Nouveau_dessin;
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
