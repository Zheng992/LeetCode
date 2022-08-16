package leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1759 👎 0

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] s ={1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(s,3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //法1-优先队列,使用堆存储滑动窗口最大值,时间复杂度为logn,整体nlogn
            /*PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] p1, int[] p2) {
                    //若两个值不等，则比较大小，若相等，则取下标大的
                    return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
                }
            });
            //1.先存入k个元素至堆中
            int length=nums.length;
            for(int i=0;i<k;i++){
                pq.offer(new int[]{nums[i],i});
            }
            //2.滑动窗口，保证堆内元素皆是滑动窗口内元素，并且堆顶元素就是滑动窗口最大值
            int [] res=new int[length-k+1];
            res[0]=pq.peek()[0];
            //2.1 从第k个元素开始滑动，每滑动一次取一个堆顶，保证堆顶元素在窗口内
            for(int i=k;i<length;i++){
                pq.offer(new int[]{nums[i],i});
                //保证堆内元素在滑动窗口内(根据下标判断)
                while(pq.peek()[1]<=i-k){
                    pq.poll();
                }
                res[i-k+1]=pq.peek()[0];
            }
            return res;*/

            //法2-单调队列,使用双端队列存储滑动窗口单调递减的数据下标,存取均为常数时间复杂度,因此总体时间复杂度为n
            /*Deque<Integer> stack=new ArrayDeque<>();
            int n=nums.length;
            for(int i=0;i<k;i++){
                while(!stack.isEmpty()&&nums[i]>nums[stack.getLast()]){
                    stack.removeLast();
                }
                stack.offerLast(i);
            }

            //开始滑动窗口
            int[] res=new int[n-k+1];
            res[0]=nums[stack.getFirst()];
            for(int i=k;i<n;i++){
                while(!stack.isEmpty()&&nums[i]>nums[stack.getLast()]){
                    stack.removeLast();
                }
                stack.offerLast(i);
                while(stack.getFirst()<=i-k){
                    stack.removeFirst();
                }
                res[i-k+1]=nums[stack.getFirst()];
            }
            return res;*/

            //法3-分块+预处理

            int n = nums.length;
            int[] prefixMax = new int[n];
            int[] suffixMax = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i % k == 0) {
                    prefixMax[i] = nums[i];
                }
                else {
                    prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
                }
            }
            for (int i = n - 1; i >= 0; --i) {
                if (i == n - 1 || (i + 1) % k == 0) {
                    suffixMax[i] = nums[i];
                } else {
                    suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
                }
            }

            int[] ans = new int[n - k + 1];
            for (int i = 0; i <= n - k; ++i) {
                ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}