package 数学.多数投票问题.q229_2_求众数II;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：摩尔投票法
 * Java：98% 45%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //(1)抵消阶段，找到可能的最多两个候选人（后续计数阶段判断确定是否为候选人）
        int candidate1 = nums[0], candidate2 = candidate1;
        int vote1 = 0, vote2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                vote1++;
            } else if (candidate2 == num) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = num;
                vote1++;
            } else if (vote2 == 0) {
                candidate2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        //(2)计数阶段，判断两位候选人票数是否大于3/n
        vote1 = 0;
        vote2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                vote1++;
            } else if (candidate2 == num)
                vote2++;
        }
        if (vote1 > nums.length / 3)
            res.add(candidate1);
        if (vote2 > nums.length / 3)
            res.add(candidate2);
        return res;
    }
}