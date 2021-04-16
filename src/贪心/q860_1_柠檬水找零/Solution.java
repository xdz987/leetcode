package 贪心.q860_1_柠檬水找零;

/**
 * 方法一：贪心
 * 局部最优：遇到账单20，优先消耗美元10，完成本次找零
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        //20元可以不用管，因为不用统计收入
        int money5 = 0;
        int money10 = 0;
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                money5++;
            } else if (bills[i] == 10) {
                if (money5 == 0)
                    return false;
                money5--;
                money10++;
            } else {
                if (money5 == 0)
                    return false;
                //先从10元开始找零
                if (money10 > 0) {
                    money5--;
                    money10--;
                    continue;
                }
                if (money5 > 2) {
                    money5-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
