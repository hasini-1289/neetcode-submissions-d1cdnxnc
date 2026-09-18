class Solution{
    static class Pair{
        char ch;
        int freq;

        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }

    public String reorganizeString(String s){
        int[] freq=new int[26];

        for(char ch:s.toCharArray())
            freq[ch-'a']++;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(freq[i]>(s.length()+1)/2)return "";
                pq.offer(new Pair((char)('a'+i),freq[i]));
            }
        }

        StringBuilder ans=new StringBuilder();
        Pair prev=null;

        while(!pq.isEmpty()){
            Pair cur=pq.poll();

            ans.append(cur.ch);
            cur.freq--;

            if(prev!=null&&prev.freq>0)
                pq.offer(prev);

            prev=cur;
        }

        return ans.length()==s.length()?ans.toString():"";
    }
}