package leetcode.editor.cn;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
//
// Related Topics 数组 分治 动态规划 👍 586 👎 0

public class LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // dp列表法
        /*int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int max=nums[0];

        for(int i=1;i<n;i++){
            dp[i]= dp[i-1]>0? dp[i-1]+nums[i]:nums[i];
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;*/

        //O1空间法
        int max=nums[0];
        int former=0;  //dp[i-1]
        int cur=nums[0]; //dp[i]

        for(int num:nums){
            //dp[i]= dp[i-1]>0? dp[i-1]+nums[i]:nums[i];
            //先将当前值取来,若former大于0,则加进去
            cur=num;
            if(former>0){
                cur+=former;
            }
            //若当前dp值大于历史最大,则更新
            if(cur>max){
                max=cur;
            }
            //状态转移
            former=cur;
        }
        //返回最大
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}