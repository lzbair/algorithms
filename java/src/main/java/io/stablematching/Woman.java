package io.stablematching;

public class Woman extends Human{

	public Woman(String name) {
		super(name);
	}

	
	public  int evaluate(Human h){
		return preferences.evaluate(h);
	}
	


	
}
