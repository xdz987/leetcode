package 数组与矩阵.数组思路.q645_1_错误的集合;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 3, 7, 8, 9, 10};
        int[] nums = new int[]{3, 2, 2};
        FindErrorNums findErrorNums = new FindErrorNums();
        System.out.println(Arrays.toString(findErrorNums.findErrorNums(nums)));
    }
}

/**
 * 注：题中的单元测试不代表规律，有可能[3,2,2]
 * 增加一个额外数组，通过索引查找原数组，从而找到重复数。再循环通过额外数组为0的索引(因为元素为1~n且数组的长度为n)即为丢失的数
 */
class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        //(1)初始化
        int[] result = new int[2];
        byte[] markNums = new byte[nums.length + 1];

        //(2)设置所有非重复和1个重复元素为1，另1重复元素默认0
        for (int num : nums) {
            if (markNums[num] != 0) {
                result[0] = num;
            }
            markNums[num] = 1;
        }

        //(3)查找丢失的数,为0则表示没出现过(赋值为1)
        for (int i = 0; i < markNums.length; i++) {
            if (markNums[i] == 0) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}