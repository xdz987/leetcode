package 回溯.字符串.q131_2_分割回文串;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：回溯
 * Java：100% 78%
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s.toCharArray(), s.length(), 0, new ArrayList<>());
        return res;
    }

    private void backTrack(char[] sArr, int n, int start, ArrayList<String> track) {
        if (n == start) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < n; i++) {
            //剪枝：当前子串不为回文串，直接跳过
            //如aab，第一层为"","a"，"aa","aab"
            if (!isPalindrome(sArr, start, i))
                continue;
            track.add(new String(sArr, start, i + 1 - start));
            backTrack(sArr, n, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

    //判断是否为回文串
    private boolean isPalindrome(char[] sArr, int left, int right) {
        while (left < right) {
            if (sArr[left] != sArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
