package 其他算法.二分查找.q287_2_寻找重复数;

/**
 * 方法二：同q645类型，使用额外数组而去重，但空间为O(n)
 */
public class Solution2 {
    //时间为O(n) 空间为(On)
    public int findDuplicate(int[] nums) {
        //(1)初始化 额外数组
        boolean[] mark = new boolean[nums.length + 1];
        //(2)查找重复的数
        for (int num : nums) {
            if (mark[num])
                return num;
            mark[num] = true;
        }
        return -1;
    }
}
