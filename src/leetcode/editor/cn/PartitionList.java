package leetcode.editor.cn;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 👍 594 👎 0


public class PartitionList{
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        //若该链表头节点为空,直接返回
        if(head==null){
            return null;
        }

        //思想,定义两个新链表,分别存放小于x的和大于等于x的结点,然后再将小链表的尾巴接大链表的头
        //定义两个哨兵,分别为小链表和大链表
        //定义两个移动指针
        //因为不用返回原始链表,所以用head做原始链表的移动指针
        ListNode lowerStar=new ListNode(-1);
        ListNode upperStar=new ListNode(-1);
        ListNode lowerCur=lowerStar;
        ListNode upperCur=upperStar;

        //若head不为空,继续迭代
        while(head!=null){
            //若head.val小于x,则接入小链表,反之,接入大链表
            if(head.val<x){
                lowerCur.next=head;
                lowerCur=lowerCur.next;
            }else{
                upperCur.next=head;
                upperCur=upperCur.next;
            }
            head=head.next;
        }

        //因为该节点在原链表中可能指向其他小结点,故需要切断他们联系,避免环路
        upperCur.next=null;
        //将两个链表相连
        lowerCur.next=upperStar.next;
        //返回链表头结点
        return lowerStar.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}