package gal.teis.model;

public class Account {
	private String name;
	private String accountNumber;
	private double interestType;
	private double balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean setAccountNumber(String accountNumber, byte accessLevel) {
		boolean operationCompleted = false;
		if (accessLevel == 1) {
			this.accountNumber = accountNumber;
			operationCompleted = true;
		}
		return operationCompleted;
	}

	public double getInterestType() {
		return interestType;
	}

	public void setInterestType(double interestType) {
		this.interestType = interestType;
	}

	public double getBalance() {
		return balance;
	}

	public void addBalance(double amount) {
		balance += amount;
	}

	public boolean removeBalance(double amount) {
		boolean operationCompleted = false;
		if (balance >= amount) {
			balance -= amount;
			operationCompleted = true;
		}
		return operationCompleted;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountNumber=" + accountNumber + ", interestType=" + interestType
				+ ", balance=" + balance + "]";
	}
}
