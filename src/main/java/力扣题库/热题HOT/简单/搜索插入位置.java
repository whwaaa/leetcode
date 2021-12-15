package 力扣题库.热题HOT.简单;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/14
 * @Week: 星期二
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
//        int[] nums = {1,3,5,6};
        int[] nums = {1,3,5,6};
        int target = 1;
        int res = 0;
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        for(int i=0; i<1; i++){

            res = searchInsert(nums, target);

        }
        end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("总用时: " + (end-start) + "ms");
    }


    // 这题很简单啊
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(nums[i] >= target)
                return i;
        }
        return len;
    }
}















