package leetcode.editor.cn;

//设计实现双端队列。 
//
// 实现 MyCircularDeque 类: 
//
// 
// MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。 
// boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。 
// boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。 
// boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。 
// boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。 
// int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。 
// int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。 
// boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。 
// boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//输出
//[null, true, true, true, false, 2, true, true, true, 4]
//
//解释
//MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
// isFull 调用次数不大于 2000 次 
// 
//
// Related Topics 设计 队列 数组 链表 👍 122 👎 0

import javax.swing.text.rtf.RTFEditorKit;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class DesignCircularDeque {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {
        //本题循环的意思是,循环利用空间,在有限空间内合理做到多次压入弹出
        //法1-用链表实现
    /*List<Integer> deque;
    int maxSize;
    int curSize=-1;
    public MyCircularDeque(int k) {
        deque =new LinkedList<>();
        maxSize=k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        deque.add(0,value);
        curSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        deque.add(++curSize,value);
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        deque.remove(0);
        curSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        deque.remove(curSize);
        curSize--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque.get(0);
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return deque.get(curSize);
    }
    
    public boolean isEmpty() {
        return curSize==-1;
    }
    
    public boolean isFull() {
        return curSize==maxSize-1;
    }*/

        //法2-数组
        int maxSize;
        int front;
        int rear;
        int[] deque;

        public MyCircularDeque(int k) {
            //创建的数组要比容量多一个,因为要留一个空位,来完成空和满的判断(以防两者冲突)
            maxSize = k + 1;
            deque = new int[maxSize];
            front = 0;
            rear = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                front=(front-1+maxSize)%maxSize;
                deque[front] = value;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                deque[rear] = value;
                rear=(rear+1)%maxSize;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                front=(front+1+maxSize)%maxSize;;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                rear=(rear-1+maxSize)%maxSize;
                return true;
            }
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return deque[front];
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            //rear-1+maxSize,防止rear为0时,数组越界
            return deque[(rear-1+maxSize)%maxSize];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
}