package ru.job4j.tracker.collection;

public class Job implements Comparable<Job> {
    private final String name;
    private final int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Job o) {
        return Integer.compare(this.priority, o.priority);
    }

    @Override
    public String toString() {
        return "Job{" + "name='" + name + '\'' + ", priority=" + priority + '}';
    }
}
