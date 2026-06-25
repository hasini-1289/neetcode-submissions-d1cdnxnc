class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    void solve(int i,int[] nums,List<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));

        for(int j=i;j<nums.length;j++){
            if(j>i&&nums[j]==nums[j-1]) continue;

            temp.add(nums[j]);
            solve(j+1,nums,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}