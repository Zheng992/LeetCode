package leetcode.editor.cn;

//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
//
// 注意，一开始你手头没有任何零钱。 
//
// 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：bills = [5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
// 
//
// 示例 2： 
//
// 
//输入：bills = [5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bills.length <= 10⁵ 
// bills[i] 不是 5 就是 10 或是 20 
// 
//
// Related Topics 贪心 数组 👍 360 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LemonadeChange{
    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        int[] bills=new int[]{5,5,10,10,20};
        solution.lemonadeChange(bills);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        //贪心算法，5块不用找钱， 直接收入囊中
        //10块必须用5块找钱,若袋中没有5块,则false
        //20块优先用10+5找钱,其次用5+5+5   因为10仅能用在20的找钱上, 5能用在10和20,5更宝贵.
        //定义两个辅助变量,统计口袋中5和10的零钱数量
        int f=0;
        int t=0;

        //遍历bills
        for (int bill : bills) {
            //当前单价为5,直接收入囊中
            if (bill == 5) {
                f++;
            } else if (bill == 10 && f > 0) {
                //若为10,且有5块散钱,给你5块,收入10块
                f--;
                t++;
            } else if (bill == 20) {
                //若此时账单为20块
                //有10块和5块,直接找给你
                if (t > 0 && f > 0) {
                    t--;
                    f--;
                } else if (f >= 3) {
                    //若有3张5块,也找给你
                    f -= 3;
                } else {
                    //走到这一步,代表我两种方案都没有,所以找不出来
                    return false;
                }
            } else {
                //走到这,代表无法找出钱来
                return false;
            }
        }
        //走到这,代表整个bills遍历完成,没有出现找不出钱的情况.
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}