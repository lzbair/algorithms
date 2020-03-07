package io.distributed.algorithm;

public class Follower extends Replicat {

    Election election;

    public Follower(Machine machine, Log log) {
        super(machine, log);
    }

    void hearBeat() {
        election.keepAlive()
    }


}
