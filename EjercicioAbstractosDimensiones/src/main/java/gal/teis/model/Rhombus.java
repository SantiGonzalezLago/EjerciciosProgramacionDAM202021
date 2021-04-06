package gal.teis.model;

public class Rhombus extends GeometricFigure {

	private double side;
	private double diagonal;

	public Rhombus(double side, double diagonal) {
		if (side <= 0.0 || diagonal <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		if (2.0 * side <= diagonal)
			throw new IllegalArgumentException("diagonal must be lower than twice the side");
		this.side = side;
		this.diagonal = diagonal;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		if (side <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		this.side = side;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		if (diagonal <= 0.0)
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		if (2.0 * side <= diagonal)
			throw new IllegalArgumentException("diagonal must be lower than twice the side");
		this.diagonal = diagonal;
	}

	@Override
	public double getArea() {
		float secondDiagonal = (float) (2.0 * Math.sqrt(Math.pow(side, 2.0) + Math.pow((diagonal / 2.0), 2.0)));
		return diagonal * secondDiagonal;
	}

	@Override
	public double getPerimeter() {
		return 4.0 * side;
	}

}
