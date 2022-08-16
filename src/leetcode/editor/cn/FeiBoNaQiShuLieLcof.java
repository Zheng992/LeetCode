package leetcode.editor.cn;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 398 👎 0

import java.util.ArrayList;
import java.util.HashMap;

public class FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] res;
    final int m = 1000000007;

    /*    public int fib(int n) {
            //记忆化递归法，将算过的斐波那契存起来，再次使用直接调用即可
            res=new int[n+1];
            return getN(n);
        }

        public int getN(int n){
            if (n==0){
                res[n]=0;
                return res[n];
            }else if(n==1){
                res[n]=1;
                return res[n];
            }
            if(res[n]!=0){
                return res[n];
            }else{
                res[n]=(getN(n-1)+getN(n-2))%m;
            }
            return res[n];
        }
    }*/
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i < n+1; i++) {
            sum = (a + b) % m;
            a = b;
            b = sum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}