package 其他算法.滑动窗口.q395_2_至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Failed {
    public static void main(String[] args) {
//        String s = "bbaaacbd";
        String s = "ababbc";
        int k = 2;
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.longestSubstring(s, k));
    }
}

/**
 * 滑动窗口 尝试失败
 * 待刷递归分治回来完成
 * 解题：标记所有小于K的字符，当滑动窗口遇到小于K的字符时left=right，重新滑动窗口计算
 */
class FLongestSubstring {
    public int longestSubstring(String s, int k) {
        //(1)初始化窗口指针、字符频率容器freq、小于K的字符belowChar、结果res
        int length = s.length();
        int left = 0;
        int right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        Set<Character> belowKChar = new HashSet<>();
        int res = 0;

        //统计所有字符频率
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        //统计频率小于k的字符
        for (char c : freq.keySet()) {
            if (freq.get(c) < k) {
                belowKChar.add(c);
            }
        }

        //所有字符都满足
        if (belowKChar.isEmpty()) {
            return s.length();
        }

        System.out.println(freq.toString());
        System.out.println(belowKChar.toString());
        //重置freq，将freq作为窗口内字符频率的容器
        freq = new HashMap<>();
        while (right < length) {
            //(2)向右滑动窗口，更新freq
            char rChar = s.charAt(right);
            freq.put(rChar, freq.getOrDefault(rChar, 0) + 1);
            right++;

            //(3)判断是否遇到频率小于k的字符，是则直接重置req，将left指向小于k字符的右边位置
            boolean isBelowKChar = false;
            for (char c : belowKChar) {
                //说明是小于k的字符，left直接跳到right位置，重置freq
                if (c == rChar) {
                    isBelowKChar = true;
                }
            }
            if (isBelowKChar) {

            }

            //(4)判断窗口内元素是否满足：子串至少由K个重复字符构成 的条件
            if (right - left >= k) {
                boolean isSatisfied = true;
                for (char c : freq.keySet()) {
                    if (freq.get(c) != 0 && freq.get(c) < k) {
                        isSatisfied = false;
                        break;
                    }
                }
                //窗口内元素满足条件
                if (isSatisfied) {
                    res = Math.max(res, right - left);
                }
            }
        }

        return res;
    }
}