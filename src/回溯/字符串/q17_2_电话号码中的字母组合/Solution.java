package 回溯.字符串.q17_2_电话号码中的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：回溯
 * Java：100% 80%
 */
public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        //(1)初始化按键
        char[][] numToLetter = new char[10][];
        numToLetter['2' - '0'] = new char[]{'a', 'b', 'c'};
        numToLetter['3' - '0'] = new char[]{'d', 'e', 'f'};
        numToLetter['4' - '0'] = new char[]{'g', 'h', 'i'};
        numToLetter['5' - '0'] = new char[]{'j', 'k', 'l'};
        numToLetter['6' - '0'] = new char[]{'m', 'n', 'o'};
        numToLetter['7' - '0'] = new char[]{'p', 'q', 'r', 's'};
        numToLetter['8' - '0'] = new char[]{'t', 'u', 'v'};
        numToLetter['9' - '0'] = new char[]{'w', 'x', 'y', 'z'};
        //(2)回溯
        char[] digitsArr = digits.toCharArray();
        backTrack(digitsArr, numToLetter, new StringBuilder(), 0);
        return res;
    }

    private void backTrack(char[] digitsArr, char[][] numToLetter, StringBuilder track, int digitIndex) {
        //(1)base case：排列完成添加进res
        if (track.length() == digitsArr.length) {
            res.add(track.toString());
            return;
        }

        //(2)决策树遍历，以'按键数字'对应的字母作为【选择列表】
        char digit = digitsArr[digitIndex];
        for (int letterIndex = 0; letterIndex < numToLetter[digit - '0'].length; letterIndex++) {
            track.append(numToLetter[digit - '0'][letterIndex]);
            //(3)每个'按键数字'只能使用一次。传递digitIndex+1参数，指向下一个'按键数字'
            backTrack(digitsArr, numToLetter, track, digitIndex + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
