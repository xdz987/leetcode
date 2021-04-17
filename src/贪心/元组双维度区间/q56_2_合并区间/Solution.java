package 贪心.元组双维度区间.q56_2_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：贪心
 * Java：50% 60%
 * 局部最优/贪心：
 *  1. 合并区间后取最广范围。即最左与最右边界
 *  2. 尽去除掉最大数量的所有重叠区间
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> container = new ArrayList<>();
        //(1)为符合【贪心1】，取start取到最左边界，第一顺序按start降序。而为了去除重叠区间，第二顺序按end降序
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
        //start取到【最左边界】
        int start = intervals[0][0];
        int end = intervals[0][1];
        //(2)遍历所有区间
        for (int i = 1; i < n; i++) {
            //(2.1)不是重叠区间，添加到res，设立新start。否则是重叠区间，直接跳过，【贪心2】
            if (end < intervals[i][0]) {
                container.add(new int[]{start, end});
                start = intervals[i][0];
            }
            //(2.2)更新end，取【最右边界】
            end = Math.max(intervals[i][1], end);
        }
        //(2.3)最后一次比较没有添加到container
        container.add(new int[]{start, end});
        return container.toArray(new int[0][2]);
    }
}
