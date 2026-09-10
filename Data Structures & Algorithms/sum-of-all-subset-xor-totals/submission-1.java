class Solution {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or |= num;  
        }
        int n = nums.length;
        return or * (1 << (n - 1));
    }
}