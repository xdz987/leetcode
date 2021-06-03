package 其他算法.双指针.q524_2_通过删除字母匹配到字典里最长单词;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        FindLongestWord findLongestWord = new FindLongestWord();
        System.out.println(findLongestWord.findLongestWord(s, dictionary));
    }
}

/**
 * 同q392
 * 同向条件双指针
 */
class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String ss : dictionary) {
            //(1)初始化指针
            int sp = 0;
            int ssp = 0;

            //(2)判断ss是否为s的子序列
            while (sp < s.length() && ssp < ss.length()) {
                if (s.charAt(sp) == ss.charAt(ssp)) {
                    ssp++;
                }
                sp++;
            }
            if (ssp == ss.length()) {
                //(3)判断是否为 当前 最大长度最小字典顺序的子序列
                if (ss.length() > result.length() || ss.length() == result.length() && ss.compareTo(result) < 0) {
                    result = ss;
                }
            }
        }

        return result;
    }
}
