package leetcode.editor.cn;

//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 1681 👎 0

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //法1-哈希表
    /*public ListNode detectCycle(ListNode head) {
        //定义移动结点
        ListNode cur=head;
        //定义hashSet，用于查询是否有重复结点
        HashSet<ListNode> map= new HashSet<>();

        while(cur!=null){
            //若有重复结点,则直接返回该节点
            if(map.contains(cur)){
                return cur;
            }else{
                //若无重复,则将该结点添加进map,并遍历
                map.add(cur);
                cur=cur.next;
            }
        }
        //走到这里说明没有重复结点,返回null
        return null;
    }*/

    //法2-双指针-快慢指针
    public ListNode detectCycle(ListNode head) {
        //定义快慢指针,slow走一步,fast走两步
        ListNode slow=head;
        ListNode fast=head;

        //开始迭代,当fast==slow时,则需退出循环
        do {
            //若fast不为空,或fast.next不为空,继续走,
            //fast.next不为空,fast.next.next可能为空,但是可以赋值.下一步回来就是fast为空
            if(fast==null||fast.next==null){
                return null;
            }else{
                fast=fast.next.next;
                slow=slow.next;
            }
        }
        while(fast!=slow);

        //将fast移回head结点,与slow同样再走a步,直到两者相遇,此时一定在环部分头结点相遇.
        fast=head;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}