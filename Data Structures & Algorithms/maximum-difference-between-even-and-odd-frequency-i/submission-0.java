class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        int mineven  =Integer.MAX_VALUE;
        int maxodd =0;
        int ans =0;
        for(int c : freq){
            if(c==0) continue;
            if(c % 2 == 0){
                mineven = Math.min(mineven,c);
            }else{
                maxodd = Math.max(maxodd,c);
            }
        }
        return maxodd-mineven;
    }
}