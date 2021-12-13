package 初级算法.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 字符串中的第一个唯一字符
 * @Auther: whw
 * @Date: 2021/12/13
 * @Week: 星期一
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 */
public class 字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        String str = "abcejfjdlsajggl;dsjafkljdskla;gjgldksajflkdahsgkl;djslk;afjkldashglkdsajfldkshakl;gjld;sajfkldffga";
        int res = 0;
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        for(int i=0; i<999; i++){

            res = firstUniqChar(str);

        }
        end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("总用时: " + (end-start) + "ms");
    }


    // 与重复相关, 可利用Hash数据结构, 这里用HashMap, 遍历两遍
    // 1.遍历第一遍把字符以及对应出现的次数存入map 巧用 map.getOrDefault(), 返回key对应的值, 若不存在返回自定义值
    // 2.再次遍历字符查询出现次数, 第一次次数为1的即为答案
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0; i<len; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0; i<len; i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    // 与重复相关, 可利用Hash数据结构, 这里用HashSet
    // 1.先存入set1找出重复数据
    // 2.所有重复数据存入set2
    // 3.再次遍历,存入set2找出第一个不重复的字符返回
    public static int firstUniqChar2(String s) {
        int len = s.length();

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(Integer i=0; i<len; i++){
            if(!set1.add(s.charAt(i))){
                set2.add(s.charAt(i));
            }
        }
        for(int i=0; i<len; i++){
            if(set2.add(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
