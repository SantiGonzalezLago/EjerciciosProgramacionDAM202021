package gal.teis.app;

import gal.teis.model.*;

public class App {
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(5f, 2f);
		CalculablePerimeter cp1 = rec;
		CalculableArea ca = rec;
		System.out.println("Perímetro del rectángulo: " + cp1.getPerimeter());
		System.out.println("Área del rectángulo: " + ca.getArea());

		Rhombus rho = new Rhombus(3f);
		CalculablePerimeter cp2 = rho;
		System.out.println("Perímetro del rombo: " + cp2.getPerimeter());
	}
}
