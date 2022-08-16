package leetcode.editor.cn;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 319 👎 0

public class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        //列出初始条件
        if(n==0||n==1){
            return 1;
        }else if (n==2){
            return 2;
        }

        //这题的重点在于确定状态转移方程,即当前阶级的方式等于前一个与前两个方式之和, fn= f(n-1)  + f(n-2) .
        int sum=0;
        int a=1;
        int b=2;
        //从3开始算,因为0-2前面判断过了,计算到第n阶
        for(int i=3;i<n+1;i++){
            //fn= f(n-1)  + f(n-2)
            sum=(a+b)%1000000007;
            //f(n-2) -> n-1    f(n-1) -> f(n)
            a=b;
            b=sum;
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}