package io.dynamicconnectivity;

public class WeightedQuickUnion extends QuickUnion {

	private final int[] weights;

	public WeightedQuickUnion(int N) {
		super(N);
		weights = new int[N];
	}

	@Override
	public void join(int rp, int rq) {
		if(weights[rp] < weights[rq]){
			id[rp] = rq;
			weights[rq] =+ weights[rp];
		}else{
			weights[rp] =+ weights[rq];
		}
	}

}
