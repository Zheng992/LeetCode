package leetcode.editor.cn;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1345 👎 0

import java.util.HashMap;
import java.util.LinkedList;

public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        
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
    /*//穿针引线-双指针(四指针)-子表反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        //定义虚拟节点，以防head发生变动
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;

        //第一步,pre从0开始,走Left-1步,到达left的上一个结点
        ListNode pre=dummyNode;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }

        //第二步,left为pre.next,同时定义rightNode,准备开始走right
        ListNode leftNode=pre.next;
        ListNode rightNode=pre;


        //第三步,获取right, left-1开始走,到right(<right是因为里面会执行next,next后即为right)
        for(int i=left-1;i<right;i++){
            rightNode=rightNode.next;
        }

        //第四步,获取suc,right的下一个结点
        ListNode suc=rightNode.next;

        //切断链接,获取L-R的子链表
        pre.next=null;
        rightNode.next=null;

        //对L-R子链表执行反转,方法参考206
        reverseLinkedList(leftNode);

        //利用之前的哨兵结点,接上两条链表
        pre.next=rightNode;
        leftNode.next=suc;

        return dummyNode.next;
    }

    public void reverseLinkedList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;

        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
    }*/

    //法2-穿针引线-头插法
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;

        ListNode pre=dummyNode;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }

        ListNode cur=pre.next;

        //cur当前位置是left，只需要走到right的上一个即可
        for(int i=left;i<right;i++){
            //获取cur的下一个结点,cur是全程不变,一直在变的是next,将next差到pre前,
            ListNode next=cur.next;
            cur.next=next.next;
            //注意这里不能用next.next=cur,因为cur一直在移动,next需要插入的是pre.next
            next.next=pre.next;
            pre.next=next;
        }

        return dummyNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}