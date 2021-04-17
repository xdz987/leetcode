package 贪心.元组双维度区间.q435_2_无重叠区间;

import java.util.Arrays;

/**
 * 放法一：贪心
 * Java：48% 28%
 * 局部最优：最少数量的去除重叠区间，去除end更大的重叠区间。如[1,2][1,3]，去除[1,3]可避免与[2,4]重叠
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        //(1)先按照end进行降序排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int cur = intervals[0][1];
        //(2)由于是查重叠区间，所以初始值为0
        int res = 0;
        //(3)遍历所有区间
        for (int i = 1; i < n; i++) {
            //(3.1)当重叠的时候数量+1，相当于删除重叠的那个区间，所以cur不变
            if (cur > intervals[i][0]) {
                res++;
            }
            //(3.2)不重叠，指向下一个区间
            else{
                cur = intervals[i][1];
            }
        }
        return res;
    }
}