package 贪心.q55_2_跳跃游戏;

/**
 * 方法一：贪心
 * 最优局部：每次取最⼤跳跃步数（取最⼤覆盖范围）
 */
class Solution {
    public boolean canJump(int[] nums) {
        //(1)初始化为0，如nums只有一个元素，那么直接就是终点
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //(2)每次保存最远距离
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i)
                return false;
        }
        return farthest >= nums.length - 1;
    }
}