/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int low =0,high = n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        int peak = low;
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) return index;
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);

    }
    private int binarySearch(MountainArray arr, int target,
                             int low, int high, boolean asc) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (asc) {
                if (target < val) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target < val) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}