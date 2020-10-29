package mouton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fresque f = new Fresque();
		Dessin d = new Dessin("Chien");
		Image i = new Image("Tête");
		Image i2 = new Image();
		Point p1 = new Point();
		Point p2 = new Point(3,4);
		Point p3 = new Point(9,20);
		Point p4 = new Point(0,5);
		Point p5 = new Point(5,5);
		Point p6 = new Point(5,0);
		Point p7 = new Point(2.5,2.5);
		Ligne l1 = new Ligne(p1,p2,5);
		Ligne l2 = new Ligne(2,4,6,5,1.2);
		Ellipse e1 = new Ellipse(p2,3.4,4.2);
		Ellipse e2 = new Ellipse(3,2,4,19);
		Cercle c1 = new Cercle(p3,6);
		Polygone po1 = new Polygone();
		
		po1.ajouter_point(p1);
		po1.ajouter_point(p4);
		po1.ajouter_point(p5);
		po1.ajouter_point(p6);
		po1.ajouter_point(p7);
		
		i.ajouter_forme(l1);
		i.ajouter_forme(l2);
		i.ajouter_forme(e1);
		
		i2.ajouter_forme(e2);
		i2.ajouter_forme(c1);
		i2.ajouter_forme(po1);
		
		d.ajouter_image(i);
		d.ajouter_image(i2);
	
		
		f.ajouter_dessin(d);
		
		System.out.println(f.toString());
		
		System.out.println(c1.mesurer_air());
		System.out.println(c1.mesurer_perimetre());
		
		System.out.println(l1.mesurer_air());
		System.out.println(l1.mesurer_perimetre());
		
		System.out.println(po1.mesurer_perimetre());
		System.out.println(po1.mesurer_air());
	}
}
