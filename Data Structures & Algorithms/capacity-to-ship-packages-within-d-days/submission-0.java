class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0,high =0;
        for(int w: weights){
            low = Math.max(low,w);
            high+= w;
        }
        
        while(low < high){
            int mid = low +(high-low)/2;
            if(canShip(weights,days,mid)){
                
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean canShip(int[] weights,int days,int capacity){
        int dayCount = 1;
        int currentload = 0;
        for(int w : weights){
            if(currentload + w > capacity){
                dayCount++;
                currentload = w;
            }else{
                currentload += w;
            }        
        }
        return dayCount <= days;
    }
}