package gal.teis.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import gal.teis.model.Vehicle;

public class App {
	private static final int SIZE = 5000;

	public static void main(String[] args) {
		System.out.println("ArrayList");
		run(new ArrayList<Vehicle>());
		System.out.println();
		System.out.println("LinkedList");
		run(new LinkedList<Vehicle>());
	}

	public static void run(List<Vehicle> vehicleList) {
		long startTimeTotal = System.currentTimeMillis();
		int autoIncrement = 0;

		while (vehicleList.size() < SIZE) {
			autoIncrement++;
			String type = switch (new Random().nextInt(4)) {
			case 0 -> Vehicle.CAR;
			case 1 -> Vehicle.TRUCK;
			case 2 -> Vehicle.VAN;
			case 3 -> Vehicle.BIKE;
			default -> Vehicle.CAR;
			};
			vehicleList.add(new Vehicle(autoIncrement, type));
		}
		System.out.printf("%d vehiculos añadidos%n", SIZE);

		int countCar = 0, countTruck = 0, countVan = 0, countBike = 0;
		var iterator1 = vehicleList.iterator();
		while (iterator1.hasNext()) {
			Vehicle vehicle = iterator1.next();
			switch (vehicle.getType()) {
			case Vehicle.CAR -> countCar++;
			case Vehicle.TRUCK -> countTruck++;
			case Vehicle.VAN -> countVan++;
			case Vehicle.BIKE -> countBike++;
			}
		}
		System.out.printf("Coches: %d, camiones: %d, furgonetas: %d, motos: %d%n", countCar, countTruck, countVan, countBike);

//		var iterator2 = vehicleList.iterator();
//		while (iterator2.hasNext()) {
//			Vehicle vehicle = iterator2.next();
//			if (!vehicle.getType().equals(Vehicle.CAR)) {
//				iterator2.remove();
//			}
//		}
		vehicleList.removeIf(v -> !v.getType().equals(Vehicle.CAR));
		System.out.println("Vehiculos que no son coches eliminados");

		while (vehicleList.size() < SIZE) {
			autoIncrement++;
			vehicleList.add(new Vehicle(autoIncrement, Vehicle.CAR));
		}
		System.out.println("Lista rellenada de nuevo");
		
		int countCar2 = 0, countTruck2 = 0, countVan2 = 0, countBike2 = 0;
		var iterator3 = vehicleList.iterator();
		while (iterator3.hasNext()) {
			Vehicle vehicle = iterator3.next();
			switch (vehicle.getType()) {
			case Vehicle.CAR -> countCar2++;
			case Vehicle.TRUCK -> countTruck2++;
			case Vehicle.VAN -> countVan2++;
			case Vehicle.BIKE -> countBike2++;
			}
		}
		System.out.printf("Coches: %d, camiones: %d, furgonetas: %d, motos: %d%n", countCar2, countTruck2, countVan2, countBike2);
	
		System.out.printf("Tiempo total de ejecución: %dms%n", (System.currentTimeMillis() - startTimeTotal));
		
	}
}
