package 回溯.字符串.q22_2_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：回溯
 * 此题重点在于括号规律：
 * 1. 1对括号可拆分为左括号与右括号来看，那么2对括号即4个字符
 * 2. 起点必须是左括号
 * 3. 剩余左括号数量<=剩余右括号数量，否则括号不符合规律
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), n, n);
        return res;
    }

    private void backTrack(StringBuilder track, int leftCount, int rightCount) {
        //base case：左右括号达到n
        if (leftCount == 0 && rightCount == 0) {
            res.add(track.toString());
            return;
        }
        //(1)左括号剩余数量>右括号剩余数量，不符合规律，剪枝
        if (leftCount > rightCount) {
            return;
        }

        //2.1与2.2顺序不影响结果
        //(2.1)判定剩余leftCount>0，则追加'('
        if (leftCount > 0) {
            track.append('(');
            backTrack(track, leftCount - 1, rightCount);
            track.deleteCharAt(track.length() - 1);
        }

        //(2.2)判定剩余rightCount>0，则追加')'
        if (rightCount > 0) {
            track.append(')');
            backTrack(track, leftCount, rightCount - 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}