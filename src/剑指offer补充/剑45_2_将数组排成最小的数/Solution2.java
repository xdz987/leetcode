package 剑指offer补充.剑45_2_将数组排成最小的数;

import java.util.Arrays;

/**
 * 系统自带函数排序
 */
public class Solution2 {
    public String minNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sNums, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder res = new StringBuilder();
        for(String str:sNums)
            res.append(str);
        return res.toString();
    }
}
