package gal.teis.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

	private ArrayList<String> options;

	public Menu(String... options) {
		this.options = new ArrayList<>(Arrays.asList(options));
	}

	public boolean isOptionValid(int option) {
		return (option > 0 && option <= getExitOption());
	}

	public void addOptions(String... newOptions) {
		for (String option : newOptions) {
			options.add(option);
		}
	}

	public boolean removeOption(String removedOption) {
		return options.remove(removedOption);
	}

	public int getExitOption() {
		return options.size() + 1;
	}

	public void printMenu() {
		System.out.println("Elija una opción:");
		for (int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
		System.out.println(getExitOption() + ". Salir");
	}
}
