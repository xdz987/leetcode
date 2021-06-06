package 其他算法.二分查找.q1011_2_D天内送达包裹的能力;

/**
 * 方法二：二分查找+优化
 */
public class Solution2 {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxWeight = getMaxWeight(weights);
        int left = 0;
        int right = maxWeight * ((n / days) + 1);
        while (left < right) {
            int mid = (left + right) >> 1;
            //剪枝：包裹不可拆分，所以船载重至少得是最大包裹重量
            if (mid >= maxWeight && canFinish(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //此辅助函数假定了：轮船必定能够装下包裹，与上面剪枝相对应
    private boolean canFinish(int[] weights, int limit, int loadWeight) {
        int days = 1;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] <= loadWeight) {
                load += weights[i];
            } else {
                load = weights[i];
                days++;
            }
        }
        return days <= limit;
    }

    private int getMaxWeight(int[] weights) {
        int max = weights[0];
        for (int i = 1; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
        }
        return max;
    }
}
