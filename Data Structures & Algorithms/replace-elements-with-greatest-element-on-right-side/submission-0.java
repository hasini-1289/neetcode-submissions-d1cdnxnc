class Solution {
    public int[] replaceElements(int[] arr) {
        int maxRight = -1;              // last element becomes -1
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];      // store original
            arr[i] = maxRight;        // replace with max on right
            if (current > maxRight) { // update max
                maxRight = current;
            }
        }
        return arr;
    }
}