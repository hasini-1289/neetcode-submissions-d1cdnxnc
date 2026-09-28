class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                int j = map.get(need);
                if (j < i) {
                    return new int[]{j, i};
                } else {
                    return new int[]{i, j};
                }
            }
            map.put(nums[i], i);
        }
        return new int[]{}; 
    }
}