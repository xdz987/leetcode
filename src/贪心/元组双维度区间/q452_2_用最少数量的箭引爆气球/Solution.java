package 贪心.元组双维度区间.q452_2_用最少数量的箭引爆气球;

import java.util.Arrays;

/**
 * 方法一：贪心
 * Java：90% 28%
 * 局部最优：一箭引爆最大数量的重叠区间
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        //(1)先排序，按end降序
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        //(2)初始化res，由于是比较，所以初始值为1
        int res = 1;
        int cur = points[0][1];
        //(3)遍历每个区间
        for (int i = 1; i < n; i++) {
            //(2.1)end没有包含该区间的start，重新开始，res++
            if (cur < points[i][0]) {
                res++;
                cur = points[i][1];
            }
        }
        return res;
    }
}
