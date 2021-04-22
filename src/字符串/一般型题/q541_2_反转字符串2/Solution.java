package 字符串.一般型题.q541_2_反转字符串2;

/**
 * 方法一：暴力法
 */
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] sArr = s.toCharArray();
        //(1)以k作为循环
        for (int start = 0; start < n; start += 2 * k) {
            //(2)奇数k需要反转，限制j不超过字符串长度
            int i = start, j = Math.min(start + k - 1, s.length() - 1);
            while (i < j) {
                //(3)左右交换实现反转
                char tmp = sArr[i];
                sArr[i++] = sArr[j];
                sArr[j--] = tmp;
            }
        }
        return new String(sArr);
    }
}