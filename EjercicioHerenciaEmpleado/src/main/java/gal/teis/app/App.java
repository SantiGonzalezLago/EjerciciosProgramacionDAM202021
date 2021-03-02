package gal.teis.app;

import gal.teis.model.level0.Employee;
import gal.teis.model.level1.*;
import gal.teis.model.level2.*;

public class App {
	public static void main(String[] args) {
		Employee[] employees = new Employee[5];
		employees[0] = new Employee("Yeri");
		employees[1] = new Operator("Yerón");
		employees[2] = new Executive("Yeronciño de mis amores");
		employees[3] = new Officer("Yeroncete");
		employees[4] = new Technician("Yerón Barreiro");
		
		for (Employee e : employees) {
			System.out.println(e.toString());
		}
	}
}
