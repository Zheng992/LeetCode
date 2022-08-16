package leetcode.editor.cn;

//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 856 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        int[] nums=new int[] {5,2,6,1};
        solution.countSmaller(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 辅助数组
        int[] temp;
        // 计数数组
        int[] result;
        // 索引数组
        int[] indexes;

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;

            List<Integer> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            temp = new int[n];
            result = new int[n];

            //索引数组，用于查找原始数组值，实际进行排序的是索引数组。
            indexes = new int[n];
            for (int i = 0; i < n; i++) {
                indexes[i] = i;
            }

            mergeSort(nums, 0, n - 1);

            //将int[] 转换为list 输出
            for (int i = 0; i < n; i++) {
                res.add(result[i]);
            }

            return res;
        }

        public void mergeSort(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = (l + r) >> 1;

            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);

        }

        public void merge(int[] nums, int l, int mid, int r) {
            for (int i = l; i <= r; i++) {
                //1.此处与归并排序有区别, 辅助数组初始化,存放的是索引
                temp[i] = indexes[i];
            }

            int i = l;
            int j = mid + 1;

            for(int k=l;k<=r;k++){

                if(i>mid){
                    // 左边元素用尽,取右边元素
                    indexes[k]=temp[j++];
                }else if(j>r){
                    // 右边元素用尽,取左边元素
                    indexes[k]=temp[i++];
                    //2.此处统计逆序对计数
                    // indexes[k]可以和右边[mid + 1, right]构成逆序对，长度为right - (mid + 1) + 1，即right - mid
                    //若j超出边界,则证明右边已经全部排完了,而左边没有,故右边的总长即为当前i下逆序对的总数量
                    result[indexes[k]]+=(r-mid);
                }else if(nums[temp[i]]>nums[temp[j]]){
                    //3. 此处与归并排序不同,索引是辅助数组temp
                    //取最小的,即右边元素
                    indexes[k]=temp[j++];
                }else{
                    indexes[k]=temp[i++];
                    // indexes[k]可以和右边[mid + 1, j)构成逆序对，长度为j - (mid + 1)，即j - mid - 1
                    // 右边未超出边界,则总长为当前j-(mid+1)
                    result[indexes[k]]+=(j-mid-1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}