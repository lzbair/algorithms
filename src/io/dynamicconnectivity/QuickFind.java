package io.dynamicconnectivity;

import java.util.Arrays;



public class QuickFind {

	 final int[] id;

	public QuickFind(int N) {
		id = new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public boolean connect(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int idp = id[p];
		int idq = id[q];
		 if (idp == idq) {
		 return;
		 }
		for (int i = 0; i < id.length; i++) {
			if(id[i] == idq) id[i] = idp;
		}
	}
	
	
	public static void main(String... args){
		long start = System.nanoTime();
		QuickFind qf = new QuickFind(30);
		qf.union(1, 2);
		qf.union(3, 4);
		qf.union(5, 6);
		qf.union(7, 8);
		qf.union(7, 9);
		qf.union(2, 8);
		qf.union(0, 5);
		qf.union(1, 9);
		qf.union(10, 9);
		qf.union(10, 9);qf.union(11, 9);qf.union(12, 9);qf.union(13, 9);
		qf.union(14, 5);qf.union(15, 5);qf.union(16, 5);qf.union(17, 5);qf.union(18, 5);
		qf.union(19, 10);qf.union(20, 10);qf.union(21, 10);qf.union(22, 10);qf.union(23, 10);
		qf.union(24, 4);qf.union(25, 4);qf.union(26, 4);qf.union(27, 4);qf.union(28, 4);qf.union(29, 4);
		System.out.println(Arrays.toString(qf.id));
		long end = System.nanoTime();
		System.out.print("Execution time is " + (end - start));
		
	}
	
	

}
