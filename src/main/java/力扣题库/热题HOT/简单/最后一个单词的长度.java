package 力扣题库.热题HOT.简单;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/18
 * @Week: 星期六
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 *
 */
public class 最后一个单词的长度 {
    public static void main(String[] args) {
        String s = " r ";
        int i = lengthOfLastWord(s);
        System.out.println(i);

        System.out.println("----"+((int)s.charAt(s.length()-1)==(int)' ')+"----");
    }


    // 可优化为只判断是否等于' ' 免掉判断字母
    public static int lengthOfLastWord(String s) {
        int count = 1;
        for(int i=s.length()-1; i>=0; i--){
            int temp = s.charAt(i);
            if((temp>='A' && temp<='Z') || (temp>='a' && temp<='z')){
                for(int j=i-1; j>=0; j--){
                    if(s.charAt(j) == ' '){
                        return count;
                    }
                    count++;
                }
                return count;
            }
        }
        return 1;
    }
}














