package 字符串.技巧型题.q647_2_回文子串;

/**
 * 方法二：中序拓展法
 * Java：96% 90%
 * 复杂度：O(n^2) O(1)
 */
class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        char[] sArr = s.toCharArray();
        //(1)遍历所有中心点，范围由0~n*2-1，取中心点时会/2
        for (int center = 0; center < n * 2 - 1; center++) {
            //(2)判断是否为回文，进行计数
            //(2.1.1)center为偶数时，中心点left、right为当前字符
            //(2.1.2)center为奇数时，中心点left前一字符、right为当前字符
            int left = center / 2;
            int right = left + (center & 1);
            //(2.2)由中心向左右拓展，左右相等则该子串为回文串。中心本身也算回文串
            while (left >= 0 && right < n && sArr[left] == sArr[right]) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}