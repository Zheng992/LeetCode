package leetcode.editor.cn;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1360 👎 0

import java.util.ArrayList;
import java.util.List;

public class MinStack{
    public static void main(String[] args) {
    }

//leetcode submit region begin(Prohibit modification and deletion)
    //需要把类名MinStacks去掉s，改为MinStack才可运行
class MinStacks {

    List<int[]> stack= new ArrayList<>();
    int top=-1;
    int min;

    public void push(int val) {
        if(stack.isEmpty()){
            min=val;
        }else{
            if(getMin()>val){
                min=val;
            }else{
                min=getMin();
            }
        }
        top++;
        stack.add(new int[]{val,min});
    }

    public void pop() {
        stack.remove(top);
        top--;
    }

    public int top() {
        return stack.get(top)[0];
    }

    public int getMin() {
        return stack.get(top)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}