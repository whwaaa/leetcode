package 初级算法.动态规划;

public class 买卖股票最佳时机II {

    public static void main(String[] args) {
        int[] prices = {1,2,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * 1.确定状态
     * dp1[i]表示第i天没有持股的最大利润
     * dp2[i]表示第i天持股的最大利润
     *
     * 2.找转移公式
     * dp1[i] = Math.max(dp1[i-1], dp2[i-1] + price[i])
     * dp2[i] = Math.max(dp2[i-1], dp1[i-1] - price[i])
     *
     * 3.确定初始条件和边界条件
     * dp1[0] = 0;
     * dp2[0] = -price[0];
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了32.63%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了33.65%的用户
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = 0;
        dp2[0] = -prices[0];
        for(int i=1; i<len; i++){
            dp1[i] = Math.max(dp1[i-1], dp2[i-1] + prices[i]);
            dp2[i] = Math.max(dp2[i-1], dp1[i-1] - prices[i]);
        }
        return dp1[len-1];
    }





    /**
     * 双指针,slow指向购买日,fast指向售出日
     * 1.买入时间: 只要后一天价格上涨, 今天就购买
     * 2.出售时间: 只要后一天的价格降低, 那今天就卖出
     * @param prices
     * @return
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了85.80%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了69.91%的用户
     */
    public static int maxProfit_old_002(int[] prices) {
        int len = prices.length;
        int slow = 0;   // 指向买入天
        int fast;   // 指向售出天
        int profits = 0;
        while (true) {
            while (slow + 1 <= len - 1 && prices[slow + 1] < prices[slow])  // slow + 1 <= len - 1
                slow++;
            // 最后一天架构都没有上涨,则不购买,跳出
            if(slow + 1 > len - 1)
                break;
            // 正常买
            fast = slow + 1;

            while (fast + 1 <= len -1 && prices[fast + 1] > prices[fast])
                fast++;
            // 直到最后一天架构都没有后一天价格下降的情况,则最后一天卖出,跳出
            profits += prices[fast] - prices[slow];
            if (fast + 1 > len - 1)  // fast + 1 <= len - 1
                break;
            // 正常售出
            slow = fast + 1;
        }

        return profits;
    }



    public static int maxProfit_old_001(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int max=0; int slow=0; int fast=1;
        int len = prices.length;

        while(fast+1 <= len-1){
            //
            if(prices[fast] > prices[slow]){
                // 快指针的后一天售价降低
                if(prices[fast+1] < prices[fast]){
                    // 交易获取利润
                    max += prices[fast] - prices[slow];
                    slow = fast + 1;
                    fast++;
                }
                fast++;
            }else{
                slow = fast;
                fast++;
            }
        }
        // 由于前循环中只能计算fast的利润, 而fast最大只能取数组倒数第二位跳出循环,
        // 因此需要单独计算最后一天的利润
        max += prices[len-1]>prices[slow] ? prices[len-1]-prices[slow] : 0;

        return max;
    }
}
