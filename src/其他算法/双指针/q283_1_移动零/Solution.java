package 其他算法.双指针.q283_1_移动零;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}

/**
 * 实际不需要移动0，只需要移动非0元素至左边，再将右边填充为0即可
 * 双指针
 */
class MoveZeroes {
    public static void main(String[] args) {
//        String s3 = new String("a") + new String("a");
        String a = "a";
        String b = "a";
        String s3 = a+b;
        String ss = "a"+s3;
        ss.intern();
        String s4 = "aaa";
        System.out.println(s4 == ss);
//        String s1 = new String("aa").intern();
//        String s2 = s1.intern();
//        String s3 = new String("aa").intern();
//        System.out.println(s1 == s3);
//        System.out.println(s2 == s3);
//        System.out.println(s1 == s3);
//        System.out.println(s2 == s3);
    }
    public void moveZeroes(int[] nums) {
        //(1)将非0元素向左靠拢，采用直接覆盖的方法
        int notZeroI = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroI++] = nums[i];
            }
        }
        //(2)填充0元素
        while (notZeroI < nums.length) {
            nums[notZeroI++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}