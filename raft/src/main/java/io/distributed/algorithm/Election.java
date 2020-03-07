package io.distributed.algorithm;

import java.time.Duration;
import java.util.Date;

public class Election {

    String electedLeader;
    Duration term;
    long electionTimeout;

    public void keepAlive() {
        new Date().getTime()
    }
}
