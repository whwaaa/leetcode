package 力扣题库.热题HOT.简单;

import java.util.*;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/18
 * @Week: 星期六
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class 杨辉三角118 {

    public static void main(String[] args) {
        int numRows = 1;
        List<List<Integer>> generate = generate(numRows);
        for (List<Integer> integers : generate) {
            System.out.println();
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }
    }


    public static List<List<Integer>> generate(int numRows) {
        // len=n
        List<List<Integer>> list = new LinkedList<>();
        List list1 = new LinkedList();
        list1.add(1);
        list.add(list1);
        if(numRows == 1)
            return list;
        for(int i=2; i<=numRows; i++){ // i:层数
            List<Integer> row = new LinkedList<>();
            row.add(1);
            List<Integer> integers = list.get(i - 2);
            for(int j=1; j<i-1; j++){ // 集合元素索引
                row.add(integers.get(j-1)+integers.get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}


















