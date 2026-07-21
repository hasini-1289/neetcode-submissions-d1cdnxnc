class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:prerequisites){
            int course = edge[0];
            int prereq = edge[1];
            adj.get(prereq).add(course);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathvisited)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>>adj,boolean[]visited,boolean[]pathvisited){
        visited[node]= true;
        pathvisited[node]= true;
        for (int v : adj.get(node)){
            if(!visited[v]){
                if(dfs(v,adj,visited,pathvisited)){
                    return true;
                }
            }else if(pathvisited[v]){
                return true;
            }
        }
        pathvisited[node]= false;
        return false;
    }
}
