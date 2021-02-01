package gal.teis.model;

import java.math.BigDecimal;

public class Account {
	private String accountNumber;
	private String pwd;
	private String name;
	private BigDecimal interestType;
	private BigDecimal balance;

	public Account() {
		interestType = new BigDecimal(0);
		balance = new BigDecimal(0);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
