package 字符串.一般型题.q242_1_有效字符异位词;

/**
 * 方法一：intMap[]
 * Java：100% 95%
 * 复杂度：O(2n) O(2n)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        //(1)不相等一定不符合
        if (n != m) return false;
        //(2)统计s和t各字符的频率
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < n; i++) {
            sMap[sArr[i] - 'a']++;
            tMap[tArr[i] - 'a']++;
        }
        //(3)判断s和t各字符频率是否相等
        for (int i = 0; i < 26; i++) {
            if (sMap[i] != tMap[i])
                return false;
        }
        return true;
    }
}