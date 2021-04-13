package 回溯.字符串.q784_2_字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：回溯
 * 前置知识：A~Z与a~z于ASCII表中相差32
 */
public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        //(1)添加空集
        res.add(S);
        //(2)回溯
        backTrack(S.toCharArray(), 0);
        return res;
    }

    private void backTrack(char[] SArr, int start) {
        //(1)遍历【决策树】每层
        for (int i = start; i < SArr.length; i++) {
            //(2)遍历【选择列表】
            //(2.1)判断是否为字母，根据题说明，不是数字即为字母，而字母大小写的ASCII码都比数字大
            if (SArr[i] > '9') {
                //大小写转换通过异或转换大小写
                SArr[i] ^= (1 << 5);
                //(2)记录子集
                res.add(String.valueOf(SArr));
                //剪枝条件：决策树子节点<父节点
                //实现剪枝：传递i+1作为start
                backTrack(SArr, i + 1);
                SArr[i] ^= (1 << 5);
            }
        }
    }
}
