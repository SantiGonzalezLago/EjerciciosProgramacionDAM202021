package gal.teis.model;

public class Circle extends GeometricFigure {

	private double radius;

	public Circle(double radius) {
		if (radius <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2.0);
	}

	@Override
	public double getPerimeter() {
		return 2.0 * Math.PI * radius;
	}

}
