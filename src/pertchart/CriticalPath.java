package pertchart;
/*
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import csvExample.domain.Tasks;

public class CriticalPath {
    public static int maxCost;
    public static String format = "%1$-10s %2$-5s %3$-5s %4$-5s %5$-5s %6$-5s %7$-10s\n";

/*	    public static void main(String[] args) {
        // The example dependency graph
        HashSet<Tasks> allTask = new HashSet<Task>();
        Task end = new Task("End", 0);
        Task F = new Task("F", 2, end);
        Task A = new Task("A", 3, end);
        Task X = new Task("X", 4, F, A);
        Task Q = new Task("Q", 2, A, X);
        Task start = new Task("Start", 0, Q);
        allTasks.add(end);
        allTasks.add(F);
        allTasks.add(A);
        allTasks.add(X);
        allTasks.add(Q);
        allTasks.add(start);
        Task[] result = criticalPath(allTasks);
        print(result);
        // System.out.println("Critical Path: " + Arrays.toString(result));
    }
*/
    
/*    // A wrapper class to hold the tasks during the calculation
    public static class Task {
        // the actual cost of the task
        public int cost;
        // the cost of the task along the critical path
        public int criticalCost;
        // a name for the task for printing
        public String name;
        // the earliest start
        public int earlyStart;
        // the earliest finish
        public int earlyFinish;
        // the latest start
        public int latestStart;
        // the latest finish
        public int latestFinish;
        // the tasks on which this task is dependant
        public HashSet<Task> dependencies = new HashSet<Task>();

        public Task(String name, int cost, Task... dependencies) {
            this.name = name;
            this.cost = cost;
            for (Task t : dependencies) {
                this.dependencies.add(t);
            }
            this.earlyFinish = -1;
        }

        public void setLatest() {
            latestStart = maxCost - criticalCost;
            latestFinish = latestStart + cost;
        }

        public String[] toStringArray() {
            String criticalCond = earlyStart == latestStart ? "Yes" : "No";
            String[] toString = { name, earlyStart + "", earlyFinish + "", latestStart + "", latestFinish + "",
                    latestStart - earlyStart + "", criticalCond };
            return toString;
        }

        public boolean isDependent(Task t) {
            // is t a direct dependency?
            if (dependencies.contains(t)) {
                return true;
            }
            // is t an indirect dependency
            for (Task dep : dependencies) {
                if (dep.isDependent(t)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static Tasks[] criticalPath(List<Tasks> tasks) {
        // tasks whose critical cost has been calculated
        HashSet<Tasks> completed = new HashSet<Tasks>();
        // tasks whose critical cost needs to be calculated
        HashSet<Tasks> remaining = new HashSet<Tasks>(tasks);

        // Backflow algorithm
        // while there are tasks whose critical cost isn't calculated.
        while (!remaining.isEmpty()) {
            boolean progress = false;

            // find a new task to calculate
            for (Iterator<Tasks> it = remaining.iterator(); it.hasNext();) {
                Tasks task = it.next();
                if (completed.containsAll(task.getPreceedingTasks())) {
                    // all dependencies calculated, critical cost is max
                    // dependency
                    // critical cost, plus our cost
                    int critical = 0;
                    for (Tasks t : task.getPreceedingTasks()) {
                        if (t.criticalCost > critical) {
                            critical = t.criticalCost;
                        }
                    }
                    task.criticalCost = critical + task.cost;
                    // set task as calculated an remove
                    completed.add(task);
                    it.remove();
                    // note we are making progress
                    progress = true;
                }
            }
            // If we haven't made any progress then a cycle must exist in
            // the graph and we wont be able to calculate the critical path
            if (!progress)
                throw new RuntimeException("Cyclic dependency, algorithm stopped!");
        }

        // get the cost
        maxCost(tasks);
        HashSet<Tasks> initialNodes = initials(tasks);
        calculateEarly(initialNodes);

        // get the tasks
        Tasks[] ret = completed.toArray(new Tasks[0]);
        // create a priority list
        Arrays.sort(ret, new Comparator<Task>() {

            @Override
            public int compare(Tasks o1, Tasks o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        return ret;
    }

    public static void calculateEarly(HashSet<Tasks> initials) {
        for (Tasks initial : initials) {
            initial.earlyStart = 0;
            initial.earlyFinish = initial.cost;
            setEarly(initial);
        }
    }

    public static void setEarly(Tasks initial) {
        int completionTime = initial.earlyFinish;
        for (Tasks t : initial.dependencies) {
            if (completionTime >= t.earlyStart) {
                t.earlyStart = completionTime;
                t.earlyFinish = completionTime + t.cost;
            }
            setEarly(t);
        }
    }

    public static HashSet<Tasks> initials(Set<Tasks> tasks) {
        HashSet<Tasks> remaining = new HashSet<Tasks>(tasks);
        for (Tasks t : tasks) {
            for (Tasks td : t.dependencies) {
                remaining.remove(td);
            }
        }

        System.out.print("Initial nodes: ");
        for (Tasks t : remaining)
            System.out.print(t.name + " ");
        System.out.print("\n\n");
        return remaining;
    }

    public static void maxCost(Set<Tasks> tasks) {
        int max = -1;
        for (Tasks t : tasks) {
            if (t.criticalCost > max)
                max = t.criticalCost;
        }
        maxCost = max;
        System.out.println("Critical path length (cost): " + maxCost);
        for (Tasks t : tasks) {
            t.setLatest();
        }
    }

    public static void print(Tasks[] tasks) {
        System.out.format(format, "Task", "ES", "EF", "LS", "LF", "Slack", "Critical?");
        for (Tasks t : tasks)
            System.out.format(format, (Object[]) t.toStringArray());
    }
}
*/