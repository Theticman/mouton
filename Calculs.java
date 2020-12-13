package mouton;

/**
 * Interface de calculs permettant d'impl�menter les m�thodes
 * de calcul du p�rim�tre et de l'aire d'une forme.
 */
public interface Calculs {

	abstract public double mesurer_perimetre();
	abstract public double mesurer_aire();
}
