package io.io.dynamicconnectivity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import io.dynamicconnectivity.QuickFind;
import io.dynamicconnectivity.QuickUnion;
import io.dynamicconnectivity.WeightedQuickUnion;
import io.mergesort.BlocExecutor;

import org.junit.Test;

public class UnionFindTest {

	@Test
	public void compare_WQU_and_QU() {
		QuickUnion qf = new QuickUnion(30);
		QuickUnion wqf = new WeightedQuickUnion(30);
		new BlocExecutor<Void>() {
		};
		union(qf);
		union(wqf);
	}

	private void union(QuickUnion qf) {
		qf.union(1, 2);
		qf.union(3, 4);
		qf.union(5, 6);
		qf.union(7, 8);
		qf.union(7, 9);
		qf.union(2, 8);
		qf.union(0, 5);
		qf.union(1, 9);
		qf.union(10, 9);
		qf.union(10, 9);
		qf.union(11, 9);
		qf.union(12, 9);
		qf.union(13, 9);
		qf.union(14, 5);
		qf.union(15, 5);
		qf.union(16, 5);
		qf.union(17, 5);
		qf.union(18, 5);
		qf.union(19, 10);
		qf.union(20, 10);
		qf.union(21, 10);
		qf.union(22, 10);
		qf.union(23, 10);
		qf.union(24, 4);
		qf.union(25, 4);
		qf.union(26, 4);
		qf.union(27, 4);
		qf.union(28, 4);
		qf.union(29, 4);
	}
	
	private void perform(String operation, BlocExecutor blocExecutor) throws Exception {
		 blocExecutor.execute(operation);
	}

}
