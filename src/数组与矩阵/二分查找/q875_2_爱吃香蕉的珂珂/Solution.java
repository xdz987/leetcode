package 数组与矩阵.二分查找.q875_2_爱吃香蕉的珂珂;

public class Solution {
    public static void main(String[] args) {
        int[] piles = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(piles, 823855818));
    }
}

/**
 * (1)暴力法[超出时间限制]
 * (2)左侧边界二分查找
 * 注意点：1. 计算吃蕉时间需设为long，否则会溢出 2.尽量避免使用%模操作
 */
class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {
        //(1)初始化边界 即k的速率范围
        int minK = 1;
        int maxK = maxPile(piles);

        //暴力法
        //(2)查找在H小时内吃完香蕉的最小k值
//        for (int K = minK; K <= maxK; K++) {
//            if (canFinish(piles, K, H)) {
//                return K;
//            }
//        }
//        return maxK;

        //左侧边界二分查发
        //(2)查找在H小时内吃完香蕉的最小k值
        while (minK < maxK) {
            int mid = minK + ((maxK - minK) >>> 1);
            if (canFinish(piles, mid, H)) {
                maxK = mid;
            } else {
                minK = mid + 1;
            }
        }
        return minK;
    }

    //判断是否能在k速率下于H小时内吃完
    private boolean canFinish(int[] piles, int K, int H) {
        long count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += timeOf(piles[i], K);
        }
        return count <= H;
    }

    //计算一堆香蕉需要吃几个小时
    private int timeOf(int pile, int K) {
        // 不要用%
        return (pile - 1) / K + 1;
    }

    //计算最大的一堆香蕉
    private int maxPile(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }
        return max;
    }
}