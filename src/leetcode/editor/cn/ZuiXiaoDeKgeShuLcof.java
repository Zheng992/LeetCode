package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 463 👎 0

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int[] arr={3,3,3};
        solution.getLeastNumbers(arr,1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //1.冒泡排序
        /*for (int i=arr.length;i>0;i--){
            for(int j=0;j<i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;*/

        //2.堆
        /*int[] res=new int[k];

        if(k==0){
            return res;
        }

        PriorityQueue<Integer> queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //存入k个元素
        for(int i=0;i<k;i++){
            queue.offer(arr[i]);
        }

        //实时维护堆内为k个最小值
        for (int i=k;i<arr.length;i++){
            if(arr[i]< queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }

        return res;*/

        //3.快排思想
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }

    public int[] quickSort(int[] arr,int k, int l, int r){
        int i=l;
        int j=r;
        while(i<j){
            while(i<j && arr[j] >= arr[l]){
                j--;
            }
            while(i<j && arr[i]<=arr[l]){
                i++;
            }

            swap(arr,i,j);
        }
        swap(arr,i,l);

        if(i>k) {
            return quickSort(arr, k, l, i - 1);
        }
        if(i<k){
            return quickSort(arr,k,i+1,r);
        }
        return Arrays.copyOf(arr,k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}