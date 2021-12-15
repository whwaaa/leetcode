package 初级算法.字符串;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/15
 * @Week: 星期三
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * atoi (表示 ascii to integer)是把字符串转换成整型数的一个函数，应用在计算机程序和办公软件中。
 * int atoi(const char *nptr) 函数会扫描参数 nptr字符串，会跳过前面的空白字符（例如空格，tab缩进）等。
 * 如果 nptr不能转换成 int 或者 nptr为空字符串，那么将返回 0
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 */
public class 字符串转换整数atoi {
    public static void main(String[] args) {
//        String s = "   fds34fg34";
//        String s = "2147483647";

        String s = "-91283472339992";
        int i = myAtoi(s);
        System.out.println(i);

//        int i = Math.addExact(Integer.MIN_VALUE, Integer.MIN_VALUE);
//        System.out.println(i);

    }


    public static int myAtoi(String s) {
        int len = s.length();
        int i = -1;
        int c = 0;
        int sym = 1;    // 符号位,1正数,-1负数
        int count = 0;
        // 遍历所有空格
        do{
            if(++i == len)
                return 0;
            c = s.charAt(i);
        } while(c == (int)' ');
        // 判断是正是负
        if(c == (int)'-'){
            // 负数,取-号后一个字符,可能是数字可能是其他
            if(++i == len)
                return 0;
            c = s.charAt(i);
            sym = -1;
        }else if(c == (int)'+'){
            // 正数,取+号后一个字符,可能是数字可能是其他
            if(++i == len)
                return 0;
            c = s.charAt(i);
        }else{
            // 无负号默认正数
        }

        // 遍历运算所有数字 48-57
        while(true){
            if(c>=48 && c<=57){
                // 是数字,运算
                try {
                    if((count * 10)/10 != count)
                        throw new Exception();
                    count = Math.addExact(count * 10, (c-48) * sym);
                } catch (Exception e) {
                    // 溢出,返回最大最小值
                    if(sym == -1)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
            }else{
                // 非数字,返回count
                return count;
            }
            if(++i == len){
                // 最后一个,返回count
                return count;
            }
            c = s.charAt(i);
        }
    }

}






















