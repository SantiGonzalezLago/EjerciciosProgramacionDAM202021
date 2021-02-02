package gal.teis.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gal.teis.model.Account;

public class AccountList {
	
	private static List<Account> accountList;

	static {
		accountList = new ArrayList<>();
		accountList.add(new Account("0001", "1234", "Paco", new BigDecimal(1000)));
		accountList.add(new Account("0002", "Patata", "Eugenia", new BigDecimal(50000)));
		accountList.add(new Account("0003", "Tr0ub4dor&3", "Leovigilda", new BigDecimal(675)));
		accountList.add(new Account("0004", "correct horse battery staple", "Randall", new BigDecimal(2)));
	}
	
	public static Account get(String accNumber, String pwd) throws Exception {
		for (Account acc : accountList) {
			if (acc.getAccountNumber().equals(accNumber) && acc.checkPwd(pwd)) {
				return acc;
			}
		}
		throw new Exception("ACCOUNT_NOT_FOUND");
	}

	public static boolean add(Account acc) {
		boolean accountExists = false, success = false;
		String accNumber = acc.getAccountNumber();
		int i = 0;
		do {
			if (accNumber.equals(accountList.get(i).getAccountNumber())) {
				accountExists = true;
			}
			i++;
		} while(i < accountList.size() && !accountExists);
		if (!accountExists) {
			accountList.add(acc);
			success = true;
		}
		return success;
	}

	public static boolean updateAccountNumber(Account account, String accNumber, byte accessLevel) {
		boolean accountExists = false, success = false;
		int i = 0;
		do {
			if (accNumber.equals(accountList.get(i).getAccountNumber())) {
				accountExists = true;
			}
			i++;
		} while(i < accountList.size() && !accountExists);
		if (!accountExists) {
			account.setAccountNumber(accNumber, accessLevel);
			success = true;
		}
		return success;
	}
}
