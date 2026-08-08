class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> answer = new ArrayList<>();
        if (n == 1) {
            answer.add(0);
            return answer;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int remaining = n;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                for (int neighbour : graph.get(leaf)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            answer.add(queue.poll());
        }
        return answer;
    }
}