class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit =0;
        int bestbuy=Integer.MAX_VALUE;
        for(int price : prices ){
            if(price <= bestbuy){
                bestbuy = price;
            }else{
                int profit = price - bestbuy;
                maxprofit = Math.max(maxprofit,profit);
            }
        }
        return maxprofit;
    }
}
