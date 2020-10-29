package mouton;

import java.util.HashSet;

public class Fresque {
	
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
}
