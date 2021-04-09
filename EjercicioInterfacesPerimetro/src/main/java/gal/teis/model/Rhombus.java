package gal.teis.model;

public class Rhombus implements CalculablePerimeter {

	private float side;

	public Rhombus(float side) {
		this.side = side;
	}

	public float getSide() {
		return side;
	}

	public void setSide(float side) {
		this.side = side;
	}

	@Override
	public float getPerimeter() {
		return 4f * side;
	}

}
