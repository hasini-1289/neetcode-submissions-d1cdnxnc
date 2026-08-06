class Solution {
    int[] parent;
    int[] rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        HashMap<String,Integer> emailToAccount=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(!emailToAccount.containsKey(email)){
                    emailToAccount.put(email,i);
                }else{
                    union(i,emailToAccount.get(email));
                }
            }
        }
        HashMap<Integer,TreeSet<String>> map=new HashMap<>();
        for(String email:emailToAccount.keySet()){
            int account=emailToAccount.get(email);
            int root=find(account);
            map.putIfAbsent(root,new TreeSet<>());
            map.get(root).add(email);
        }

        List<List<String>> ans=new ArrayList<>();
        for(int root:map.keySet()){
            List<String> list=new ArrayList<>();
            list.add(accounts.get(root).get(0));
            list.addAll(map.get(root));
            ans.add(list);
        }
        return ans;
    }
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return;
        }
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[px]<rank[py]){
            parent[px]=py;
        }else{
            parent[py]=px;
            rank[px]++;
        }
    }
}