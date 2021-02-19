package gal.teis.model;

import java.util.ArrayList;
import java.util.HashMap;

public class WindowA {

	private static HashMap<Color, ArrayList<WindowA>> stock = new HashMap<>();

	//Esto es un inicializador estático, se ejecuta la primera vez que se carga la clase
	static {
		for (Color color : Color.values()) { 
			stock.put(color, new ArrayList<>());
		}
	}
	
	private static int totalSold;
	private static double price;

	public static void setPrice(double price) {
		WindowA.price = price;
	}

	public static double getPrice() {
		return price;
	}

	public static int getStock(Color color) {
		return stock.get(color).size();
	}

	public static int getTotalSold() {
		return totalSold;
	}

	private Color color;

	public WindowA(Color color) {
		this.color = color;
		stock.get(color).add(this);
	}

	public Color getColor() {
		return color;
	}

	public static boolean sellWindows(int amount, Color color) {
		boolean success = false;
		if (getStock(color) >= amount) {
			for (int i = 0; i< amount; i++) {
				stock.get(color).remove(0);
			}
			totalSold += amount;
			success = true;
		}
		return success;
	}
}
