package leetcode.editor.cn;

//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 663 👎 0

import javax.print.DocFlavor;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        int[] nums = {4, 5};
        int[] res = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            //定义一个单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n];
            //res默认值为-1
            Arrays.fill(res,-1);
            //扩展数组长度2倍,实现一次循环(对于本题,一次循环就够了),用i%n实现循环获取下标
            for (int i = 0; i < n*2-1; i++) {
                int val = nums[i%n];
                while (!stack.isEmpty() && val > nums[stack.peek()]) {
                    res[stack.pop()] = val;
                }
                stack.push(i % n);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}