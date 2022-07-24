package leetcode.editor.cn;

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1233 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //法1-一次扫描,设定最小值步数
    /*public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        int counts=0;

        //逆序检查温度
        for(int i=n-1;i>=0;i--){
            boolean count=false;
            int j;
            //对每个存入温度,往后查找比他温度高的值,并计算步数
            for(j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    count=true;
                    break;
                }
            }
            //若找到,则存入步数
            if (count){
                res[i]=(j-i);
            }else{
                //若没有找到,则存入0
                res[i]=0;
            }
        }
        return res;
    }*/

        //法2-单调栈,存放单调数据,若有不符合单调的数据,弹出里面的数据,直到单调
        public int[] dailyTemperatures(int[] temperatures) {
            //定义一个单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            int n = temperatures.length;
            int[] res = new int[n];
            //遍历温度
            for (int i = 0; i < n; i++) {
                int temperature = temperatures[i];
                //若栈不为空,且当前温度大于栈顶温度,说明当前温度是栈顶温度的升温日
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    int preIndex = stack.pop();
                    //将栈顶弹出,并将升温步长赋值给弹出的元素(下标)
                    res[preIndex] = i - preIndex;
                }
                //将当日温度存入栈
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}