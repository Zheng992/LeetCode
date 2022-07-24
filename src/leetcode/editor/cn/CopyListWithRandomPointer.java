package leetcode.editor.cn;

//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。 
//
// 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。 
//
// 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random 
//--> y 。 
//
// 返回复制链表的头节点。 
//
// 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 你的代码 只 接受原链表的头节点 head 作为传入参数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 1000
// 
// -10⁴ <= Node.val <= 10⁴ 
// Node.random 为 null 或指向链表中的节点。 
// 
//
// Related Topics 哈希表 链表 👍 943 👎 0

import com.sun.org.apache.bcel.internal.generic.RETURN;
import sun.plugin2.util.ParameterNames;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.spi.CurrencyNameProvider;

public class CopyListWithRandomPointer{
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();

        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.next=n2;
        n2.next=n3;

        Node newNode=solution.copyRandomList(n1);
        System.out.println(newNode.val);
        System.out.println(newNode.next.val);
        System.out.println(newNode.next.next.val);
        System.out.println(newNode.next.next.next);
        System.out.println(n1.equals(newNode));
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
    //法1-用Map存储结点，利用回溯思想找到next与random结点
    //创建HashMap,用于存储原始结点与其复制结点
    /*Map<Node, Node> cachedNode= new HashMap<>();
    public Node copyRandomList(Node head) {
        //若传入结点为空,则返回空
        if(head==null){
            return null;
        }
        //判断当前结点是否已经存入哈希表,若已存入,直接取出来并返回即可
        if(!cachedNode.containsKey(head)){
            //复制当前结点
            Node headNew=new Node(head.val);
            //将当前结点与其复制结点存入Map中
            cachedNode.put(head,headNew);
            //复制当前结点的next与random信息,利用回溯,判断他们是否存在,若不存在,则创建,若存在,则会返回内存地址
            headNew.next=copyRandomList(head.next);
            headNew.random=copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }*/

    //法2-在每个原始结点后继添加其复制结点，复制完再重头遍历，将复制结点链接起来
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