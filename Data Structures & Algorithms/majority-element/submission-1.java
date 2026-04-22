class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = n/2;
        for(int i=0;i<n;i++){
            int newcount=0;
            for(int j=0; j<n;j++){
                if(nums[i] == nums[j]){
                    newcount++;
                }
            }
            if(newcount > count ) return nums[i];

        }
        return -1;
        
    }
}