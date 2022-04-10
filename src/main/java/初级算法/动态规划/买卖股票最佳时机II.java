package 初级算法.动态规划;

public class 买卖股票最佳时机II {

    /**
     * 1.买入时间: 只要后一天价格上涨, 今天就购买
     * 2.出售时间: 只要后一天的价格降低, 那今天就卖出
     * @param prices
     * @return
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了85.80%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了69.91%的用户
     */
    public static int maxProfit(int[] prices) {
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
        // else if(prices.length == 2){
        //     return prices[1]>prices[0] ? prices[1]-prices[0] : 0;
        // }
        int max=0; int slow=0; int fast=1;
        int len = prices.length;

        while(fast+1 <= len-1){
            // 快指针那天售价高于慢指针那天售价
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
