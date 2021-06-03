package 数组.剑50_1_第一个只出现一次的字符;

public class Solution {
    public char firstUniqChar(String s) {
        if (s.equals("")) return ' ';
        int len = s.length();
        //(1)存储26个小写字母
        int[] intMap = new int[26];
        //(2)保存频率
        for (int i = 0; i < len; i++) {
            intMap[s.charAt(i) - 'a']++;
        }

        //(3)按左到右的顺序，遇到第一个频率为1的即返回
        for (int i = 0; i < len; i++) {
            if (intMap[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }

        return ' ';
    }
}
