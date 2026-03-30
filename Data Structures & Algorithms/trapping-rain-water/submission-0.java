class Solution {
    public int trap(int[] height) {

        int left = 0;                       // left pointer
        int right = height.length - 1;       // right pointer

        int leftMax = 0;                    // highest wall seen from the left
        int rightMax = 0;                   // highest wall seen from the right

        int trapped = 0;                    // total water trapped

        while (left < right) {              // process until pointers meet

            if (height[left] < height[right]) {
                // update leftMax if needed
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trapped += leftMax - height[left];
                }
                left++;                     // move left pointer
            } 
            else { // height[right] <= height[left]
                // update rightMax if needed
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trapped += rightMax - height[right];
                }
                right--;                    // move right pointer
            }
        }

        return trapped;
    }
}