package 数组与矩阵.二分查找.q1011_2_D天内送达包裹的能力;

public class Solution {
    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        System.out.println(shipWithinDays.shipWithinDays(weights, 5));
    }
}

/**
 * 同q875解法
 * 左侧边界二分查找
 */
class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        //(1)初始化边界 运载能力的范围
        int minLoad = getMaxLoad(weights);
        int maxLoad = getTotalLoad(weights);
        int mid = 0;

        //(2)数组与矩阵.二分查找 查找最低运载
        while (minLoad < maxLoad) {
            mid = minLoad + ((maxLoad - minLoad) >>> 1);
            if (canFinish(weights, mid, D)) {
                maxLoad = mid;
            } else {
                minLoad = mid + 1;
            }
        }
        return minLoad;
    }

    //判断是否能够于D日内完成
    private boolean canFinish(int[] weights, int load, int D) {
        int i = 0;
        for (int days = 1; days <= D; days++) {
            // 每天都有一个重量可使用
            int maxLoad = load;
            while ((maxLoad -= weights[i]) >= 0) {
                i++;
                if (weights.length == i) {
                    return true;
                }
            }
        }
        return false;
    }

    //取得最大数
    private int getMaxLoad(int[] weights) {
        int max = weights[0];
        for (int weight : weights) {
            max = Math.max(weight, max);
        }
        return max;
    }

    //取得总数
    private int getTotalLoad(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}
