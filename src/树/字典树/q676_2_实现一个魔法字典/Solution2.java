package 树.字典树.q676_2_实现一个魔法字典;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

}

/**
 * 方法二：直接法
 * (1)目标单词与字典中的单词长度一致
 * (2)目标单词与字典中的单词存在一个字符不同
 *  (2.1)是则为魔法单词，直接返回true
 *  (2.2)遍历字典所有单词都不符合条件，返回false
 *
 * Java执行：57% 75%
 */
class MagicDictionary2 {
    String[] magicDictionary;

    public MagicDictionary2() { }

    public void buildDict(String[] dictionary) {
        magicDictionary = dictionary;
    }

    public boolean search(String searchWord) {
        //与字典中每个单词进行比较
        for (String word : magicDictionary) {
            if (isMagicWord(word, searchWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMagicWord(String word, String searchWord) {
        //(1)长度不相等直接返回
        if (word.length() != searchWord.length())
            return false;
        //(2)只能有一个字符不符合才是魔法单词
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != searchWord.charAt(i)) {
                counter++;
            }
            if (counter > 1)
                return false;
        }
        return counter == 1;
    }
}