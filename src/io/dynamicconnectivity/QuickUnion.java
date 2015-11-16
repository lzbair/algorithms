package io.dynamicconnectivity;

import java.util.Arrays;

public class QuickUnion {

	private int[] id;

	public QuickUnion(int N) {
		this.id = new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		id[root(p)] = root(q);
	}

	private int root(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	public static void main(String... args) {
		long start = System.nanoTime();
		QuickUnion qu = new QuickUnion(30);
		qu.union(1, 2);
		qu.union(3, 4);
		qu.union(5, 6);
		qu.union(7, 8);
		qu.union(7, 9);
		qu.union(2, 8);
		qu.union(0, 5);
		qu.union(1, 9);
		qu.union(10, 9);
		qu.union(10, 9);
		qu.union(11, 9);
		qu.union(12, 9);
		qu.union(13, 9);
		qu.union(14, 5);
		qu.union(15, 5);
		qu.union(16, 5);
		qu.union(17, 5);
		qu.union(18, 5);
		qu.union(19, 10);
		qu.union(20, 10);
		qu.union(21, 10);
		qu.union(22, 10);
		qu.union(23, 10);
		qu.union(24, 4);
		qu.union(25, 4);
		qu.union(26, 4);
		qu.union(27, 4);
		qu.union(28, 4);
		qu.union(29, 4);
		System.out.println(Arrays.toString(qu.id));
		long end = System.nanoTime();
		System.out.print("Execution time is " + (end - start));

	}

}
