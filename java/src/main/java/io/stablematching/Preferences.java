package io.stablematching;

import java.util.Collections;
import java.util.List;

public class Preferences {

	private final List<Preference> preferenceList;
	PreferencseState state;

	public Preferences(List<Preference> preferenceList) {
		Collections.sort(preferenceList);
		this.preferenceList = preferenceList;
		this.state = new PreferencseState(preferenceList.get(0));
	}

	public boolean contains(Human h) {
		return this.preferenceList.contains(h);
	}

	public Human bestPartner() {
		return state.nextPartner();
	}

	public int evaluate(Human h) {
		for (Preference p : preferenceList) {
			if (h == p.getHuman()) {
				return p.getRank();
			}
		}
		return 0;
	}

	private class PreferencseState {
		private Preference lastEvaluatedPreference;

		PreferencseState(Preference lastPreference) {
			this.lastEvaluatedPreference = lastPreference;
		}

		public Human nextPartner() {
			int index = preferenceList.indexOf(lastEvaluatedPreference) + 1;
			if (index < preferenceList.size()) {
				Preference p = this.lastEvaluatedPreference;
				this.lastEvaluatedPreference = preferenceList.get(index);
				return p.getHuman();
			}
			return lastEvaluatedPreference.getHuman();
		}

	}

}
