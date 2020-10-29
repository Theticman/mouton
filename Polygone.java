package mouton;

import java.util.ArrayList;

public class Polygone extends Forme implements Calculs{
	
	private ArrayList<Point> polygone = new ArrayList<Point>();
	
	public Polygone() {
		super();
	}
	
	public void ajouter_point(final Point point) {
		polygone.add(point);
	}
	
	@Override
	public String toString() {
		String out = "Polygon [Points: [";
		for (int i = 0; i < polygone.size(); i++) {
			if (i == 0) {
				out += polygone.get(i).toString();
			}
			else {
				out += "," + polygone.get(i).toString();
			}
		}
		out += "]]";
		return out;
	}

	@Override
	public double mesurer_perimetre() {
		double somme = Math.sqrt(Math.pow(polygone.get(0).posX - polygone.get(polygone.size()-1).posX, 2) + Math.pow(polygone.get(0).posY - polygone.get(polygone.size()-1).posY, 2));
		for (int i = 1; i < polygone.size(); i++) {
			somme += Math.sqrt(Math.pow(polygone.get(i-1).posX - polygone.get(i).posX, 2) + Math.pow(polygone.get(i-1).posY - polygone.get(i).posY, 2));
		}
		return somme;
	}

	@Override
	public double mesurer_air() {
		double air = 0;
		int j = polygone.size() - 1;
		for (int i = 0; i < polygone.size(); i++) {
			air += (polygone.get(j).posX + polygone.get(i).posX) * (polygone.get(j).posY - polygone.get(i).posY);
			j = i;
		}
		return Math.abs(air) * .5;
	}
}
