package io.distributed.algorithm;


public class Replicat {
    Machine machine;
    Log log;

    public Replicat(Machine machine, Log log) {
        this.machine = machine;
        this.log = log;
    }

    Log.LogResult log(Log.LogEntry entry) {
        return log.add(entry);
    }

    Log.EntryNotification newNotification(Log.LogEntry entry) {
        this.log(entry);
        return new Log.EntryNotification(entry);
    }

    void applyLog() {
        machine.run(log);
    }


}
