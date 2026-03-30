class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest =0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentstreak = 1;
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentstreak++;
                }
                longest = Math.max(longest,currentstreak);
            }
        }
        return longest;
    }
}
