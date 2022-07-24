package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2538 👎 0

public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        l1.next=l2;
        l2.next=l3;

        ListNode bl1=new ListNode(1);
        ListNode bl2=new ListNode(3);
        ListNode bl3=new ListNode(4);
        bl1.next=bl2;
        bl2.next=bl3;

        solution.mergeTwoLists(l1,bl1);


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
/*    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //获取两个链表头结点(似乎是多余的,因为我们不需要再取l1和l2了)
        ListNode curA=list1;
        ListNode curB=list2;

        //定义新链表的头结点和迭代结点,将头节点定义为-1,则能调用next进行赋值,若为空,则无法调用next
        ListNode head=new ListNode(-1);
        ListNode newCur;
        newCur=head;

        while(curA!=null&&curB!=null){
            if(curA.val>curB.val){
                newCur.next=curB;
                curB=curB.next;
            }else{
                newCur.next=curA;
                curA=curA.next;
            }
            newCur =newCur.next;
        }

        //到这里,至多只有一个链表非空,将该链表剩余结点都链接到新链表.
        *//*while(curB!=null){
            newCur.next=curB;
            curB=curB.next;
            newCur=newCur.next;
        }
        while(curA!=null){
            newCur.next=curA;
            curA=curA.next;
            newCur=newCur.next;
        }*//*

        //实际上,对于非空部分,只需要改变非空的头结点即可,因为非空多个结点的关系不需要改变.
        //即两个断开的片段,我们只需要将他们的头尾相连即可,不需要每个结点都断开重接.
        newCur.next=curA!=null?curA:curB;

        //因为头节点是-1,将头节点的下一个结点作为头节点返回
        return head.next;

    }*/

    //递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //若l1/l2为空,则返回对方结点
        if(l1==null){
            return l2;
        } else if(l2==null){
            return l1;
        }
        //若l1大于l2, 取l2为当前结点,并将l2指向 l1和l2.next 小的那个,然后返回l2
        else if(l1.val>l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        } else{
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}