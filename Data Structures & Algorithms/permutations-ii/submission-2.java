class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        solve(nums,used,new ArrayList<>(),ans);
        return ans;
    }

    void solve(int[] nums,boolean[] used,List<Integer> temp,List<List<Integer>> ans){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])) continue;

            used[i]=true;
            temp.add(nums[i]);

            solve(nums,used,temp,ans);

            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}