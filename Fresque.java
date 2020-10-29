package mouton;

import java.util.HashSet;

public class Fresque implements Calculs{
	
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
}
