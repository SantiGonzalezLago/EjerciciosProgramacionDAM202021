package gal.teis.app;

import gal.teis.model.*;

public class App {
	public static void main(String[] args) {
		GeometricFigure tri = new Triangle(3.0, 4.0, 5.0);
		System.out.println(tri.getArea());
	}
}
