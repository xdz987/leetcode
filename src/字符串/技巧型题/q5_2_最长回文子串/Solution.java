package 字符串.技巧型题.q5_2_最长回文子串;

/**
 * 方法一：中心拓展法
 * Java：93% 76%
 * 复杂度：O(n^2) O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        int longestLeft = 0;
        int longestRight = 0;
        for (int center = 0; center < n * 2 - 1; center++) {
            int left = center / 2;
            int right = left + (center & 1);
            while (left >= 0 && right < n && sArr[left] == sArr[right]) {
                //保存最长回文子串
                if (longestRight - longestLeft < right - left) {
                    longestLeft = left;
                    longestRight = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(longestLeft, longestRight + 1);
    }

    //自写版
    public String longestPalindrome2(String s) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        int longLeft = 0;
        int longRight = 0;
        for (int i = 1; i < n - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < n) {
                if (sArr[left] != sArr[right]) {
                    break;
                }
                if (right - left > longRight - longLeft) {
                    longLeft = left;
                    longRight = right;
                }
                left--;
                right++;
            }
        }
        for (int i = 1; i < n; i++) {
            int left = i - 1;
            int right = i;
            while (left >= 0 && right < n) {
                if (sArr[left] != sArr[right]) {
                    break;
                }
                if (right - left > longRight - longLeft) {
                    longLeft = left;
                    longRight = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(longLeft, longRight + 1);
    }
}