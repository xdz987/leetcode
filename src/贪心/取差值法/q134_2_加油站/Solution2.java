package 贪心.取差值法.q134_2_加油站;

/**
 * 暴力法
 * Java：39ms 30%
 */
class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                sum = gas[i] - cost[i];
                for (int j = i + 1; j < i + n; j++) {
                    int index = j % n;
                    sum = sum + (gas[index] - cost[index]);
                    if (sum < 0)
                        break;
                }
                if (sum >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
