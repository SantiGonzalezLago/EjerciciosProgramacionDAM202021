package gal.teis.main;

import java.math.BigDecimal;

import gal.teis.model.Account;

public class App {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.setName("Paco");
		acc.setAccountNumber("0234352", (byte) 1);
		System.out.println("Objeto creado: " + acc);
		acc.setAccountNumber("666", (byte) 32);
		System.out.println("Tras intentar cambiar número de cuenta con acceso erróneo: " + acc);
		acc.addBalance(new BigDecimal(200));
		System.out.println("Tras ingresar dinero: " + acc);
		acc.removeBalance(new BigDecimal(300));
		System.out.println("Tras intentar retirar más dinero del posible: " + acc);
		acc.removeBalance(new BigDecimal(100));
		System.out.println("Tras retirar dinero: " + acc);
	}
}
