package topkfrequency;

import java.util.*;

public class TopKFrequency {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );


        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            heap.offer(entry);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }

        return res;
    }

    public int[] topKFrequentBucketSort(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (var entry : frequency.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int i = 0;

        for (int freq = bucket.length - 1; freq >= 1 && i < k; freq--) {
            if (bucket[freq] == null) {
                continue;
            }

            for (Integer num : bucket[freq]) {
                res[i++] = num;

                if (i == k) {
                    break;
                }
            }
        }

        return res;
    }

    static void main(String[] args) {
        TopKFrequency topKFrequency = new TopKFrequency();
        System.out.println(Arrays.toString(topKFrequency.topKFrequent(new int[]{3, 2, 1, 5, 6, 4}, 2)));
        System.out.println(Arrays.toString(topKFrequency.topKFrequent(new int[]{3, 3, 3, 2, 2, 1, 1, 5, 6, 4}, 2)));
        System.out.println();
        System.out.println(Arrays.toString(topKFrequency.topKFrequentBucketSort(new int[]{3, 2, 1, 5, 6, 4}, 2)));
        System.out.println(Arrays.toString(topKFrequency.topKFrequentBucketSort(new int[]{3, 3, 3, 2, 2, 2, 1, 1, 1, 5, 6, 4}, 2)));

    }
}
