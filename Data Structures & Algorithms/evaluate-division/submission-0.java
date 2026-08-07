class Solution {
    class Pair{
        String node;
        double weight;
        Pair(String node,double weight){
            this.node = node;
            this.weight = weight;
        }
    }
    HashMap<String,List<Pair>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0;i<equations.size();i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, value));
            graph.get(v).add(new Pair(u, 1.0 / value));
        }
        double[] answer = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);
            if (!graph.containsKey(source) || !graph.containsKey(destination)) {
                answer[i] = -1.0;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            answer[i] = dfs(source, destination, visited, 1.0);
        }
        return answer;
    }
    private double dfs(String current,String destination,HashSet<String>visited,double product){
        if(current.equals(destination)){
            return product;
        }
        visited.add(current);
        for(Pair neigh: graph.get(current)){
            if(!visited.contains(neigh.node)){
                double result = dfs(neigh.node,destination,visited,product * neigh.weight);
                if(result != -1.0){
                    return result;
                }
            }
        }
        return -1.0;
    }
}