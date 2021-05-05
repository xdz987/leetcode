package 动态规划.最长xx子序列.最长公共子序列.q392_1_判断子序列;

/**
 * 方法二：双指针
 * Java：46% 37%
 * 复杂度：O(N+M) O(1)
 */
class Solution2 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.isEmpty()) return true;
        int tIndex = 0;
        int sIndex = 0;
        int count = 0;
        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                count++;
                sIndex++;
            }
            tIndex++;
            if (count == s.length())
                return true;
        }
        return false;
    }
}