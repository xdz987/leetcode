package 树.字典树.q820_2_单词的压缩编码;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：HashSet
 * 遍历所有words所有word，删除等于另一word后缀的word
 */
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        //(1)数组转Set
        Set<String> set = new HashSet<>(Arrays.asList(words));
        //(2)删除等于另一word后缀的word
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        //(3)统计单词长度
        int res = 0;
        for (String word : set) {
            res += word.length() + 1;
        }
        return res;
    }
}
