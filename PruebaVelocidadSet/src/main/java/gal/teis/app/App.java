package gal.teis.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class App {
	public static final int TEST_SIZE = 1_000_000;

	public static void main(String[] args) {
		test(new HashSet(TEST_SIZE), TEST_SIZE);
		test(new TreeSet(), TEST_SIZE);
		test(new LinkedHashSet(TEST_SIZE), TEST_SIZE);
		test(new ArrayList(), TEST_SIZE);
		test(new LinkedList(), TEST_SIZE);
	}

	public static void test(Collection col, int size) {
		final long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			col.add(i);
		}
		final long endTime = System.currentTimeMillis();
		System.out.printf("Tiempo para %s: %dms%n", col.getClass().toString(), (endTime - startTime));
	}
}
