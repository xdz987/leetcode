package 其他算法.滑动窗口.q1004_2_最大连续1的个数2;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 3;
        LongestOnes longestOnes = new LongestOnes();
        System.out.println(longestOnes.longestOnes(A, K));
    }
}

/**
 * 满足条件最大窗口
 * 缩小窗口的条件：(1)0的数量大于K (2)0的数量等于K并且下一个right为0
 */
class LongestOnes {

    //三刷 3ms
    public int longestOnes3(int[] nums, int k) {
        int n = nums.length;
        int valid = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<n){
            if(nums[right] == 0){
                valid++;
            }
            right++;
            while(valid>k){
                if(nums[left] == 0){
                    valid--;
                }
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    //一刷 4ms
    public int longestOnes(int[] A, int K) {
        //(1)初始化窗口指针、窗口内元素为0的累加器、当前最大连续1的长度
        int left = 0;
        int right = 0;
        int zeroSum = 0;
        int res = 0;

        //滑动窗口
        while (right < A.length) {
            //(2)right向右拓展窗口
            int rNum = A[right];
            right++;

            //如为0则取令牌，且累加器+1
            if (rNum == 0) {
                zeroSum++;
            }

            //(4)当0的数量超过了当前令牌桶的令牌数时，缩小窗口
            if (zeroSum > K) {
                int lNum = A[left];
                left++;
                if (lNum == 0) {
                    zeroSum--;
                }
            }

            //保存长度
            res = Math.max(res, right - left);

            if (zeroSum == K && right < A.length && A[right] == 0) {
                int lNum = A[left];
                left++;
                if (lNum == 0) {
                    zeroSum--;
                }
            }
        }

        return res;
    }

    //二刷：3ms
    public int longestOnes2(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int zeroSum = 0;
        int res = 0;
        while (right < n) {
            if (nums[right] == 1) {
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                if (zeroSum < k) {
                    res = Math.max(res, right - left + 1);
                    right++;
                    zeroSum++;
                    continue;
                }
                while (nums[left] != 0) {
                    left++;
                }
                zeroSum--;
                left++;
            }
        }
        return res;
    }
}