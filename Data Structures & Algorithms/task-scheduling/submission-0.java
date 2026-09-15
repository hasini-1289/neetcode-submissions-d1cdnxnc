class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }
        int maxfreq = 0;
        for(int f:freq){
            maxfreq = Math.max(f,maxfreq);
        }
        int maxcount =0;
        for(int f: freq){
            if(f==maxfreq){
                maxcount++;
            }
        }
        int formula = (maxfreq-1)*(n+1)+maxcount;
        int ans = Math.max(tasks.length,formula);
        return ans;
    }
}
