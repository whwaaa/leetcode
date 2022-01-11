package 力扣题库.简单;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class 判断子序列_392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean res = isSubsequence(s, t);
        System.out.println(res);
    }

    /**
     * TODO: 双指针
     * 一个指针指向s的索引, 一个指向t
     * 遍历s, 在t中找到第一个相同的字符, 若s遍历完成, t都找到则返回true, 若t下标越界, 则返回false
     */
    public static boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int j = 0;;
        if(slen > tlen)
            return false;
        if(slen==0 && tlen==0)
            return true;
        for(int i=0; i<slen; i++){
            char temp = s.charAt(i);

            try {
                while(t.charAt(j++) != temp);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
