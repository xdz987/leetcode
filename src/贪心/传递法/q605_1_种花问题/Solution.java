package 贪心.传递法.q605_1_种花问题;

/**
 * 方法一：贪心
 * Java：100% 100%
 * 局部最优：尽可能节省空间来种花
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //(1)初始化count、前一盆子、下一盆子
        int len = flowerbed.length;
        int count = 0;
        //左边界处理，即-1位置为0
        int pre = 0;
        int next;
        int i;
        //(2)遍历所有盆子
        for (i = 0; i < len - 1; i++) {
            next = flowerbed[i + 1];
            //(2.1)如前一盆子为空，下一盆子为空，当前盆子叶为空，则在当前盆子种植花朵
            if (pre == 0 && next == 0 && flowerbed[i] == 0) {
                //在当前盆子种植花朵
                flowerbed[i] = 1;
                count++;
            }
            pre = flowerbed[i];
        }
        //右边界处理，即n+1位置为0
        if (pre == 0 && flowerbed[i] == 0) {
            count++;
        }
        return count >= n;
    }
}