package gal.teis.model;

import java.math.BigDecimal;

public class Account {
	
	public static final byte ADMIN_ACCESSS_LEVEL = 1;
	public static final byte BASIC_ACCESSS_LEVEL = 2;
	
	
	private String accountNumber;
	private String pwd;
	private String name;
	private BigDecimal interestType;
	private BigDecimal balance;

	public Account(String accountNumber, String pwd, String name, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.pwd = pwd;
		this.name = name;
		this.balance = balance;
		interestType = new BigDecimal(0);
	}

	public Account() {
		interestType = new BigDecimal(0);
		balance = new BigDecimal(0);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean setAccountNumber(String accountNumber, byte accessLevel) {
		boolean operationCompleted = false;
		if (accessLevel == ADMIN_ACCESSS_LEVEL) {
			this.accountNumber = accountNumber;
			operationCompleted = true;
		}
		return operationCompleted;
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	public boolean setPwd(String curPwd, String newPwd, String repeatNewPwd) {
		boolean pwdChanged = false;
		if (pwd.equals(curPwd) && newPwd.equals(repeatNewPwd)) {
			pwd = newPwd;
			pwdChanged = true;
		}
		return pwdChanged;
	}

	public boolean checkPwd(String pwd) {
		return this.pwd.equals(pwd);
	}

	public BigDecimal getInterestType() {
		return interestType;
	}

	public boolean setInterestType(BigDecimal interestType) {
		this.interestType = interestType;
		return true;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public boolean addBalance(BigDecimal amount) {
		balance = balance.add(amount);
		return true;
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
