package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics 栈 递归 数学 字符串 👍 796 👎 0

import javax.lang.model.element.NestingKind;
import java.util.*;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        String s = "1+1";
        solution.calculate(s);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            //思想是将括号击穿,根据括号前的符号判断括号内符号是否需要取反,按顺序计算过去
            //建立一个栈,存放括号前符号
            Deque<Integer> stack =new ArrayDeque<>();
            // res为最终结果,num为当前数字(用于拼接),ope是默认符号+
            int res=0,sign=1;
            stack.push(1);
            int i=0;
            while(i<s.length()){
                char c=s.charAt(i);
                if(c==' '){
                    i++;
                    continue;
                }else if(c=='+'){
                    sign=stack.peek();
                    i++;
                }else if(c=='-'){
                    sign=-stack.peek();
                    i++;
                }else if(c=='('){
                    stack.push(sign);
                    i++;
                }else if(c==')'){
                    stack.pop();
                    i++;
                }else{
                    long num =0;
                    while(i<s.length()&&Character.isDigit(s.charAt(i))){
                        num = num*10+s.charAt(i)-'0';
                        i++;
                    }
                    res+=sign*num;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}