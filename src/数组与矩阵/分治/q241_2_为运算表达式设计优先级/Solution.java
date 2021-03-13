package 数组与矩阵.分治.q241_2_为运算表达式设计优先级;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str = "2*3-4*5";
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        System.out.println(diffWaysToCompute.diffWaysToCompute(str));
    }
}

/**
 * 分治-递归
 * 分：以运算符号"+""-""*"进行分割和递归
 * 治：当递归传入的字符串为一个数字时递归结束返回合并
 * 优化：备忘录，存储计算结果，递归开始前查找备忘录，存在直接返回结果
 */
class DiffWaysToCompute {
    //优化-备忘录
    Map<String, List<Integer>> memorandum = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        //优化-检测备忘录
        if (memorandum.containsKey(input)) {
            return memorandum.get(input);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //(1)根据"+""-""*"分割字符串进行递归拆分
            if (c == '+' || c == '-' || c == '*') {
                //递归
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                //(2)将递归返回的数字进行l*r种加()的可能进行计算
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        //(3)子串递归的结果，即当个数字
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }

        //优化-保存计算结果
        memorandum.put(input, res);
        return res;
    }
}