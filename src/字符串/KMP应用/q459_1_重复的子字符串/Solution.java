package 字符串.KMP应用.q459_1_重复的子字符串;

/**
 * 方法一：KMP
 * Java：100% 60%
 * 复杂度：O(n) O(n)
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        //(1)建立next数组
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && sArr[i] != sArr[j]) {
                j = next[j - 1];
            }
            if (sArr[i] == sArr[j]) {
                j++;
            }
            next[i] = j;
        }

        //(2)通过next数组判断子串s是否由子串组成
        return next[n - 1] != 0 && n % (n - next[n - 1]) == 0;
    }
}