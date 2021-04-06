package gal.teis.model;

public class Square extends RegularPolygon {

	public Square(double side) {
		super(side, 4);
	}

	@Override
	public double getArea() {
		return Math.pow(getSide(), 2.0);
	}
}
