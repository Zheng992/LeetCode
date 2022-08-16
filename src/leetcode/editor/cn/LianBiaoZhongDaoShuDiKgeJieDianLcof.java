package leetcode.editor.cn;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
//
// Related Topics 链表 双指针 👍 380 👎 0

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        //n3.next=n4;
        //n4.next=n5;
        solution.getKthFromEnd(n1,2);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //1.法1-两次遍历
        /*public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode cur = head;
            ListNode checkLength = head;

            int length = 1;
            while (checkLength != null && checkLength.next!=null) {
                checkLength = checkLength.next;
                ++length;
            }

            for(int i=1;i<length-k+1;i++){
                cur=cur.next;
            }

            return cur;
        }*/

        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast=head;
            ListNode slow=head;

            while(fast!=null&k>0){
                fast=fast.next;
                k--;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}