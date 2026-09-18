package taskscheduler;

public class TaskScheduler {

    int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int maxFreqTasks = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqTasks++;
            }
        }

        int calculated = (maxFreq - 1) * (n + 1) + maxFreqTasks;

        return Math.max(tasks.length, calculated);
    }

    static void main(String[] args) {
        var inst = new TaskScheduler();

        System.out.println(inst.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(inst.leastInterval(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'C', 'C'}, 2));
    }
}
