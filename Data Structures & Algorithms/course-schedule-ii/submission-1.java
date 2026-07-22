class Solution {
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(dfs(i, adj, visited, pathVisited)) {
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while(!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }
        return ans;
    }
    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbor : adj.get(node)) {

            if(!visited[neighbor]) {

                if(dfs(neighbor, adj, visited, pathVisited))
                    return true;
            }

            else if(pathVisited[neighbor]) {
                return true;
            }
        }
        pathVisited[node] = false;
        stack.push(node);
        return false;
    }
}
