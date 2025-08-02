public class BuySellStock {
    static int maxProfit(int[] prices) {
        int maxP = 0;
        int minSoFar = prices[0];
        for(int i=0; i<prices.length; i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            int profit = prices[i] - minSoFar;
            maxP = Math.max(maxP, profit);
        }
        return maxP;
    }
    public static void main(String[] args) {
     int[]  prices = {7,1,5,3,6,4};
     System.out.println(maxProfit(prices));
    }
}
