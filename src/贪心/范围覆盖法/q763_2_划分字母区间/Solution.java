package 贪心.范围覆盖法.q763_2_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：贪心
 * Java：100% 80%
 * 局部最优/贪心：
 *  1. 字母只能出现在一个子串内，所以即子串尽可能包含所有重复字母
 *  2. 尽可能分割最大数量子串
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        //(1)初始化intMap、res
        List<Integer> res = new ArrayList<>();
        int[] intMap = new int[26];
        char[] SArr = S.toCharArray();
        int n = SArr.length;
        //(2)记录每个字符的终点
        for (int i = 0; i < n; i++) {
            intMap[SArr[i] - 'a'] = i;
        }
        //(3)拆分字符串并记录每个分段的终点
        int subStrStart = 0;
        int subStrMax = 0;
        for (int i = 0; i < n; i++) {
            //(3.1)实现局部最优1。如起点字母的开始和终点包含字母为更大最后位置，则更大字母最后位置为准
            subStrMax = Math.max(subStrMax, intMap[SArr[i] - 'a']);
            //(3.2)实现局部最优2。达到终点，立即分割
            if (i == subStrMax) {
                res.add(subStrMax - subStrStart + 1);
                subStrStart = i + 1;
            }
        }

        return res;
    }
}
