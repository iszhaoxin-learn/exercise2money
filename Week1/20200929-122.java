class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int maxProfit = 0, curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                maxProfit += (prices[i - 1] - curMin);
                curMin = prices[i];
            }
            
            if (i == prices.length - 1 && prices[i] >= prices[i - 1]) maxProfit += (prices[i] - curMin);
        }
        
        return maxProfit;
    }
}