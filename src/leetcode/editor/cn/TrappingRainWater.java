package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3633 👎 0

import org.jcp.xml.dsig.internal.SignerOutputStream;
import sun.java2d.HeadlessGraphicsEnvironment;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        solution.trap(height);

        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.单调栈
    /*public int trap(int[] height) {
        //建立一个单调栈,用于寻找下一个等于大于值
        Deque<Integer> stack = new ArrayDeque<>();
        //建立一个数组,存放下一个大于等于值的下标
        int length=height.length;
        //总水量
        int waterSum=0;

        //遍历高度,获取每个元素的下个等于大于值
        for(int i=0;i<length;i++){
            int val=height[i];
            while(!stack.isEmpty()&&val>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                waterSum+=(i-left-1)*(Math.min(height[left],height[i])-height[top]);
            }
            stack.push(i);
        }
        System.out.println(waterSum);
        //返回水量
        return waterSum;
    }*/

    //2.双指针
    public int trap(int[] height) {
    int waterSum=0;
    int left=0,right= height.length-1;
    int leftMax=0,rightMax=0;
    while(left<right){
        leftMax=Math.max(height[left],leftMax);
        rightMax=Math.max(height[right],rightMax);
        if(height[left]<height[right]){
            waterSum+=leftMax-height[left];
            ++left;
        }else{
            waterSum+=rightMax-height[right];
            --right;
        }
    }
    return waterSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}