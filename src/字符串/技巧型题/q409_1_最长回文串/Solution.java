package 字符串.技巧型题.q409_1_最长回文串;

/**
 * 方法一：intMap直接统计
 * Java:
 * 复杂度：O(n) O(56)
 */
public class Solution {
    public int longestPalindrome(String s) {
        //(1)统计所有字符出现次数。大写字母与小写字母52位，中间还有6位特殊符号
        int[] intMap = new int[58];
        for (int i : s.toCharArray()) {
            intMap[i - 'A']++;
        }

        int res = 0;
        //(2)可组成回文字符串必定是偶数字符，所以当为奇数则-1
        for (int freq : intMap) {
            //res+=奇数-1
            res += freq - (freq & 1);
        }

        //(3)当最后结果res<length，说明存在奇数位的字符，回文左右对称即可，中间可+1
        return res < s.length() ? res + 1 : res;
    }
}
