package 字符串.KMP应用.KMP_q28;

import java.util.Arrays;

/**
 * 方式二：非哨兵版
 */
public class Solution2 {
    public static void main(String[] args) {
        String str = "aabaabaaf";
        String needle = "aabaaf";
        System.out.println(strStr(str, needle));
    }

    public static int strStr(String str, String needle) {
        if (needle.isEmpty()) return 0;

        int n = str.length();
        int m = needle.length();

        char[] strArr = str.toCharArray();
        char[] neeArr = needle.toCharArray();

        //建立next/prefix数组
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && neeArr[i] != neeArr[j]) {
                j = next[j - 1];
            }
            if (neeArr[i] == neeArr[j]) {
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        //查找needle
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && strArr[i] != neeArr[j]) {
                j = next[j - 1];
            }
            if (strArr[i] == neeArr[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
