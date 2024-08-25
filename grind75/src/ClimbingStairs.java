import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer,Integer> memo = new HashMap<>();
        return climbingHelper(n,memo);
    }

    private int climbingHelper(int n, Map<Integer, Integer> memo) {
        if(n == 0 || n == 1 ){
            return 1;
        }
        if(!memo.containsKey(n)){
            memo.put(n,climbingHelper(n - 1 ,memo) + climbingHelper(n - 2,memo));
        }
        return memo.get(n);
    }

    public int climbStairsV2(int n){
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2 ;i<=n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        int n = 5; // Example number of stairs
        int result = climbingStairs.climbStairs(n);

        System.out.println("Number of ways to climb " + n + " stairs: " + result);
    }

}
