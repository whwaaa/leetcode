package 初级算法.字符串;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/15
 * @Week: 星期三
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 */
public class 验证回文串 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "";
                            //      x
        boolean res = isPalindrome(s2);
        System.out.println(res);

    }

    /**
     * 0-9      A-Z        a-z
     * 48-57    65-90      97-122  32   48+32=80
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // 考虑s.length() == 0, == 1
        if(s.length() == 0 || s.length() == 1)
            return true;
        int l = -1;
        int r = s.length();
        int lc = 0;
        int rc = 0;
        while(true){
            do{
                l++;
                if(l >= r)
                    return true;
                lc = s.charAt(l);
            } while(lc<48 || (lc>57 && lc<65) || (lc>90 && lc<97) || lc>122);
            do{
                r--;
                if(l >= r)
                    return true;
                rc = s.charAt(r);
            } while(rc<48 || (rc>57 && rc<65) || (rc>90 && rc<97) || rc>122);
            if(lc > 64 && rc > 64){  // 都是字母
                int abs = Math.abs(lc - rc);
                if(abs != 0 && abs != 32){
                    // 不相等,不是回文串
                    return false;
                }
            }else{  // 存在数字
                if(lc != rc){
                    // 不相等,不是回文串
                    return false;
                }
            }
        }
    }

    // 使用正则匹配，把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，最后在判断是否相等。
    public boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
