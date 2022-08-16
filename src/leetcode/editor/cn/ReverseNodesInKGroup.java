package leetcode.editor.cn;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1730 👎 0

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.net.HttpRetryException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        solution.reverseKGroup(n1, 2);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //思路,切断子表,进行反转,再拼接
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyNode =new ListNode(-1);
            dummyNode.next=head;
            //定义反转子链表的上一个结点
            ListNode pre=dummyNode;
            while(head!=null){
                //定义反转子链表内的最后一个结点
                ListNode tail=pre;
                //查看剩余部分是否大于等于k
                for(int i=0;i<k;i++){
                    tail=tail.next;
                    if(tail==null){
                        return dummyNode.next;
                    }
                }
                //定义反转子链表的下一个结点
                ListNode next=tail.next;
                ListNode[] reverse=reverseSonList(head,tail);
                head=reverse[0];
                tail=reverse[1];
                //将子链表链接回原链表
                pre.next=head;
                //实际上在反转方法体内,已经链接了下一个结点
                //tail.next=next;
                pre=tail;
                head=tail.next;
            }
            return dummyNode.next;
        }

        public ListNode[] reverseSonList(ListNode head,ListNode tail) {
            //指向子表的下一个结点
            ListNode pre = tail.next;
            ListNode cur = head;

            //若两者相等,说明已经反转完毕,再下一步
            while (pre!=tail) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return new ListNode[]{tail, head};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}