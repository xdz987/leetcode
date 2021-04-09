package 堆.剑41_3_数据流中的中位数;

import java.util.PriorityQueue;

public class Solution {

}

/**
 * 方法一：双堆
 * 重点：一小一大顶堆，小顶堆存放【元素小】的一半，大顶堆存放【元素大】的一半
 * 性质：始终保持大顶堆的栈顶【小于】小顶堆的栈顶
 */
class MedianFinder {
    PriorityQueue<Integer> smallHeap, bigHeap;
    public MedianFinder() {
        bigHeap = new PriorityQueue<>(
                (n1, n2) -> n2 - n1
        );
        smallHeap = new PriorityQueue<>(
                (n1, n2) -> n1 - n2
        );
    }

    /* 始终保持大顶堆栈顶【小于】小顶堆栈顶 */
    public void addNum(int num) {
        //(1)说明相差>1，调整平衡性。向smallHeap添加元素达到平衡
        if (bigHeap.size() != smallHeap.size()) {
            //(1.1)不符合性质，对调位置
            if (bigHeap.peek() > num) {
                smallHeap.offer(bigHeap.poll());
                bigHeap.offer(num);
            }
            //(1.2)符合性质，直接push达到平衡性
            else {
                smallHeap.offer(num);
            }
        }
        //(2)完全平衡(平衡性为0)时。选择一个堆作为中间数存放。这里选的是bigHeap，所以当平衡时优先往bigHeap存，与(1)对称
        else {
            //(2.1)符合性质，直接push达到平衡性
            if (bigHeap.isEmpty() || smallHeap.peek() > num) {
                bigHeap.offer(num);
            }
            //(2.2)不符合性质，对调位置
            else {
                bigHeap.offer(smallHeap.poll());
                smallHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        return bigHeap.size() == smallHeap.size()
                ? ((double) bigHeap.peek() + smallHeap.peek()) / 2
                : bigHeap.peek();
    }
}