package io.mergesort;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;
import static java.util.Arrays.asList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {

	private static final String FILE = "ressources\\IntegerArray.txt";

	@Test
	public void testIfArraySorted() throws Exception {

		List<String> entries = perform("Load data", () -> {
			return Files.readAllLines(Paths.get(FILE));
		});

		long[] values = perform("Transform data", () -> {
			return entries.stream().mapToLong(e -> parseInt(e)).toArray();
		});

		long[] sortedArray = perform("Sort data", () -> {
			return new MergeSort().sort(values);
		});

		perform("Test data",
				() -> {
					List<long[]> sortedList = asList(sortedArray);
					sortedList.stream().forEach(
							e -> assertTrue(sortedList.indexOf(e) + 1 == e[0]));
					return null;
				});
	}

	private <T> T perform(String operation, BlocExecutor<T> blocExecutor)
			throws Exception {
		return blocExecutor.execute(operation);
	}

}
