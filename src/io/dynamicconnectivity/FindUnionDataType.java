package io.dynamicconnectivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUnionDataType {

	Graph<Integer> graph;

	public FindUnionDataType(int N) {
		this.graph = new Graph<Integer>(N);
	}

	public void union(int p, int q) {
		graph.union(Integer.valueOf(p), Integer.valueOf(q));
	}

	public boolean connected(int p, int q) {
		return graph.connected(Integer.valueOf(p), Integer.valueOf(q));
	}

	public static void main(String[] args) {

		FindUnionDataType fu = new FindUnionDataType(10);
		fu.union(1, 2);
		fu.union(3, 4);
		fu.union(5, 6);
		fu.union(7, 8);
		fu.union(7, 9);
		fu.union(2, 8);
		fu.union(0, 5);
		fu.union(1, 9);

		System.out.println(fu.graph.containers);
	}

	private class Graph<T> {

		final List<Set<T>> containers = new ArrayList<Set<T>>();
		final int nodes;

		public Graph(int n) {
			this.nodes = n;
		}

		public void union(T p, T q) {
			if (this.connected(p, q)) {
				return;
			}

			merge(getContainer(p), getContainer(q));

		}

		private void merge(Set<T> c1, Set<T> c2) {
			c1.addAll(c2);
			if (containers.contains(c2)) {
				this.containers.remove(c2);
			}
			if (!containers.contains(c1)) {
				this.containers.add(c1);
			}

		}

		public boolean connected(T p, T q) {
			for (Set<T> set : containers) {
				if (set.contains(p) && set.contains(q)) {
					return true;
				}
			}
			return false;
		}

		private Set<T> getContainer(T p) {
			for (Set<T> set : containers) {
				if (set.contains(p)) {
					return set;
				}
			}
			Set<T> c = new HashSet<T>();
			c.add(p);
			return c;
		}
	}
}
