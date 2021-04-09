package 字符串.q409_1_最长回文串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        //大写字母与小写字母52位，中间还有6位特殊符号
        int[] intMap = new int[58];
        for (int i : s.toCharArray()) {
            intMap[i - 'A']++;
        }

        int res = 0;
        for (int n : intMap) {
            res += n - (n & 1);
        }

        return res < s.length() ? res + 1 : res;
    }
}
