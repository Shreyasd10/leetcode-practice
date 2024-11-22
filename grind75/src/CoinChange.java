import java.util.*;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;

        for(int i = 0; i<=amount ; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + result);
    }
}
