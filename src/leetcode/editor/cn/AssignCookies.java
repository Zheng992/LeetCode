package leetcode.editor.cn;

//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[
//i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 10⁴ 
// 0 <= s.length <= 3 * 10⁴ 
// 1 <= g[i], s[j] <= 2³¹ - 1 
// 
//
// Related Topics 贪心 数组 排序 👍 553 👎 0

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            //1.对两个数组进行排序, 因为我们要尽可能满足多的孩子,所以从大的开始满足
            //如果小孩吃大饼,会造成大孩不够吃,
            //如果大孩吃小饼,也不够吃,
            //所以先从大的还是吃,大孩吃大饼,小孩吃小饼
            Arrays.sort(g);
            Arrays.sort(s);

            //2. 获取孩子和糖果的下标，从大往小走
            int gl = g.length - 1;
            int sl = s.length - 1;

            int res = 0;

            //3.当孩子还有并且饼也有的时候,循环执行
            while (gl >= 0 && sl >= 0) {
                //若饼大于需求,则吃,然后饼少一个
                if (s[sl] >= g[gl]) {
                    res++;
                    sl--;
                }
                //无论这个孩子吃不吃得上,我们都要过掉他.
                //因为当下的饼满足不了它,后面的更满足不了(饼由大到小)
                //如果满足了,那就释放出来,继续往小的走.
                gl--;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}