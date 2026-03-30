class Solution {
    public int findMin(int[] nums) {

        int left = 0;                   // start index
        int right = nums.length - 1;    // end index

        while (left < right) {          // binary search loop

            int mid = left + (right - left) / 2;

            // If middle element is greater than right element
            // minimum must be on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, minimum is on the left side (including mid)
            else {
                right = mid;
            }
        }

        // left == right → pointing to minimum element
        return nums[left];
    }
}
