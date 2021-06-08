package 其他算法.双指针.q524_2_通过删除字母匹配到字典里最长单词;

import java.util.Collections;
import java.util.List;

/**
 * 方法二：排序+查子序列
 */
public class Solution2 {
    public String findLongestWord(String s, List<String> dictionary) {
        int n = dictionary.size();
        Collections.sort(dictionary, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
        for (int i = 0; i < n; i++) {
            if (isSubsequence(dictionary.get(i), s)) {
                return dictionary.get(i);
            }
        }
        return "";
    }

    public boolean isSubsequence(String s, String t) {
        char[] tArr = t.toCharArray();
        int m = tArr.length;
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        if (n == 0) return true;
        int nI = 0;
        for (int i = 0; i < m; i++) {
            if (tArr[i] == sArr[nI])
                nI++;
            if (nI == n)
                return true;
        }
        return false;
    }
}
