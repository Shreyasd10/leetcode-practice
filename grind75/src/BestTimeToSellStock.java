public class BestTimeToSellStock {

    public static int maxProfit(int[] input){
        //prices = [7,1,5,3,6,4]
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int value : input){
            if(value < min){
                min = value;
            }
            int currentMaxProfit = value - min;
            maxProfit = Math.max(maxProfit,currentMaxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("The max profit is "+maxProfit(prices));
    }
}
