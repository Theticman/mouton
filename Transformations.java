package mouton;

public interface Transformations {
	
	abstract public void appliquer_homotetie(final double scale);
	abstract public void translater(final double dx, final double dy);
	abstract public void rotater(final int angle);
	abstract public void symetrie_centrale(final Point point);
	abstract public void symetrie_axiale(final Point point1, final Point point2);
}
