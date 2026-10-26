class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0, profit = 0;
        int n = prices.length ;
        for(int i=0; i<n; i++){
            if(prices[i] < lowestPrice){
                lowestPrice = prices[i];
            }
            profit = prices[i] - lowestPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}