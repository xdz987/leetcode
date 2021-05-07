package 剑指offer补充.剑38_2_字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 方法一：回溯
 * Java：
 * 复杂度：
 */
class Solution {
    public String[] permutation(String s) {
        char[] sArr = s.toCharArray();
        List<String> res = new ArrayList<>();
        backTrack(res, sArr, 0);
        return res.toArray(new String[res.size()]);
    }

    private void backTrack(List<String> res, char[] sArr, int start) {
        if (start + 1 == sArr.length) {
            res.add(new String(sArr));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = start; i < sArr.length; i++) {
            if (set.contains(sArr[i]))
                continue;
            set.add(sArr[i]);
            swap(sArr, i, start);
            backTrack(res, sArr, start + 1);
            swap(sArr, i, start);
        }
    }

    private void swap(char[] sArr, int i1, int i2) {
        char tmp = sArr[i1];
        sArr[i1] = sArr[i2];
        sArr[i2] = tmp;
    }
}