package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameUp() {
        Comparator<Job> cmpNameUp = new JobDescByNameUp();
        int rsl = cmpNameUp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityUp() {
        Comparator<Job> cmpPriorityUp = new JobDescByPriorityUp();
        int rsl = cmpPriorityUp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDown() {
        Comparator<Job> cmpNameDown = new JobDescByNameDown();
        int rsl = cmpNameDown.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityDown() {
        Comparator<Job> cmpPriorityDown = new JobDescByPriorityDown();
        int rsl = cmpPriorityDown.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityUp() {
        Comparator<Job> cmpNamePriorityUp = new JobDescByNameUp().thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriorityUp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityDown() {
        Comparator<Job> cmpNamePriorityDown = new JobDescByNameDown().thenComparing(new JobDescByPriorityDown());
        int rsl = cmpNamePriorityDown.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}