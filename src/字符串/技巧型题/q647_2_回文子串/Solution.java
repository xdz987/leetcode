package 字符串.技巧型题.q647_2_回文子串;

/**
 * 方法一：DFS+回文子串
 * Java：9% 67%
 * 复杂度：(n^3) O(n^2)
 */
class Solution {
    int res = 0;

    public int countSubstrings(String s) {
        dfs(s.toCharArray(), 0);
        return res;
    }

    //判断是否为回文子串
    private boolean isPalindrome(char[] sArr, int start, int end) {
        while (start < end) {
            if (sArr[start] != sArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //DFS所有字符串按顺序的子串：是否为回文子串
    private void dfs(char[] sArr, int start) {
        if (start == sArr.length) return;
        for (int i = start; i < sArr.length; i++) {
            if (isPalindrome(sArr, start, i)) {
                res++;
            }
        }
        dfs(sArr, start + 1);
    }
}