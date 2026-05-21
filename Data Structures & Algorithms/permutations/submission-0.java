class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }
    void backtrack(int[] nums,List<Integer> list,boolean[] used){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            list.add(nums[i]);
            backtrack(nums,list,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}