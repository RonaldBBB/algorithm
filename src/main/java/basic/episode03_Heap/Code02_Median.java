package basic.episode03_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * 剑指offer41 leetcode295
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/6/17 18:47
 * @Created by xiaofei
 */
public class Code02_Median {
    /**
     * 全文背诵：
     * PriorityQueue默认小根堆
     * 准备一个小根堆一个大根堆
     * 第一次加入元素时加入到大根堆确保大根堆中有元素
     * 每次加入元素时如果当前元素小于大根堆堆顶则加入大根堆；如果大于大根堆堆顶则加入小根堆
     * 然后调整使得两个堆的大小相差不超过1
     *
     * 取出元素时如果总数为奇数则取长度长的堆的堆顶元素
     * 如果总数为偶数则取两个堆顶元素的平均值
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public Code02_Median() {

    }

    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.add(num);
        }else if(num<=maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        // 调整使两个堆的大小不超过1
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.remove());
        }else if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else return maxHeap.size()>minHeap.size()?maxHeap.peek(): minHeap.peek();
    }
}