package gal.teis.model;

public class Triangle extends GeometricFigure {

	private double side1;
	private double side2;
	private double side3;

	public Triangle(double side1, double side2, double side3) {
		if (side1 <= 0.0 || side2 <= 0.0 || side3 <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		if (side1 <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		if (side2 <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		if (side3 <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.side3 = side3;
	}

	@Override
	public double getArea() {
		double halfPer = getPerimeter() / 2.0;
		return Math.sqrt(halfPer * (halfPer - side1) * (halfPer - side2) * (halfPer - side3));
	}

	@Override
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

}
