package io.stablematching;

public class Man extends Human{

	protected Man(String name) {
		super(name);
	}
	
	public Woman bestPartner(){
		return (Woman) preferences.bestPartner();
	}

	

	
	

}
