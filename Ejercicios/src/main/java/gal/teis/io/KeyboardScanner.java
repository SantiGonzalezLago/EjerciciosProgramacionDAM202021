package gal.teis.io;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public final class KeyboardScanner {
	private static final int DEFAULT_ATTEMPT_LIMIT = 1;

	private Scanner sc;
	private boolean lineInBuffer;
	private int attemptLimit;

	public KeyboardScanner() {
		this(DEFAULT_ATTEMPT_LIMIT);
	}

	public KeyboardScanner(int attemptLimit) {
		sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		lineInBuffer = false;
		this.attemptLimit = attemptLimit;
	}

	public KeyboardScanner(Locale locale) {
		this();
		sc.useLocale(locale);
	}

	public KeyboardScanner(int attemptLimit, Locale locale) {
		this(attemptLimit);
		sc.useLocale(locale);
	}

	public void useLocale(Locale locale) {
		sc.useLocale(locale);
	}

	public void setLocale(Locale locale) {
		useLocale(locale);
	}

	public void setAttemptLimit(int attemptLimit) {
		this.attemptLimit = attemptLimit;
	}

	public Scanner getScanner() {
		return sc;
	}

	public void close() {
		sc.close();
	}

	public String nextLine() {
		cleanBuffer();
		return sc.nextLine();
	}

	public void cleanBuffer() {
		if (lineInBuffer) {
			sc.nextLine();
			lineInBuffer = false;
		}
	}

	public byte nextByte() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		byte input = 0;
		do {
			error = false;
			try {
				input = sc.nextByte();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public short nextShort() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		short input = 0;
		do {
			error = false;
			try {
				input = sc.nextShort();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public int nextInt() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		int input = 0;
		do {
			error = false;
			try {
				input = sc.nextInt();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public long nextLong() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		long input = 0;
		do {
			error = false;
			try {
				input = sc.nextLong();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public float nextFloat() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		float input = 0;
		do {
			error = false;
			try {
				input = sc.nextFloat();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public double nextDouble() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		double input = 0;
		do {
			error = false;
			try {
				input = sc.nextDouble();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public char nextChar() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		char input = 0;
		do {
			error = false;
			try {
				input = sc.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public BigInteger nextBigInteger() {
		boolean error;
		int attempts = 0;
		BigInteger input = null;
		do {
			error = false;
			try {
				input = sc.nextBigInteger();
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	public BigDecimal nextBigDecimal() {
		boolean error;
		int attempts = 0;
		BigDecimal input = null;
		do {
			error = false;
			try {
				input = sc.nextBigDecimal();
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

}
