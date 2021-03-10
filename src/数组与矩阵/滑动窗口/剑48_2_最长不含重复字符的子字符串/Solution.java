package 数组与矩阵.滑动窗口.剑48_2_最长不含重复字符的子字符串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String str = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(str));
    }
}

/**
 * 即q3
 */
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char rNum = s.charAt(right++);

            while (window.contains(rNum)) {
                char lNum = s.charAt(left++);
                window.remove(lNum);
            }
            window.add(rNum);

            res = Math.max(res, right - left);
        }
        return res;
    }
}