package leetcode.editor.cn;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 761 👎 0

public class ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断矩阵是否为空,若空则返回false
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        //获取矩阵的行与列数
        int n=matrix.length-1;
        int m=matrix[0].length-1;
        //从矩阵的右上角开始查找,若target大于当前值,则i++,因为往下递增,往左是一定更小的
        //若target小于当前值,则j--,往左查找,因为左小右大,往左才有机会找得到
        int i=0;
        int j=m;
        //从右上角找到右下角, 下标不能超过右下角
        while(j>=0 && i<=n){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}