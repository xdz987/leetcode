package 数组与矩阵.双指针.q345_1_反转字符串元音字母;

public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels(s));
    }
}

/**
 * 左右指针
 * 当为元音字母则nums[left]交换nums[right]
 */
class ReverseVowels {
    public String reverseVowels(String s) {
        //(1)初始化边界
        char[] s2 = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        //(2)交换元音字符
        while (left < right) {
            if (isVowel(s2[left])) {
                if (isVowel(s2[right])) {
                    char tmp = s2[left];
                    s2[left] = s2[right];
                    s2[right] = tmp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return new String(s2);
    }

    //判断是否为元音字母
    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'U' || c == 'u';
    }
}