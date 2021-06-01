package 数学.字符串加法减法.q67_1_二进制求和;

/**
 * 方法一：模拟
 * Java：98% 45%
 * 复杂度：O(logN) O(1)
 */
class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (carry != 0 || aIndex >= 0 || bIndex >= 0) {
            if (aIndex >= 0 && a.charAt(aIndex--) == '1') {
                carry++;
            }
            if (bIndex >= 0 && b.charAt(bIndex--) == '1') {
                carry++;
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    //二刷
    public String addBinary2(String a, String b) {
        int n = a.length();
        int m = b.length();

        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        int aI = n-1;
        int bI = m-1;
        while(carry!=0 || aI>=0 || bI>=0){
            if(aI>=0 && aArr[aI--] =='1')
                carry++;
            if(bI>=0 && bArr[bI--] == '1')
                carry++;
            int sum = carry%2;
            carry/=2;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}