package mouton;

import java.util.ArrayList;

public class Polygone extends Forme implements Calculs, Transformations{
	
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
	
	@Override
	public void appliquer_homotetie(final double scale) {
		this.origine.posX *= scale;
		this.origine.posY *= scale;
		for (Point point: polygone) {
			point.posX *= scale;
			point.posY *= scale;
		}
	}

	@Override
	public void translater(final double dx, final double dy) {
		this.origine.posX += dx;
		this.origine.posY += dy;
		for (Point point: polygone) {
			point.posX += dx;
			point.posY += dy;
		}
		
	}

	@Override
	public void rotater(final int angle) {
		this.rot += angle;
	}

	@Override
	public void symetrie_centrale(final Point centre) {
		this.origine.posX += 2*(centre.posX - this.origine.posX);
		this.origine.posY += 2*(centre.posY - this.origine.posY);
		for (Point point: polygone) {
			point.posX += 2*(centre.posX - point.posX);
			point.posY += 2*(centre.posY - point.posY);
		}
	}

	@Override
	public void symetrie_axiale(final Point point1, final Point point2) {
		double x = ((point1.posX*point2.posY - point2.posX*point1.posY)*(point2.posY - point1.posY) - (this.origine.posY*(point2.posY - point1.posY) - this.origine.posX*(point1.posX - point2.posX)*(point1.posX - point2.posX))) / (Math.pow(point1.posX - point2.posX, 2) + (Math.pow(point2.posY - point1.posY, 2)));
		double y = ((point1.posX*point2.posY - point2.posX*point1.posY)*(point1.posX - point2.posX) - (this.origine.posY*(point2.posY - point1.posY) - this.origine.posX*(point1.posX - point2.posX)*(point2.posY - point1.posY))) / (Math.pow(point1.posX - point2.posX, 2) + (Math.pow(point2.posY - point1.posY, 2)));
		this.origine.posX += 2*(x - this.origine.posX);
		this.origine.posY += 2*(y - this.origine.posY);
		for (Point point: polygone) {
			point.posX += 2*(x - point.posX);
			point.posY += 2*(x - point.posY);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((polygone == null) ? 0 : polygone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygone other = (Polygone) obj;
		if (polygone == null) {
			if (other.polygone != null)
				return false;
		} else if (!polygone.equals(other.polygone))
			return false;
		return true;
	}
}
