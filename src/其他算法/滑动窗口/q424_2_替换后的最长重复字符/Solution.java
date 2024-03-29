package 其他算法.滑动窗口.q424_2_替换后的最长重复字符;

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
    //9ms
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

    //二刷：5ms
    public int characterReplacement2(String s, int k) {
        int n = s.length();
        if (n == 0) return 0;
        char[] sArr = s.toCharArray();
        int res = 0;
        int left = 0;
        int right = 0;
        int[] window = new int[26];
        int maxFreq = 0;
        while (right < n) {
            int cI = sArr[right] - 'A';
            window[cI]++;
            maxFreq = Math.max(maxFreq, window[cI]);

            while (right - left + 1 > maxFreq + k) {
                int dI = sArr[left] - 'A';
                window[dI]--;
                left++;
                maxFreq = Math.max(maxFreq, window[cI]);
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    //三刷：5ms 补充
    public int characterReplacement3(String s, int k) {
        int n = s.length();
        int[] window = new int[26];
        int left = 0;
        int right = 0;
        int res = 0;
        int maxFreq = 0;
        int maxI = 0;
        while(right<n){
            int rI = s.charAt(right)-'A';
            window[rI]++;
            right++;
            //等于也保存，因为后面缩小窗口时可能更新maxFreq--。如这里相等不保存，那么会导致maxFreq不是当前窗口最大频率字符
            if(window[rI]>=maxFreq){
                maxFreq = window[rI];
                maxI = rI;
            }
            while(right-left>maxFreq+k){
                int lI = s.charAt(left)-'A';
                //更新max避免bug
                if(lI == maxI){
                    maxFreq--;
                }
                window[lI]--;
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
