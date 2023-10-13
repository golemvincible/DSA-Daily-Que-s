public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int mini = prices[0], profit=0;
        
        for(int i=1;i<prices.length;i++){
            int cost = prices[i]-mini;
            
            profit = Math.max(profit,cost);
            
            mini = Math.min(mini,prices[i]);
        }
        
        return profit;
    }
}
