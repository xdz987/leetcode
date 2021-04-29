package 哈希表.q383_1_赎金信;

/**
 * 方法一：枚举法
 * Java：94% 56%
 * 复杂度：O(n) O(n)
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineFreq = new int[26];
        for (char c : magazine.toCharArray()) {
            magazineFreq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            magazineFreq[c - 'a']--;
            if (magazineFreq[c - 'a'] < 0) return false;
        }
        return true;
    }
}