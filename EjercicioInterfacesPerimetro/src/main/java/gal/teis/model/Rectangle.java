package gal.teis.model;

public class Rectangle implements CalculablePerimeter, CalculableArea {

	private float base;
	private float height;

	public Rectangle(float base, float height) {
		if (base <= 0 || height <= 0)
			throw new IllegalArgumentException("base and height must be positive");
		this.base = base;
		this.height = height;
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public float getPerimeter() {
		return 2f * base + 2f * height;
	}

	@Override
	public float getArea() {
		return base * height;
	}

}
