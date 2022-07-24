package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3403 👎 0

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String s="{[]}";
        boolean res= solution.isValid(s);
        System.out.println(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //法1-栈+ASCII码
    /*public boolean isValid(String s) {
        byte[] data=s.getBytes();
        Stack<Byte> stack=new Stack<>();
        for(int i=0;i<data.length;i++){
            if(stack.isEmpty()){
                stack.push(data[i]);
            }else{
                //因为输入仅有()[]{},根据ASCII的特点, 同一对符号相差不超过2 ,
                //若两者要消除,必须左括号先进,右括号后进
                if(stack.peek()!=data[i] && stack.peek()<data[i] && Math.abs(stack.peek()-data[i])<3){
                    stack.pop();
                    continue;
                }else{
                    stack.push(data[i]);
                }
            }
        }
        return stack.isEmpty();
    }*/

    //法2-栈+哈希表
    public boolean isValid(String s) {
        int n=s.length();
        //奇数个符号,必无法完全消除
        if(n%2==1){
           return false;
        }
        //创建哈希表,key为右符号,value为左符号
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        //创建栈
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                //若栈为空,放入右符号,必为false; 若栈顶符号与放入符号不配对,必为false
                if(stack.isEmpty()|| !stack.peek().equals(map.get(c))){
                    return false;
                }else{
                    //否则,弹出,即配对.
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}