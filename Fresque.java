package mouton;

import java.util.HashSet;

public class Fresque implements Calculs, Transformations{
	
	private HashSet<Dessin> fresque = new HashSet<Dessin>();
	
	public Fresque() {
	}
	
	public void ajouter_dessin(final Dessin dessin) {
		fresque.add(dessin);
	}

	@Override
	public String toString() {
		String out = "================================================================================\nAffichage des composants de la fresque...\n\n";
		for (Dessin dessin: fresque) {
			out += dessin.toString();
		}
		out += "================================================================================";
		return out;
	}

	@Override
	public double mesurer_perimetre() {
		double somme = 0;
		for (Dessin dessin: fresque) {
			somme += dessin.mesurer_perimetre();
		}
		return somme;
	}

	@Override
	public double mesurer_air() {
		double somme = 0;
		for (Dessin dessin: fresque) {
			somme += dessin.mesurer_air();
		}
		return somme;
	}

	@Override
	public void appliquer_homotetie(double scale) {
		for (Dessin dessin: fresque) {
			dessin.appliquer_homotetie(scale);
		}		
	}

	@Override
	public void translater(double dx, double dy) {
		for (Dessin dessin: fresque) {
			dessin.translater(dx, dy);
		}	
	}

	@Override
	public void rotater(int angle) {
		for (Dessin dessin: fresque) {
			dessin.rotater(angle);
		}	
	}

	@Override
	public void symetrie_centrale(Point point) {
		for (Dessin dessin: fresque) {
			dessin.symetrie_centrale(point);
		}
	}

	@Override
	public void symetrie_axiale(Point point1, Point point2) {
		for (Dessin dessin: fresque) {
			dessin.symetrie_axiale(point1, point2);
		}
	}
}
