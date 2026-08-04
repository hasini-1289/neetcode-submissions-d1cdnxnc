class Solution {
    int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            int p1 = find(edge[0]);
            int p2 = find(edge[1]);

            if (p1 == p2)
                return false; 

            parent[p1] = p2;
        }

        return true;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
}