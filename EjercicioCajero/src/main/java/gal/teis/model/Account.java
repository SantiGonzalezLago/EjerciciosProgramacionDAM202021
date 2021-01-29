package gal.teis.model;

import java.math.BigDecimal;

public class Account {
	private String name;
	private String accountNumber;
	private BigDecimal interestType;
	private BigDecimal balance;

	public Account() {
		interestType = new BigDecimal(0);
		balance = new BigDecimal(0);
	}

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

	public BigDecimal getInterestType() {
		return interestType;
	}

	public void setInterestType(BigDecimal interestType) {
		this.interestType = interestType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void addBalance(BigDecimal amount) {
		balance = balance.add(amount);
	}

	public boolean removeBalance(BigDecimal amount) {
		boolean operationCompleted = false;
		if (balance.compareTo(amount) != -1) {
			balance = balance.subtract(amount);
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
