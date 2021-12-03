package 初级算法.数组;//图解: 3X3 !{image-20211203155241599}(https://gitee.com/hanweiwu/tuchuang/raw/master/img/202112031554098.png)
//     4X4 ![image-20211203161215045](https://gitee.com/hanweiwu/tuchuang/raw/master/img/202112031612155.png)

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 初级算法.数组.旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 */
public class 旋转图像 {

    // 每一层循环旋转四个元素的坐标:
    public static void main2(String[] args) {
        int h=1,l=1,n=1;
        System.out.println("起始坐标:("+h+","+l+") (内圈长度-1)n=1");
        System.out.println("左上角(" + h + "," + l + ")      右上角(" + l + "," + (n+h) + ")");
        System.out.println("左下角(" + (h+n-l+h) + "," + h + ")      右下角(" + (h+n) + "," + (n+h-l+h) + ")");

    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        // 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        rotate(matrix);
    }

    /**
     * 图像每一层元素旋转一圈即可
     * 1.图像需要旋转的层数
     * 2.一层中循环旋转的次数
     * 3.确定每一层循环旋转四个元素的坐标(难点)
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length-1;
        int h = 0;  // 起始行
        int l = 0;  // 起始列
        int temp;
        for(; h<matrix.length/2; h++){   // 外圈循环
            for(l=h; l<h+n; l++){
                temp = matrix[h][l];
                matrix[h][l] = matrix[h+n-l+h][h];
                matrix[h+n-l+h][h] = matrix[h+n][n+h-l+h];
                matrix[h+n][n+h-l+h] = matrix[l][n+h];
                matrix[l][n+h] = temp;
            }
            n-=2;
        }

    }

    
}
