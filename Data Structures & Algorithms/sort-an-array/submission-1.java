class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    private void mergeSort(int[] nums,int start,int end){
        if(start >= end) return;
        int mid = start+(end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    private void merge(int[] nums,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k=0;
        int[] temp = new int[end-start + 1];
        while(i<=mid && j<= end){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i];
                i++;
            }else{
                temp[k++] = nums[j];
                j++;
            }
        }
        while(i<=mid){
            temp[k++] = nums[i];
            i++;
        }
        while(j<=end){
            temp[k++] = nums[j];
            j++;
        }
        for(int index=0;index<temp.length;index++){
            nums[index+start] = temp[index];
        }
    }
}