package 初级算法.字符串;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/12
 * @Week: 星期日
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 */
public class 整数反转 {

    public static void main(String[] args) {
        int i = -123;
        int reverse = reverse2(i);
        System.out.println(reverse);
    }


    // 低位反转高位
    // 溢出判断, 将结果反运算与原来相比较
    // 图解: https://gitee.com/hanweiwu/tuchuang/raw/master/img/202112121823072.png
    public static int reverse2(int x) {
        int res = 0;
        int newRes;
        int t;
        while(x != 0){
            t = x % 10;
            newRes = res * 10 + t;
            if((newRes - t) / 10 != res){
                // 溢出,返回0
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
    }

    // 转换为char数组, 通过数组反转, 再转换为int返回
    public static int reverse(int x) {
        // 2147483648
        char[] chars = String.valueOf(Math.abs(x)).toCharArray();
        int len = chars.length;
        if(len == 1)
            return x;
        if(len == 11)
            return 0;
        int l = 0;
        int r = len - 1;
        char temp;
        while(l<r){
            temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            r--;
            l++;
        }
        // 取出除各位的数,需满足条件:
        int high = Integer.parseInt(String.valueOf(chars).substring(0, len - 1));
        int low = Integer.parseInt(String.valueOf(chars).substring(len - 1));
        int res;
        if(x > 0){
            if(high > 214748364 || high == 214748364 && low > 7){
                return 0;
            }
            res = Integer.parseInt(String.valueOf(chars));
        }else{
            if(high > 214748364 || high == 214748364 && low > 8){
                return 0;
            }
            res = Integer.parseInt("-"+String.valueOf(chars));
        }
        return res;
    }

}
