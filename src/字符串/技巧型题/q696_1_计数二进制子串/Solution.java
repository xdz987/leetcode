package 字符串.技巧型题.q696_1_计数二进制子串;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：按字符分组
 * Java：73% 93%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int countBinarySubstrings(String s) {
        //(1)初始化
        int n = s.length();
        int res = 0;
        //(1.1)上一重复字符的数量
        int lastSize = 0;
        //(1.2)当前重复字符的数量
        int size = 1;
        //(2)统计字符数量
        for (int i = 0; i < n - 1; i++) {
            //(2.1)相等则count++
            if (s.charAt(i) == s.charAt(i + 1)) {
                size++;
                continue;
            }
            //(2.2)保存相邻重复字符次数的最小值，即为具有相同数量0和1的字符数量的组合。
            res += Math.min(lastSize, size);
            lastSize = size;
            size = 1;
        }
        //(2.3)最后一个字符没比较，补充
        res += Math.min(lastSize, size);

        return res;
    }
}