package io.distributed.algorithm;

import java.util.List;

public class Cluster {

    static final int INSTANCES = 5;
    Leader leader;
    List<Follower> followers;
    ElectionPolicy electionPolicy;

    public static Cluster start(Machine machine) {
        Cluster cluster = new Cluster();
        cluster.leader = ReplicatFactory.leader(machine);
        cluster.followers = ReplicatFactory.followers(machine, INSTANCES);
        return cluster;
    }

    void accept(Log.LogEntry entry) {
        Log.LogResult result = leader.newNotification(entry).push(followers);
        if (!result.hasError()) {
            followers.stream().forEach(r -> r.applyLog());
        }
    }

    void electionPolicy(ElectionPolicy electionPolicy) {
        this.electionPolicy = electionPolicy;
    }
}
