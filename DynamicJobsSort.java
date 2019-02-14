import java.util.*;
import java.io.*;

public class DynamicJobsSort implements Comparator<Jobs> {
    private static int compareBy = 0;

    public DynamicJobsSort(int compareBy) {
        this.compareBy = compareBy;
    }

    public DynamicJobsSort compareBy(int compareBy) {
        this.compareBy = compareBy;
        return this;
    }

    public int compare(Jobs a, Jobs b) {
        if (compareBy == 0) {
            return (int) a.getDistance() - b.getDistance();
        } else if (compareBy == 1) {
            return a.getOrigin().compareTo(b.getOrigin());
        } else if (compareBy == 2) {
            return a.getDestination().compareTo(b.getDestination());
        } else {
            return (int) a.getBudget() - b.getBudget();
        }
    }
}