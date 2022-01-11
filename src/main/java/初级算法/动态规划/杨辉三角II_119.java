package 初级算法.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class 杨辉三角II_119 {

    public static void main(String[] args) {

    }

    /**
     * 1.确定状态
     * 	List dp[i]表示索引为i这一行的数组
     * 2.找到转移公式
     * 	dp[i].set(0, 1)
     * 	dp[i].set(j, dp[i-1].get(j-1)+dp[i-1].get(j))
     * 	dp[i].set(i, 1);
     * 3.确定出是条件和边界条件
     * 	dp[0].set(0, 1)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        if(rowIndex == 0)
            return list0;

        List<Integer>[] dp = new ArrayList[rowIndex+1];
        dp[0] = list0;
        for(int i=1; i<=rowIndex; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1; j<i; j++){
                list.add(dp[i-1].get(j-1)+dp[i-1].get(j));
            }
            list.add(1);
            dp[i] = list;
        }

        return dp[rowIndex];
    }
}
