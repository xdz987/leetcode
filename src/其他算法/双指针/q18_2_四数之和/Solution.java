package 其他算法.双指针.q18_2_四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：哈希表
 * Java：73% 69%
 * 复杂度：O(n^3) O(1)
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        int n = nums.length;
        //(1)先对数组进行降序排序
        Arrays.sort(nums);
        //(2)遍历[0~n-3)个元素，即【四个元素中左第一个元素】
        for (int i = 0; i < n - 3; i++) {
            //去重1：起点是0，当i==i-1时，说明i-1已经计算过，跳过i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //剪枝1：当当前i为起点的最左边四个元素（降序）总和都比target大时，后续的遍历更大，直接break
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target)
                break;

            //剪枝2：当当前i为起点的元素+最右边三个元素之和都比target小时，以i为起点的遍历不可能比target大，跳过i
            int max = nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (max < target)
                continue;

            //(3)遍历[i~n-2)个元素，即【四个元素中左第二个元素】
            for (int j = i + 1; j < n - 2; j++) {
                //去重2：起点是i+1，当j==j-1时，说明i-1已经计算过，跳过i
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                //剪枝3：同剪枝1思想，只是起点是第二个元素即j
                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target)
                    break;

                //剪枝4：同剪枝2思想，只是起点是第二个元素即j
                max = nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (max < target)
                    continue;

                //(4)双指针，查找等于target的值，思想同题目【三数之和】
                //left对应【四个元素的左第三个元素】
                int left = j + 1;
                //right对应【四个元素的左第四个元素】
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重3：当四个元素的左第三个元素存在重复，跳过
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //去重4：当四个元素的左第四个元素存在重复，跳过
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    //二刷：5ms
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4) return res;
        for (int left = 0; left < n - 3; left++) {
            if (left > 0 && nums[left] == nums[left - 1])
                continue;

            int min = nums[left] + nums[left + 1] + nums[left + 2] + nums[left + 3];
            if (min > target)
                break;
            int max = nums[left] + nums[n - 3] + nums[n - 2] + nums[n - 1];
            if (max < target)
                continue;

            int sum = nums[left];
            for (int midLeft = left + 1; midLeft < n - 2; midLeft++) {
                //从起点开始，所以是left+1
                if (midLeft > left + 1 && nums[midLeft] == nums[midLeft - 1])
                    continue;

                min = nums[left] + nums[midLeft] + nums[midLeft + 1] + nums[midLeft + 2];
                if (min > target)
                    break;
                max = nums[left] + nums[midLeft] + nums[n - 2] + nums[n - 1];
                if (max < target)
                    continue;

                sum += nums[midLeft];
                int midRight = midLeft + 1;
                int right = n - 1;
                while (midRight < right) {
                    int cal = nums[midRight] + nums[right];
                    sum += cal;
                    if (sum == target) {

                        res.add(Arrays.asList(nums[left], nums[midLeft], nums[midRight], nums[right]));
                        while (midRight < right && nums[midRight] == nums[midRight + 1])
                            midRight++;
                        while (midRight < right && nums[right] == nums[right - 1])
                            right--;
                        midRight++;
                        right--;
                    } else if (sum < target) {
                        midRight++;
                    } else {
                        right--;
                    }
                    sum -= cal;
                }
                sum -= nums[midLeft];
            }
        }
        return res;
    }

    //三刷：3ms
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n<4) return res;
        Arrays.sort(nums);
        for(int left = 0;left<n-3;left++){
            if(left>0 && nums[left] == nums[left-1]) continue;

            int min = nums[left]+nums[left+1]+nums[left+2]+nums[left+3];
            if(min>target) break;
            int max = nums[left]+nums[n-3]+nums[n-2]+nums[n-1];
            if(max<target) continue;

            for(int midL = left+1;midL<n-2;midL++){
                if(midL > left+1 && nums[midL] == nums[midL-1]) continue;

                min = nums[left]+nums[midL]+nums[left+1]+nums[left+2];
                if(min>target) break;
                max = nums[left]+nums[midL]+nums[n-2]+nums[n-1];
                if(max<target) continue;

                int midR = midL+1;
                int right = n-1;
                while(midR<right){
                    int sum = nums[left]+nums[midL]+nums[midR]+nums[right];
                    if(sum == target){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[left]);
                        tmp.add(nums[midL]);
                        tmp.add(nums[midR]);
                        tmp.add(nums[right]);
                        res.add(tmp);
                        while(midR>midL+1 && nums[midR] == nums[midR-1])
                            midR++;
                        while(right>midR && nums[right] == nums[right-1])
                            right--;
                        midR++;
                        right--;
                    }else if(sum>target){
                        right--;
                    }else{
                        midR++;
                    }
                }
            }
        }
        return res;
    }
}