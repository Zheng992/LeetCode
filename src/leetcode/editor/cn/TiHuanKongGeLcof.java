package leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 330 👎 0

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        //将String每一个字符存放到char数组中
        char[] list=s.toCharArray();
        //创建一个StringBuilder 用于拼接字符串
        StringBuilder res= new StringBuilder();
        for(char b:list){
            // 若当前字符==' ' 或 ==32,则替换为%20
            if(b==32){
                res.append("%20");
            }
            // 反之,将当前字符添加到res中
            else {
                res.append(b);
            }
        }
        // 将StringBuilder转为String并返回
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}