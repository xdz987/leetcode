package 剑指offer补充.剑46_2_把数字翻译成字符串;

/**
 * 方法一：DP
 * Java：100% 80%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int translateNum(int num) {
        if (num / 10 == 0) return 1;
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        if ((nums[0] > '0' && nums[0] < '2') || (nums[0] == '2' && nums[1] <= '5')) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            if ((nums[i - 1] > '0' && nums[i - 1] < '2') || (nums[i - 1] == '2' && nums[i] <= '5')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }

    //状态压缩
    public int translateNum2(int num) {
        if (num / 10 == 0) return 1;
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        int ppre = 1;
        int pre = 1;
        if ((nums[0] > '0' && nums[0] < '2') || (nums[0] == '2' && nums[1] <= '5')) {
            pre = 2;
        }
        int cur = pre;
        for (int i = 2; i < n; i++) {
            if ((nums[i - 1] > '0' && nums[i - 1] < '2') || (nums[i - 1] == '2' && nums[i] <= '5')) {
                cur = pre + ppre;
            } else {
                cur = pre;
            }
            ppre = pre;
            pre = cur;
        }
        return cur;
    }

    //三刷：代码更简洁
    public int translateNum3(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int n = numArr.length;
        if(n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;//用于初始化
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int toNum = (numArr[i-2]-'0')*10 + numArr[i-1]-'0';
            if(numArr[i-2]!='0' && toNum>0 && toNum<=25){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
}