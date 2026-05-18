class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates,int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }

    void backtrack(int[] arr,int target,int idx,List<Integer> list,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(i>idx&&arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            list.add(arr[i]);
            backtrack(arr,target-arr[i],i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
}