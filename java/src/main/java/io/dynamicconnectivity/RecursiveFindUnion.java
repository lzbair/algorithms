package io.dynamicconnectivity;

import java.util.Arrays;

public class RecursiveFindUnion {
	private int[] id;

	public RecursiveFindUnion(int N) {
		this.id = new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		if (id[p] == p && id[q] == q) {
			id[p] = q;
			return;
		}
		union(id[p], id[q]);
	}

	public boolean connected(int p, int q) {
		if (id[p] == p && id[q] == q) {
			return id[p] == id[q];
		}
		return connected(id[p], id[q]);
	}

	public static void main(String... args) {
		long start = System.nanoTime();
		RecursiveFindUnion rfu = new RecursiveFindUnion(30);
		rfu.union(1, 2);
		rfu.union(3, 4);
		rfu.union(5, 6);
		rfu.union(7, 8);
		rfu.union(7, 9);
		rfu.union(2, 8);
		rfu.union(0, 5);
		rfu.union(1, 9);
		rfu.union(10, 9);
		rfu.union(10, 9);
		rfu.union(11, 9);
		rfu.union(12, 9);
		rfu.union(13, 9);
		rfu.union(14, 5);
		rfu.union(15, 5);
		rfu.union(16, 5);
		rfu.union(17, 5);
		rfu.union(18, 5);
		rfu.union(19, 10);
		rfu.union(20, 10);
		rfu.union(21, 10);
		rfu.union(22, 10);
		rfu.union(23, 10);
		rfu.union(24, 4);
		rfu.union(25, 4);
		rfu.union(26, 4);
		rfu.union(27, 4);
		rfu.union(28, 4);
		rfu.union(29, 4);
		System.out.println(Arrays.toString(rfu.id));
		long end = System.nanoTime();
		System.out.print("Execution time is " + (end - start));

	}

}
