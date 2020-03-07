package io.distributed.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Log {

    Queue values = new LinkedList<LogEntry>();

    public LogResult add(LogEntry entry) {
        final boolean logged = values.add(entry);
        return new LogResult(logged);
    }

    static class LogResult {
        boolean hasError;

        public LogResult(boolean hasError) {
            this.hasError = hasError;
        }

        boolean hasError() {
            return hasError;
        }
    }

    static class EntryNotification {
        Log.LogEntry entry;

        public EntryNotification(LogEntry entry) {
            this.entry = entry;
        }

        LogResult push(List<Follower> followers) {
            Optional<LogResult> result = followers.stream().map(r -> r.log(entry)).filter(LogResult::hasError).findFirst();
            return result.orElse(new LogResult(true));
        }
    }

    class LogEntry {

    }
}
