package 贪心.q45_2_跳跃游戏2;

/**
 * 方法一：贪心
 * 局部最优：当前可移动距离尽可能多⾛，如果还没到终点，步数再加⼀
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int stepEnd = 0;
        int jumpCount = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == stepEnd) {
                jumpCount++;
                stepEnd = farthest;
            }
        }
        return jumpCount;
    }
}