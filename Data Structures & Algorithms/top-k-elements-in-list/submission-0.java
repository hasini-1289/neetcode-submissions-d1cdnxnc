class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        heap.addAll(freq.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}
