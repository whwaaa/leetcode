package 初级算法.动态规划;

public class 买卖股票最佳时机 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        int[][] dp = new int[len][2];   // dp[i][0] 不持有股票   dp[i][1] 持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len-1][0];
    }
}
