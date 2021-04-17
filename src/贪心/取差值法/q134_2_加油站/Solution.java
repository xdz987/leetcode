package 贪心.取差值法.q134_2_加油站;

/**
 * 同q53一个类型
 * 方法一：贪心：
 * Java：100% 67%
 * 局部最优：当前累加rest[j]的和curSum⼀旦⼩于0，起始位置⾄少要是j+1，因为从j开始⼀定不⾏
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int curSum = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            int surplus = gas[i] - cost[i];
            curSum += surplus;
            totalSum += surplus;
            //说明x~i为起点一定不足以绕一圈
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }
}