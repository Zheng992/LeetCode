package leetcode.editor.cn;

//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 321 👎 0

public class LiWuDeZuiDaJieZhiLcof{
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid) {
        // dp辅助
/*        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }else if(i == 0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }else if(j == 0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];*/

        //原地修改
        int m=grid.length,n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (i==0&&j==0){
                    continue;
                }else if(i == 0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }else if(j == 0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }else{
                    grid[i][j]= Math.max(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}