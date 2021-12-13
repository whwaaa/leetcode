package 力扣题库.热题HOT;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/13
 * @Week: 星期一
 *
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class 实现strStr {

    public static void main(String[] args) {
//        String haystack = "hggfdshllfgdsfdsaefdshfdsllsafgo";
//        String needle = "ll";
        String haystack = "mississippi";
        String needle = "issip";

        int res = 0;
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        for(int i=0; i<999999; i++){

            res = strStr(haystack, needle);

        }
        end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("总用时: " + (end-start) + "ms");
    }



    // 1.遍历找出第一个相同的字符
    // 2.再遍历后续的字符是否都相等
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(haystack.length() == 0 || needle.length() > haystack.length())
            return -1;
        int hlen = haystack.length();
        int nlen = needle.length();
        boolean flag;
        for(int i=0; i<hlen; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                flag = true;
                for(int j=1; j<nlen; j++){
                    if(j+i >= hlen)
                        return -1;
                    if(haystack.charAt(j+i) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    return i;
            }
        }
        return -1;
    }
}
