package 回溯.子集.q90_2_子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法二：位运算
 */
public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //为实现剪枝，需先排序
        Arrays.sort(nums);
        //(1)遍历每种子集，2^n个。如n=3，该循环为000,001,010,011...111，8位子集
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> tmp = new ArrayList<>();
            //(2)位运算，取交集。如n=3，该循环为001(第三位元素),010(第二位元素),100(第一位元素)
            boolean illegal = false;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    /* 与q78不同点，增加个剪枝 */
                    //【待学了位运算回来补充理解】
                    //具有相同元素（如[1,2]下标0,1，[1,2]下标1,3）的i的二进制具有规律：除了第一位，其他位的1的前边一定是0
                    if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0) {
                        illegal = true;
                        break;
                    }
                    tmp.add(nums[j]);
                }
            }
            /* 与q78不同点 */
            if (!illegal)
                res.add(tmp);
        }
        return res;
    }
}
