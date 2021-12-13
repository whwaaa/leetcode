import java.util.*;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/13
 * @Week: 星期一
 */
public class test {

    public static void main(String[] args) {
        String str = "abcejkldffga";
        char[] ch = str.toCharArray();
        int len = ch.length;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(Integer i=0; i<len; i++){
            if(map.put(ch[i], i) != null){
                set.add(ch[i]);
            }
        }

        for(int i=0; i<len; i++){
            if(set.add(ch[i])){
                System.out.println(i);
                break;
            }
        }


    }

}
