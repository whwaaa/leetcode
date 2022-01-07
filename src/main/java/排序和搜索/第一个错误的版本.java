package 排序和搜索;

/**
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnto1s/
 *
 * TODO: 此题总结:
 * 取中间值用如下计算方式防止溢出: mid = start + (end - start) / 2
 * 而用如下方式可能会溢出: mid = (start + end) / 2
 */
public class 第一个错误的版本 {

    private static int bad; // 索引
    public static boolean isBadVersion(int n){
        if(n < bad)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int n = 2126753390;
        bad = 1702766719;



        int res = firstBadVersion(n);
        System.out.println(res);

    }

    public static int firstBadVersion(int n) {
        if(n == 1)
            return n;
        long tVer = 0;
        long fVer = n;
        while(true){
            System.out.println("tVer:" + tVer + "    fVer:" + fVer);
            if((tVer+fVer)/2 == tVer)
                // 第一个错误版本是最后一个 (4+5)/2=4
                return (int)fVer;
            if(isBadVersion((int)((tVer+fVer)/2))) {
                if(!isBadVersion((int)((tVer+fVer)/2)-1))
                    // 上一个是正确版本即找到第一个错误版本fVer
                    return (int)((tVer+fVer)/2);
                fVer = (tVer + fVer) / 2;
            }else{
                tVer = (tVer + fVer) / 2;
            }
        }
    }
}
