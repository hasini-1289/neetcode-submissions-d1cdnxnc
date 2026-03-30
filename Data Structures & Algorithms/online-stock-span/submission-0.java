class StockSpanner {

    // Stack stores {price, span}
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Merge spans while previous prices are smaller or equal
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push current price with its calculated span
        stack.push(new int[]{price, span});

        return span;
    }
}
