package 字符串.KMP应用.编程之美_2_字符串循环位移包含;

/**
 * 方法一：KMP+循环数组
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "AABCD";
        String s2 = "CDAA";
        System.out.println(isContains(s1, s2));
    }

    public static boolean isContains(String s1, String s2) {
        if (s2.length() > s1.length()) return false;
        //查找s2，由于是循环数组，所以s1复制多一份
        s1 = s1 + s1;
        int n = s1.length();
        int m = s2.length();

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        //建立next数组
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && s2Arr[i] == s2Arr[j]) {
                j = next[j - 1];
            }
            if (s2Arr[i] == s2Arr[j]) {
                j++;
            }
            next[i] = j;
        }

        //查找s2
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s1Arr[i] != s2Arr[j]) {
                j = next[j - 1];
            }
            if (s1Arr[i] == s2Arr[j]) {
                j++;
            }
            if (j == m) return true;
        }
        return false;
    }
}
