package io.stablematching;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MatchingTest {

    @Test
    public void test() {


        Man m1 = new Man("m1");
        Man m2 = new Man("m2");

        Woman w1 = new Woman("w1");
        Woman w2 = new Woman("w2");


        Set<Man> mans = setup(m1, m2, w1, w2);
        Matching matching = new Matching(mans);
        Map<Woman, Man> result = matching.match();

        Assert.assertEquals(result.get(w1), m2);
        Assert.assertEquals(result.get(w2), m1);

    }

    private Set<Man> setup(Man m1, Man m2, Woman w1, Woman w2) {

        Set<Man> mans = new HashSet<Man>();

        //m1
        List<Preference> mPreferenceList = new ArrayList<Preference>();
        mPreferenceList.add(new Preference(w1, 2));
        mPreferenceList.add(new Preference(w2, 1));
        m1.addPreferences(new Preferences(mPreferenceList));


        //m2
        List<Preference> m2PreferenceList = new ArrayList<Preference>();
        m2PreferenceList.add(new Preference(w1, 2));
        m2PreferenceList.add(new Preference(w2, 1));
        m2.addPreferences(new Preferences(m2PreferenceList));


        //w1
        List<Preference> w1PreferenceList = new ArrayList<Preference>();
        w1PreferenceList.add(new Preference(m2, 2));
        w1PreferenceList.add(new Preference(m1, 1));
        w1.addPreferences(new Preferences(w1PreferenceList));


        //w2
        List<Preference> w2PreferenceList = new ArrayList<Preference>();
        w2PreferenceList.add(new Preference(m2, 2));
        w2PreferenceList.add(new Preference(m1, 1));
        w2.addPreferences(new Preferences(w2PreferenceList));

        mans.add(m1);
        mans.add(m2);

        return mans;
    }

}
