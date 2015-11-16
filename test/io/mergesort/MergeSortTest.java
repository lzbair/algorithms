package io.mergesort;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

	private static final String FILE = "ressources\\IntegerArray.txt";

	@Test
	public void testIfArraySorted() throws Exception {
		List<String> entries = new BlocExecutor<List<String>>() {
			@Override
			public List<String> doExecution() throws IOException {
				return Files.readAllLines(Paths.get(FILE));
			}
		}.execute("Load data");

		long[] values = new BlocExecutor<long[]>() {
			@Override
			public long[] doExecution() {
				return entries.stream().mapToLong(e -> parseInt(e)).toArray();
			}
		}.execute("Transform data");

		long[] sortedArray = new BlocExecutor<long[]>() {
			@Override
			public long[] doExecution() {
				return new MergeSort().sort(values);
			}
		}.execute("Sort data");

		new BlocExecutor<Void>() {
			@Override
			public Void doExecution() {
				List<long[]> sortedList = Arrays.asList(sortedArray);
				sortedList.stream().forEach(
						e -> assertTrue(sortedList.indexOf(e) + 1 == e[0]));
				return null;
			}
		}.execute("Test data");
	}

	interface BlocExecutor<T> {
		T doExecution() throws Exception;

		default T execute(String operation) throws Exception {
			long start = System.currentTimeMillis();
			T result = doExecution();
			long end = System.currentTimeMillis();
			System.out.println(operation + " : " + ((end - start) / 1000) + " Seconds");
			return result;
		}

	}

}
