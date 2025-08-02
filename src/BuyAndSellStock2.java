public class BuyAndSellStock2 {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(buyAndSellStock2(prices));
    }
    public static int buyAndSellStock2(int[] prices){
        int max_profit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i]< prices[i+1]){
                max_profit +=prices[i+1] - prices[i];
            }

        }
        return max_profit;
    }
}
