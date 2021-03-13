package 数组与矩阵.分治.q395_2_至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        String s = "ababccdddef";
        int k = 4;
        LongestSubstring2 longestSubstring = new LongestSubstring2();
        System.out.println(longestSubstring.longestSubstring(s, k));
    }
}

/**
 * 滑动窗口：见滑动窗口q395
 * 分治 递归
 * 滑动窗口>分治
 * 重点：
 * 1. 找到字符串中小于k的字符，以该字符作为分割点，分割字符串t
 * 2. 不断的分割，直到字符串t所有字符数量都>=k，即满足条件
 * 3. 取得所有分割子串中满足k数量长度中的最大值
 */
class LongestSubstring2 {
    public int longestSubstring(String s, int k) {
        //递归子串出口
        if (s.length() < k) {
            return 0;
        }
        //(1)初始化字符频率容器
        Map<Character, Integer> freq = new HashMap<>();

        //(2)统计所有字符频率
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        //(3)寻找小于k的字符，包含该字符一定不符合：至少K个重复字符的子串
        for (char c : freq.keySet()) {
            if (freq.get(c) < k) {
                //(4)递归，如果字符数小于k，则将字符串中以该字符作为分割，分割成：该字符数+1 个字符串，并进行分治
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    //递归，不断以小于k的字符作为分割点
                    res = Math.max(res, longestSubstring(t, k));
                }
                //所有递归结束，返回最长子串
                return res;
            }
        }

        //递归子串出口，到此则说明s(或子串t)不存在小于k的字符：即至少存在k个重复字符的子串(不一定是最长)
        return s.length();
    }
}