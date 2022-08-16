package leetcode.editor.cn;

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
//
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 297 👎 0

public class QueShiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        //二分法
        int l=0;
        int r=nums.length-1;
        //执行循环
        while(l<=r){
            //mid取l+r的一半
            int mid=(l+r)>>1;
            //如果当前值等于下标,即当前值及往前均满足条件,缺失值在右边,往右边查找
            if(nums[mid]==mid){
                l=mid+1;
            }
            //若当前值已经不满足条件,说明缺失值交界处在左边,往左查找
            else{
                r=mid-1;
            }
        }
        //结束循环后,返回的应当是缺失值的左边的下标, 该下标+1即为缺失值
        return r+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}