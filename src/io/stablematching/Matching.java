package io.stablematching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Matching {
	private  final Set<Man> mans;
	
	public Matching(Set<Man> mans) {
		this.mans = mans;
	}

	public Map<Woman, Man> match() {
		
		Map<Woman, Man> matching = new HashMap<Woman, Man>();

		
		for(Man m : mans) {
			assign(matching, m);
		}
		return matching;
		
	}

	private void assign(Map<Woman, Man> matching, Man m) {
		Woman w = m.bestPartner();
		Man man = matching.get(w);
		if(man == null){
			matching.put(w, m);
		}else if(w.evaluate(m) < w.evaluate(man)){
			assign(matching, m);
		}else if(w.evaluate(m) > w.evaluate(man)){
			matching.put(w, m);
			assign(matching, man);
		}
		
		
	}
	
	
	

}
