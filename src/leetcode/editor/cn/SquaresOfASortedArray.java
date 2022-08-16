package leetcode.editor.cn;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 596 👎 0

import java.util.Arrays;
import java.util.Collections;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            //1. 暴力
            int n = nums.length;
            /*for (int i = 0; i < n; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;*/

            //2. 双指针
            //找到正负分界线, 数组被分为左边负数/右边正数两部分
            // 左边平方后是递减,右边平方后是递增
            //因此可以定义左右双指针, 两个指针均往中间收, 谁大先放谁到新数组的最右(因为新数组要单调递增)
            //找到分界线, [0,split] 为负数, [split+1,n-1] 为正数
            int split=-1;
            for(int i=0;i<n;i++){
                if(nums[i]<0){
                    split=i;
                }else{
                    break;
                }
            }

            //定义数组,存放结果
            int[] res =new int[n];
            //结果数组的移动指针,从最右开始
            int k=n-1;

            //定义左右指针
            int l=0;
            int r= n-1;

            //左右指针往中间收,直到l>r即停止
            while(l<=r){
                //因为左边可能为负数,所以加绝对值
                //若右边大于左边,则先存右边,并且右指针往中间收
                if(Math.abs(nums[l])<nums[r]){
                    res[k--]=nums[r]*nums[r];
                    r--;
                }
                //反之,左边大于等于右边,则先存左边,并且左指针往中间收
                else{
                    res[k--]=nums[l]*nums[l];
                    l++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}