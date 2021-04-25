package 数学.最大公约数最小公倍数;

public class Solution {
    public static void main(String[] args) {
        int a = 8;
        int b = 12;
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    //最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //最小公倍数=数字相乘/最大公约数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
