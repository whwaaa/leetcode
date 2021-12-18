package 初级算法.字符串;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/18
 * @Week: 星期六
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 *
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] strs = {"floawer"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);

    }

    // 按照题意,逐个字符串进行比较
    // 先取出每个字符串的长度存入数组, 进行排序, 取出长度最短的进行遍历
    // abc abcd abcde
    // axx axxx axxxx -> abx abxx abxxxx -> abc abcx abcxx
    // 没比较一层相等, count自增, 最后返回截取字符串 0 ~ count 即可
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 1)
            return strs[0];
        int[] lenArr = new int[len];
        int count = 0;
        for(int i=0; i<len; i++)
            lenArr[i] = strs[i].length();
        try {
            for(int i=0; i<lenArr[0]; i++){
                for(int j=0; j<len; j++){
                    if(strs[0].charAt(i) != strs[j].charAt(i))
                        throw new Exception();
                }
                count++;
            }
        } catch (Exception e) {}

        return strs[0].substring(0, count);
    }
}
























