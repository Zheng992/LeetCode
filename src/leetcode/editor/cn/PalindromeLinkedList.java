package leetcode.editor.cn;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1455 👎 0

import java.util.HashMap;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);

        n1.next=n2;
        n2.next=n3;
        recursion(n1);

    }

    public static ListNode recursion(ListNode head){
        if(head.next==null){
            return head;
        }
        head = recursion(head.next);
        System.out.println(head.val);

        return head;
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
        //法1-对半反转,逐个比较
        // 思路,先获取链表长度,然后折半,后半部分反转.
        // 然后两个头指针同步推进,逐个比较,直至空或不等
        public boolean isPalindrome(ListNode head) {
            if (head==null){
                return true;
            }

            //1. 获取第一部分尾结点和第二部分头结点
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStar = reverseList(firstHalfEnd.next);

            //2.比较是否回文
            ListNode p1=head;
            ListNode p2=secondHalfStar;
            boolean res=true;
            while(res && p2!=null){
                if(p1.val!=p2.val){
                    res = false;
                }else{
                    p1=p1.next;
                    p2=p2.next;
                }
            }
            firstHalfEnd.next=reverseList(secondHalfStar);
            return res;
        }

        public ListNode endOfFirstHalf(ListNode head){
            ListNode slow= head;
            ListNode fast =head;
            while(fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head){
            ListNode pre=null;
            ListNode cur=head;
            while(cur!=null){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}