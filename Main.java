package mouton;

public class Main {

	public static void main(String[] args) {
		// Création de la fresque:
		Fresque f = new Fresque();
		Dessin d1 = new Dessin("Mouton 1");
		Dessin d2 = new Dessin("Berger");
		
		Image i1_1 = new Image("Tête");
		Image i1_2 = new Image("Corp");
		
		Image i2_1 = new Image("Tête");
		Image i2_2 = new Image("Corp");
		
		Point p1_1_1 = new Point(5, 2.3);
		Point p1_1_2 = new Point();
		Point p1_1_3 = new Point();
		Cercle c1_1 = new Cercle(p1_1_1, 10.0);
		Ellipse e1_1 = new Ellipse(p1_1_2, 3, 2.5);
		Ellipse e1_2 = new Ellipse(p1_1_3, 3, 2.5);
		
		i1_1.ajouter_forme(c1_1);
		i1_1.ajouter_forme(e1_1);
		i1_1.ajouter_forme(e1_2);
		i1_1.ajouter_forme(e1_2); // Ajouter un même élément ne fonctionne pas
		
		Point p1_2_1 = new Point();
		Point p1_2_2 = new Point();
		Point p1_2_3 = new Point();
		Point p1_2_4 = new Point();
		Polygone po1 = new Polygone();
		po1.ajouter_point(p1_2_1);
		po1.ajouter_point(p1_2_2);
		po1.ajouter_point(p1_2_3);
		po1.ajouter_point(p1_2_4);
		
		i1_2.ajouter_forme(po1);
		
		d1.ajouter_image(i1_1);
		d1.ajouter_image(i1_2);
		
		Point p2_1_1 = new Point();
		Point p2_1_2 = new Point();
		Point p2_1_3 = new Point();
		Cercle c2_1 = new Cercle(p2_1_1, 6.0);
		Ligne l1 = new Ligne(p2_1_2,p2_1_3, 4.0);

		i2_1.ajouter_forme(c2_1);
		i2_1.ajouter_forme(l1);
		
		Point p2_2_1 = new Point();
		Point p2_2_2 = new Point();
		Point p2_2_3 = new Point();
		Point p2_2_4 = new Point();
		Polygone po2 = new Polygone();
		po2.ajouter_point(p2_2_1);
		po2.ajouter_point(p2_2_2);
		po2.ajouter_point(p2_2_3);
		po2.ajouter_point(p2_2_4);
		
		i2_2.ajouter_forme(po2);
		
		d2.ajouter_image(i2_1);
		d2.ajouter_image(i2_2);

	
		f.ajouter_dessin(d1);
		f.ajouter_dessin(d2);
		
		System.out.println(f.toString());
		
		// Differents tests
		// Homotetie
		//c1_1.appliquer_homotetie(3);
		//System.out.println(f.toString());
		
		// Translation
		//i1_2.translater(2.4, -4);
		//System.out.println(f.toString());
		
		// Rotation
		//l1.rotater(40);
		//System.out.println(f.toString());
		
		// Symétrie centrale
		//Point centre = new Point();
		//c2_1.symetrie_centrale(centre);
		//System.out.println(f.toString());

		// Symétrie axiale
		//Point point1 = new Point(0,0);
		//Point point2 = new Point(10,10);
		//po2.symetrie_axiale(point1, point2);
		//System.out.println(f.toString());
		
		// Calcul air
		//System.out.println(d1.mesurer_air());
		//System.out.println(d2.mesurer_air());
		//System.out.println(f.mesurer_air());
		
		// Calcul perimetre
		//System.out.println(i1_1.mesurer_perimetre());
		//System.out.println(i1_2.mesurer_perimetre());
		//System.out.println(d1.mesurer_perimetre());
		
		// Copie Dessin
		//System.out.println(d1.toString());
		//Dessin copie = d1.copie_dessin(d1);
		//System.out.println(copie);
		
		// Calcul nombre perimetre et air inférieur
		//System.out.println(f.nombre_perimetre_inferieur_a(f, 100));
		//System.out.println(f.nombre_air_inferieur_a(f, 200));

	}
}
