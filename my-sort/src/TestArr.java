import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuting
 * @date 2023/02/27
 */
public class TestArr {

    public static void main(String[] args) {
        int[][] arr = generateMatrix(5);
        System.out.println(Arrays.deepToString(arr));
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(spiralOrder(arr2));
    }

    public static int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resultList;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        //边界法：定上下左右四个边界，每处理一条边边界向着相反方向移动
        //直到有边界越界结束循环
        int up = 0, down = row - 1, left = 0, right = column - 1;
        int i, j = 0;
        while (true) {
            //上边界
            for (j = left; j <= right; j++) {
                resultList.add(matrix[up][j]);
            }
            //上边界下移
            if (++up > down) {
                break;
            }
            //右边界
            for (i = up; i <= down; i++) {
                resultList.add(matrix[i][right]);
            }
            //右边界左移
            if (--right < left) {
                break;
            }
            //下边界
            for (j = right; j >= left; j--) {
                resultList.add(matrix[down][j]);
            }
            //下边界上移
            if (--down < up) {
                break;
            }
            //左边界
            for (i = down; i >= up; i--) {
                resultList.add(matrix[i][left]);
            }
            //左边界右移
            if (++left > right) {
                break;
            }
        }
        return resultList;
    }

}
