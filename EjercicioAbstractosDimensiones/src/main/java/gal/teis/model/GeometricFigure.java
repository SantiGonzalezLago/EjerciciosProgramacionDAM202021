package gal.teis.model;

public abstract class GeometricFigure {

	protected static final String NEGATIVE_ERROR_MSG = "all parameters must be positive";

	public abstract double getArea();

	public abstract double getPerimeter();
}
