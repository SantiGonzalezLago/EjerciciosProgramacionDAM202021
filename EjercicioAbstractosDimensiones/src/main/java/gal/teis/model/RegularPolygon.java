package gal.teis.model;

public class RegularPolygon extends GeometricFigure {

	private double side;
	private int numberOfSides;

	public RegularPolygon(double side, int numberOfSides) {
		if (side <= 0.0 || numberOfSides <= 0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.side = side;
		this.numberOfSides = numberOfSides;
	}

	@Override
	public double getArea() {
		return (Math.pow(side, 2.0) * numberOfSides) / 4.0 * (Math.tan(Math.PI / numberOfSides));
	}

	@Override
	public double getPerimeter() {
		return side * numberOfSides;
	}

}
