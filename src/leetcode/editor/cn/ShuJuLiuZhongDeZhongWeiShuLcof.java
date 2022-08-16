package leetcode.editor.cn;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-
//stream/ 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 348 👎 0

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;

public class ShuJuLiuZhongDeZhongWeiShuLcof{
    public static void main(String[] args) {
    }

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    /** initialize your data structure here. */
    //大小顶堆找中位数
    //将数组分在两个堆中存放,较小的一半放在大顶堆,保证堆顶为数组有序时的中间位置
    //较大的一半放在小顶堆,保证堆顶也是有序数组的中间位置
    //判断此时元素个数,再去取中位数.
    Queue<Integer> A,B;
    public MedianFinder() {
        A=new PriorityQueue<>(); //大顶堆,存放较小的一半 数目为(n-1)/2  or n/2   (分别对应n为奇数和偶数,保证A个数小于等于B)
        B=new PriorityQueue<>((x, y) -> (y - x)); //小顶堆,存放较大的一半,数目为(n+1)/2  or n/2
    }
    
    public void addNum(int num) {
        //1.若A==B(长度,下同),则添加到B,若A!=B,则添加到A
        if(A.size()==B.size()){
            //要放到B的数组,先放在A中进行相对排序,再将A最大的移到B中
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }
    
    public double findMedian() {
        return A.size()!=B.size()? B.peek():(A.peek()+ B.peek())/2.0;
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}