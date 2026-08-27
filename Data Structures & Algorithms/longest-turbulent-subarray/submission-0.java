class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n == 1) return 1;
        int prev =0;
        int currlen =1;
        int maxlen = 1;
        for(int i=1;i<n;i++){
            int current;
            if(arr[i-1]> arr[i]){
                current =1;
            }else if(arr[i-1]<arr[i]){
                current = -1;
            }else{
                current =0;
            }
            if(current == 0){
                currlen =1;
            }else if(prev != current){
                currlen++;
            }else{
                currlen =2;
            }
            maxlen = Math.max(maxlen,currlen);
            prev = current;
        }
        return maxlen;
    }
}