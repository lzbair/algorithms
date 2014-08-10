package io.stablematching;

public class Preference implements Comparable<Preference>{

	final private Human human;
	final private int rank;
	
	public Preference(Human human, int rank) {
		this.human = human;
		this.rank = rank;
	}

	@Override
	public int compareTo(Preference p) {
		return p.isRankGreaterThan(this.rank)? 1 : -1;
	}

	private boolean  isRankGreaterThan(int rank2) {
        return this.rank >= rank2;		
	}

	public Human getHuman() {
		return this.human;
	}

	public int getRank() {
		return this.rank;
	}
	
}
