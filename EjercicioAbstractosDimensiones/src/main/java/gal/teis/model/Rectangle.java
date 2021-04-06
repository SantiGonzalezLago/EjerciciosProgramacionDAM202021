package gal.teis.model;

public class Rectangle extends GeometricFigure {

	private double base;
	private double height;

	public Rectangle(double base, double height) {
		if (base <= 0.0 || height <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		if (base <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.height = height;
	}

	@Override
	public double getArea() {
		return base * height;
	}

	@Override
	public double getPerimeter() {
		return 2.0 * base + 2.0 * height;
	}

}
