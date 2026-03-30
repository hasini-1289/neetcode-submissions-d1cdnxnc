class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // left → right
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;

            // top → bottom
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;

            // right → left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    res.add(matrix[row][left]);
                }
                left++;
            }
        }
        return res;
    }
}
