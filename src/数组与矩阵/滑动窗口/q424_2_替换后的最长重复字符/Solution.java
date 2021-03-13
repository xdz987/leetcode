package 数组与矩阵.滑动窗口.q424_2_替换后的最长重复字符;

public class Solution {
    public static void main(String[] args) {
        String s = "AABABBA";
        int K = 1;
        CharacterReplacement characterReplacement = new CharacterReplacement();
        System.out.println(characterReplacement.characterReplacement(s, K));
    }
}

/**
 * 做题过程遇到问题：
 * 看题阶段：不知道怎么动态保存当前频率最大字符是哪个
 * 看了暴力破解：想到使用maxCharCount比较而保存频率最大字符。但不知道怎么统计除最大频率之外的字符：无需统计
 * 滑动窗口
 * 窗口内元素数量 <= maxCharCount + K
 */
class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        //(1)初始化窗口指针、当前最大频率字符数量maxCharCount、统计窗口内字符频率freq
        int left = 0;
        int right = 0;
        int maxCharCount = 0;
        int res = 0;
        int[] freq = new int[26];

        //滑动窗口
        while (right < s.length()) {
            //(2)right向右拓展窗口，更新freq
            int rNum = s.charAt(right);
            right++;
            freq[rNum - 'A']++;

            //(3)保存最大频率字符数量
            maxCharCount = Math.max(maxCharCount, freq[rNum - 'A']);

            //(4)需要替换的字符大于K，缩小窗口，更新freq
            if (right - left > maxCharCount + k) {
                int lNum = s.charAt(left);
                left++;
                freq[lNum - 'A']--;
            }

            //(5)保存替换后的最长重复字符
            res = Math.max(res, right - left);
        }
        return res;
    }
}
