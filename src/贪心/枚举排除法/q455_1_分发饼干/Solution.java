package 贪心.枚举排除法.q455_1_分发饼干;

import java.util.Arrays;

/**
 * 方法一：贪心
 * 局部最优：最小尺寸饼干给最小胃口孩子，或反之
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //降序
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, res = 0;
        //饼干从小到大遍历，满足小孩胃口则指向下一个胃口大的小孩，即gIndex++
        for (int sIndex = 0; sIndex < s.length && gIndex < g.length; sIndex++) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
                res++;
            }
        }
        return res;
    }
}