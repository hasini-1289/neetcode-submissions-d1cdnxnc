class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        for(String s: deadends){
            dead.add(s);
        }
        if(dead.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int moves =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String current = (String) q.poll();
                if(current.equals(target)){
                     return moves;
                }
                for(int j=0;j<4;j++){
                    char[] arr = current.toCharArray();
                    char original = arr[j];
                    arr[j] = (original == '9') ? '0' : (char)(original + 1);
                    String next = new String(arr);
                    if(!dead.contains(next) && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                    arr[j] = original;
                    arr[j] = (original == '0')? '9' : (char) (original -1);
                    next = new String(arr);
                    if(!dead.contains(next) && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
        
    }
}