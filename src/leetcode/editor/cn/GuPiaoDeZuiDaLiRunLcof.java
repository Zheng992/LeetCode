package leetcode.editor.cn;

//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/ 
//
// Related Topics 数组 动态规划 👍 279 👎 0

public class GuPiaoDeZuiDaLiRunLcof{
    public static void main(String[] args) {
        Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public int maxProfit(int[] prices) {
        //法1-用数组存储答案与辅助迭代, 空间复杂度On
        if(prices.length == 0){
            return 0;
        }
        //确定本题状态转移方程, 当前日的获利为 max(上一日获利, 当前价格-最低价格)
        int n=prices.length;
        int[] dp=new int[n];
        dp[0]=0;

        int cost=Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            //确定历史最低价格
            cost= Math.min(cost,prices[i-1]);
            //获取当前最大收益
            dp[i]=Math.max(dp[i-1],prices[i]-cost);
        }

        //返回数组最后一个, 因为最大收益一定也会保存在最后一个位置
        return dp[n-1];
    }*/

    //法2-利用两个辅助变量  实现空间复杂度O1的DP
    public int maxProfit(int[] prices) {
        int cost=Integer.MAX_VALUE,profit=0;

        for(int price:prices){
            cost=Math.min(cost,price);
            profit= Math.max(profit,price-cost);

        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}