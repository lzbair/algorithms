package io.mergesort;

import static java.util.Arrays.copyOfRange;

public class MergeSort {

	public long[] sort(long[] input) {
		int length = input.length;
		if (length == 1) {
			return input;
		} else if (length == 2) {
			if (input[0] < input[1]) {
				return input;
			}
			return new long[] { input[1], input[0] };
		}

		int half = length / 2;
		long[] part1 = sort(copyOfRange(input, 0, half));
		long[] part2 = sort(copyOfRange(input, half, length));
		return merge(part1, part2);
	}

	private long[] merge(long[] part1, long[] part2) {
		long[] output = new long[part1.length + part2.length];

		for (int k = 0; k < output.length; k++) {
			if (part2.length == 0 || (part1.length != 0 && part1[0] < part2[0])) {
				output[k] = part1[0];
				part1 = copyOfRange(part1, 1, part1.length);
			} else {
				output[k] = part2[0];
				part2 = copyOfRange(part2, 1, part2.length);
			}
		}
		return output;
	}

}
