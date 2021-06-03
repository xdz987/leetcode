package 其他算法.双指针.q344_1_反转字符串;

public class Solution {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
        System.out.println(s);
    }
}

/**
 * 双指针
 * 交换left和right位置值，left++ right--
 */
class ReverseString {
    public void reverseString(char[] s) {
        //(1)初始化边界
        int left = 0;
        int right = s.length - 1;

        //(2)反转字符串
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}