package 其他算法.双指针.q15_2_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：排序+双指针
 * Java：80% 95%
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //(1)先降序排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //(2)遍历所有元素
        for (int i = 0; i < n; i++) {
            //剪枝：nums[i]大于0时+右边两个元素必定>0
            if (nums[i] > 0) break;
            //去重1：当i==i-1时，说明i-1已经计算过，跳过i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //(3)从i+1与n-1之间缩小范围
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                //(3.1)当i+left+right=0时，存入res
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重2：当left==left+1时，说明left已经计算过，跳过left+1
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    //去重3：当right==right-1时，说明right已经计算过，跳过right-1
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                //(3.2)sum<0时，left++增加范围
                else if (sum < 0) {
                    left++;
                }
                //(3.2)sum>0时，right减小范围
                else {
                    right--;
                }
            }
        }
        return res;
    }

    //二刷：无区别
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return res;
        for (int left = 0; left < n - 2; left++) {
            if (nums[left] > 0)
                break;
            if (left > 0 && nums[left] == nums[left - 1])
                continue;

            int mid = left + 1;
            int right = n - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[mid]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    while (mid < right && nums[mid + 1] == nums[mid])
                        mid++;
                    while (mid < right && nums[right - 1] == nums[right])
                        right--;
                    mid++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return res;
    }

    //三刷：更好理解
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n<3) return res;
        Arrays.sort(nums);
        for(int left = 0;left<n-2;left++){
            if(nums[left]>0){
                break;
            }
            if(left>0 && nums[left] == nums[left-1])
                continue;
            int mid = left+1;
            int right = n-1;
            while(mid<right){
                int sum = nums[left]+nums[mid]+nums[right];
                if(sum==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[mid]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    while(mid > left+1 && nums[mid] == nums[mid-1])
                        mid++;
                    while(right > mid && nums[right] == nums[right-1])
                        right--;
                    mid++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    mid++;
                }
            }
        }
        return res;
    }
}