package 初级算法.动态规划;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        int n = 3;
        int res = climbStairs(n);
        System.out.println(res);
    }

    public static int climbStairs(int n) {
        if(n < 3)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
