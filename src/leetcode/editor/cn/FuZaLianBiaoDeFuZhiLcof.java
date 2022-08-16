package leetcode.editor.cn;

//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/ 
//
// 
//
// Related Topics 哈希表 链表 👍 573 👎 0

public class FuZaLianBiaoDeFuZhiLcof{
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        Node dummyNode =new Node(-1);
        dummyNode.next=head;
        //复制结点，并接入原始链表
        for(Node cur=head;cur!=null;cur=cur.next.next){
            Node newNode=new Node(cur.val);
            newNode.next=cur.next;
            cur.next=newNode;
        }
        //指向随机结点
        for(Node cur=head;cur!=null;cur=cur.next.next){
            //获取原始节点的下一个结点（复制结点）
            Node newNode=cur.next;
            //复制结点的随机指针指向对应原始结点随机指针的复制点(next)
            //random可能为空，故需要做一个判断，避免空指针异常
            newNode.random=cur.random!=null?cur.random.next:null;
        }
        //将复制点串起来
        //cur指向原始结点, 定义copyNode指向复制结点
        Node copyDummyNode=head.next;
        for(Node cur=head;cur!=null;cur=cur.next){
            Node copyNode=cur.next;
            cur.next=cur.next.next;
            copyNode.next=copyNode.next!=null?copyNode.next.next:null;
        }
        return copyDummyNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}