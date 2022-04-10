package 初级算法.字符串;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/6
 * @Week: 星期一
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 */
public class 反转字符串 {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        doublePointerChange(s);


    }

    public static void doublePointerChange(char[] s){

        int l = 0;
        int r = s.length-1;
        while(l<r){
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
        List<Character> list = new ArrayList<>();
        for(int i=0; i<s.length; i++){
            list.add(s[i]);
        }
        list.forEach(System.out::print);
    }

    // 双指针法 (优先考虑)
    public static void reverseString(char[] s) {
        if(s.length == 1)
            return;
        int l = 0;
        int r = s.length - 1;
        while(l < r){
//            // 中间变量交换法
//            char temp = s[l];
//            s[l] = s[r];
//            s[r] = temp;
            // 加减法交换
//            s[l] += s[r];
//            s[r] = (char)(s[l] - s[r]);
//            s[l] -= s[r];
            // 异或交换 A^(A^B)=B   B^(A^B)=A
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }

    // 对称交换法
    public static void reverseString2(char[] s) {
        if(s.length == 1)
            return;
        int len = s.length;
        char temp;
        for(int i=0; i<len/2; i++){
            temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
    }
}
