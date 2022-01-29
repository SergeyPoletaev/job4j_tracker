package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenJobAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(
                new Job("test1", 2),
                new Job("test2", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("test1", 2),
                new Job("test2", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("test2", 1),
                new Job("test1", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("test2", 1),
                new Job("test1", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobByNameEqThenAscByPriority() {
        Comparator<Job> comp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comp.compare(
                new Job("test1", 2),
                new Job("test1", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobByPriorityEqThenDescByName() {
        Comparator<Job> comp = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = comp.compare(
                new Job("test2", 2),
                new Job("test1", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}