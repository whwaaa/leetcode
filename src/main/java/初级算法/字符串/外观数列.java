package 初级算法.字符串;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/17
 * @Week: 星期五
 *
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
 *
 * TODO: 此题总结:
 * 处理遍历对象过程中,如果涉及到要根据后一个对象的值来处理当前对象时,
 * 优先考虑比较判断临时变量和(下一个遍历对象)的遍历比较方法, (temp==obj[i+1]),
 * 遍历结束对最后一个遍历对象统一处理
 */
public class 外观数列 {
    public static void main(String[] args) {
        int n = 10;
        String s = countAndSay(n);
        System.out.println(s);
        System.out.println("13211311123113112211");
    }


    // TODO: 2.判断临时变量和下一个是否相等
    // 按着题目意思, 循环计算
    // 取第一个字符存入临时变量,判断临时变量和当前是否相等,这里有两种情况:
    // 1.当前遍历不是最后一个: 112233
    //      index=0, 下一个值为1,临时变量是1,相等,计数自增,非倒数第二个循环往下判断倒数第二个结束
    //      index=1, 下一个值为2,临时变量是1,不相等,(取出临时变量计算),非倒数第二个循环往下判断倒数第二个结束
    // 2.当前遍历是最后一个:
    //      11 index=0 下一个值为1,临时变量是1,相等,计数自增,非倒数第二个循环往下判断倒数第二个结束 -> 未处理最后一个
    //      112 index=1 值为2,临时变量是1,不相等,(取出临时变量计算),非倒数第二个循环往下判断倒数第二个结束 -> 未处理最后一个
    // (可见,无论最后一个是否满足判断条件,最后都要统一做处理)
    //
    // 结论
    // 1.比较判断(当前)和临时变量,存在两种情况,非最后就能处理当前,当是最后一个时就跳出循环(当前得不到处理),所以要对最后一个做单独判断分析
    // 1.Attention -> (只用保证遍历对象非空,即长度>=1)
    // 2.比较判断(下一个)和临时变量,总会处理(当前),而最后一个总得不到处理,循环完毕之后(统一都处理最后)即可
    // 2.Attention -> (因为会取出(下一个), 所以在索引为0时,要保证下一个存在,即所遍历的对象长度必须>=2)
    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append('1');
        sb.append('1');
        char temp;
        int count;
        for(int i=2; i<n; i++){
            temp = sb.charAt(0);
            count = '1';
            for(int j=0; j<sb.length()-1; j++){
                if(temp == sb.charAt(j+1)){
                    count++;
                }else {
                    sb2.append((char)count);
                    sb2.append(temp);
                    count = '1';
                    temp = sb.charAt(j+1);
                }
            }
            sb2.append((char)count);
            sb2.append(temp);
            sb = sb2;
            sb2 = new StringBuilder();
        }
        return sb.toString();
    }

    // TODO: 1.判断临时变量和当前是否相等
    // 按着题目意思, 循环计算
    // 取第一个字符存入临时变量,判断临时变量和当前是否相等,这里有两种情况:
    // 1.当前遍历不是最后一个: 112233
    //      index=1, 值为1,临时变量是1,相等,计数自增,非最后一个循环往下判断最后一个结束
    //      index=2, 值为2,临时变量是1,不相等,计数自增,(取出临时变量计算),非最后一个循环往下判断最后一个结束
    // 2.当前遍历是最后一个:
    //      11 index=1 值为1,临时变量是1,相等,计数自增,非最后一个循环往下判断最后一个结束  -> 应该但未执行(取出临时变量计算)
    //      12 index=1 值为2,临时变量是1,不相等,计数自增,(取出临时变量计算),非最后一个循环往下判断最后一个结束
    // 问题在于情况1中最后计数自增后不用执行(取出临时变量计算),二情况2中最后计数自增后应该但未执行(取出临时变量计算),
    // (可见,要对最后一个字符单独判断,条件1不用计算处理,条件2要计算处理)
    public static String countAndSay2(int n) {
        if(n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append('1');
        char temp;
        int count;
        for(int i=1; i<n; i++){
            temp = sb.charAt(0);
            count = '1';
            for(int j=1; j<sb.length(); j++){
                if(temp == sb.charAt(j)){
                    count++;
                }else {
                    sb2.append((char)count);
                    sb2.append(temp);
                    count = '1';
                    temp = sb.charAt(j);
                }
            }
            if(temp == sb.charAt(sb.length()-1)){
                sb2.append((char)count);
                sb2.append(temp);
            }
            sb = sb2;
            sb2 = new StringBuilder();
        }
        return sb.toString();
    }

}



























