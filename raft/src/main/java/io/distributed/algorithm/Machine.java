package io.distributed.algorithm;

public class Machine {

    State state;

    public void run(Log log) {
        state.apply(log);
    }

    class State {

        public void apply(Log log) {
            //
        }
    }


}
