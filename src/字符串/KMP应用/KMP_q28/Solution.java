package 字符串.KMP应用.KMP_q28;

import java.util.Arrays;

/**
 * q28题
 * 方式一：下标0作为哨兵
 * 复杂度：O(m+n) O(1)
 */
public class Solution {
    public static void main(String[] args) {
        String str = "aabaabaaf";
        String needle = "aabaaf";
        System.out.println(strStr(str, needle));
    }

    public static int strStr(String str, String needle) {
        if (needle.isEmpty()) return 0;
        int n = str.length();
        int m = needle.length();

        //设立哨兵，可以不用处理j为-1的情况
        str = " " + str;
        needle = " " + needle;

        char[] strArr = str.toCharArray();
        char[] needleArr = needle.toCharArray();

        //构建next数组
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && needleArr[i] != needleArr[j + 1])
                j = next[j];
            if (needleArr[i] == needleArr[j + 1])
                j++;
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        //匹配
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && strArr[i] != needleArr[j + 1])
                j = next[j];
            if (strArr[i] == needleArr[j + 1])
                j++;
            if (j == m) return i - m;
        }
        return -1;
    }
}
