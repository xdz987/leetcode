package 回溯.排列.q60_3_排列序列;

import java.util.LinkedList;
import java.util.List;

/**
 * 方法一：链表模拟
 */
class Solution {
    public String getPermutation(int n, int k) {
        //(1)初始化
        //(1.1)阶乘：从1开始，对应每层各分治的叶子节点数量
        int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        //(1.2)1-n的元素集合，替代used数组
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        //(1.3)存放结果res
        StringBuffer res = new StringBuffer();

        //k作为下标需-1
        k--;
        //(2)模拟遍历决策树的每一层
        for (int i = n - 1; i >= 0; i--) {
            //(2.1)计算得出k位于index位置的分支
            int index = k / factorials[i];
            res.append(nums.remove(index));
            //(2.2)进入下一层
            k -= index * factorials[i];
        }
        return res.toString();
    }
}