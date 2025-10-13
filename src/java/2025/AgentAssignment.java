record Assignment(
        Integer agentId,
        long assignedOrder
) {
}

public static Map<Integer, String> assignTasks(int numAgents, List<String> tasks) {
    if (numAgents <= 0) {
        throw new IllegalArgumentException("numAgents should be > 0");
    }
    Map<Integer, String> agentToTask = new HashMap<>();
    TreeSet<Integer> available = new TreeSet<>();
    for (int i = 0; i < numAgents; i++) {
        available.add(i);
    }
    PriorityQueue<Assignment> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a.assignedOrder));
    long order = 0;

    for (String task : tasks) {
        if (!available.isEmpty()) {
            Integer agent = available.pollFirst();
            agentToTask.put(agent, task);
            heap.add(new Assignment(agent, order++));
        } else {
            Assignment oldest = heap.poll();
            Integer agent = oldest.agentId;
            agentToTask.put(agent, task);
            heap.add(new Assignment(agent, order++));
        }
    }
    return agentToTask;
}

void main() {
    List<String> tasks = Arrays.asList("T1", "T2", "T3", "T4", "T5");
    Map<Integer, String> res = assignTasks(3, tasks); // 3 agents, 5 tasks
    IO.println(res); // e.g. {0=T4, 1=T5, 2=T3} depending on eviction order
}
