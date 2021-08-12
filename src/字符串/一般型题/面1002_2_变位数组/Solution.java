package 字符串.一般型题.面1002_2_变位数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：暴力法
 * 复杂度：O(26*n^2) O(n^2)
 * Java：5% 56%
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        boolean[] used = new boolean[n];
        int[][] compare = new int[n][26];
        for(int i=0;i<n;i++){
            for(char c:strs[i].toCharArray()){
                compare[i][c-'a']++;
            }
        }
        for(int i=0;i<n;i++){
            if(used[i])
                continue;
            List<String> tmp = new ArrayList<>();
            tmp.add(strs[i]);
            used[i] = true;
            for(int j=i+1;j<n;j++){
                for(int k=0;k<26;k++){
                    if(compare[i][k] != compare[j][k]){
                        break;
                    }
                    if(k==25){
                        tmp.add(strs[j]);
                        used[j] = true;
                    }
                }
            }
            res.add(tmp);
        }
        return res;
    }
}