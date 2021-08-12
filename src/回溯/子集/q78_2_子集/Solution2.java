package 回溯.子集.q78_2_子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法二：位运算
 * 复杂度：O(n*2^n) O(n)
 * Java：82% 98%
 */
public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //(1)遍历每种子集，2^n个。如n=3，该循环为000,001,010,011...111，8位子集
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> tmp = new ArrayList<>();
            //遍历每个位
            //(2)位运算，取交集。如n=3，该循环为001(第三位元素),010(第二位元素),100(第一位元素)
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
