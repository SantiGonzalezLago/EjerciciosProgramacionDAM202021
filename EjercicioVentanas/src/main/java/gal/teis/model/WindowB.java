package gal.teis.model;

public class WindowB {

	private static int stock;
	private static int totalSold;
	private static double price;

	public static void setPrice(double price) {
		WindowB.price = price;
	}

	public static double getPrice() {
		return price;
	}

	public static int getStock() {
		return stock;
	}

	public static int getTotalSold() {
		return totalSold;
	}

	private Color color;

	public WindowB(Color color) {
		this.color = color;
		stock++;
	}

	public Color getColor() {
		return color;
	}

	public static boolean sellWindows(int amount) {
		boolean success = false;
		if (stock >= amount) {
			stock -= amount;
			totalSold += amount;
			success = true;
		}
		return success;
	}
}
