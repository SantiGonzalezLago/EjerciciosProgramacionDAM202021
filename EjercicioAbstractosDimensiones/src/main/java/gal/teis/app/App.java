package gal.teis.app;

import gal.teis.model.*;

public class App {
	public static void main(String[] args) {
		GeometricFigure g = new Square(2);
		System.out.println(g.getArea());
	}
}
