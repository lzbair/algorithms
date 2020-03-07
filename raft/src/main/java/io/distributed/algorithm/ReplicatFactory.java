package io.distributed.algorithm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReplicatFactory {

    public static Leader leader(Machine machine) {
        return new Leader(machine, new Log());
    }

    public static List<Follower> followers(Machine machine, int instances) {
        Stream<Follower> followers = IntStream.range(0, instances).mapToObj(i -> new Follower(machine, new Log()));
        return followers.collect(Collectors.toList());
    }
}
