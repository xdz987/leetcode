package 其他算法.双指针.q88_1_合并两个有序数组;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Merge merge = new Merge();
        merge.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

/**
 * 双指针 从后往前
 * 指针1指向数组1最后非0元素，指针2指向数组2最后(非0)元素
 * 从后往前进行比较
 */
class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //(1)初始化指针
        int p1 = m - 1;
        int p2 = n - 1;

        //(2)合并数组
        int p3 = 0;
        for (p3 = m + n - 1; p3 >= 0 && p1 >= 0 && p2 >= 0; p3--) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p3] = nums1[p1--];
            } else {
                nums1[p3] = nums2[p2--];
            }
        }

        //(3)补充填充，均为较小元素
        for (int i = p3; i >= 0; i--) {
            if (p1 >= 0) {
                nums1[p1--] = nums1[p1];
            } else {
                nums1[p2--] = nums2[p2];
            }
        }
    }

    //二刷：更简洁
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int n1P = m - 1;
        int n2P = n - 1;
        int newP = m + n - 1;
        while (n1P >= 0 && n2P >= 0) {
            if (nums1[n1P] >= nums2[n2P]) {
                nums1[newP--] = nums1[n1P--];
            } else {
                nums1[newP--] = nums2[n2P--];
            }
        }

        //n1P不需要处理，因为就处在nums1原地

        while (n2P >= 0) {
            nums1[newP--] = nums2[n2P--];
        }
    }
}
