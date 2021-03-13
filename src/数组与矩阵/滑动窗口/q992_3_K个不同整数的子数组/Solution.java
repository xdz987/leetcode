package 数组与矩阵.滑动窗口.q992_3_K个不同整数的子数组;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 1, 2, 3};
        int K = 2;
        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        System.out.println(subarraysWithKDistinct.subarraysWithKDistinct(A, K));
    }
}

/**
 * 解题：
 * 由于题目要求的是，某个子数组中不同的整数个数恰好(等于)为K，直接使用滑动窗口比较难求(如例1)。
 * 可运用技巧的是：恰好(等于)K可转换为最多为K，即：
 * (1)例如K=2。  最多为2则是：可以是1个整数或2个整数； 恰好为2：只能是2个整数
 * (2)即最多2 = 恰好为2 + 恰好为1/最多为1
 * (3)即恰好K = 最多K - 最多K-1
 * 而转换为最多为K后，则滑动窗口的计算变得很紧密。本来恰好为K需要跳过K-1...的情况，滑动窗口变得麻烦如(K=2,跳过1)；而最多为K则可以计算所有的可能，无需考虑K-1及往前的计算(如例2)。
 *
 * 例1:[1,2,1,2,3]，k=2。滑动窗口[1,2][1,2,1][1,2,1,2][2,3]只有4种，而少了3种[2,1][2,1,2][1,2]
 * 例2:[1,2,1,2,3]，K最多为2==>K=1或2。
 * K最多为2时：[1][1,2][1,2,1][1,2,1,2] [2][2,1][2,1,2] [1][1,2] [2][2,3] [3] = 12
 * K最多为1时，[1][2][1][2][3] = 5
 * 恰好2 = 最多为2 - 最多为1 = 12 - 5 = 7种
 *
 * 最多K的解法：
 * 滑动窗口上面例2：
 * 当窗口指针left或right固定(即在收缩或者拓展窗口处)时：res+=right-left(如right指向窗口最后一个元素，则+1)
 * 如left固定而向右拓展窗口：[1,2,1,2,3],k=2。 left=0固定时，直到K>2之前为 [1][1,2][1,2,1][1,2,1,2] 再收缩则[2][2,1][2,1,2] ... 直到[2][2,3] ==> 即4+3+2+1+2=12
 */
class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostDistinct(A, K) - atMostDistinct(A, K - 1);
    }

    private int atMostDistinct(int[] A, int K) {
        //(1)初始化窗口指针、不同整数数量valid、不同整数统计freq、结果res
        int length = A.length;
        int left = 0;
        int right = 0;
        int valid = 0;
        int[] freq = new int[length + 1];
        int res = 0;

        //滑动窗口
        while (right < length) {
            //(2)right向右拓展窗口，更新freq和valid
            int rNum = A[right];
            if (freq[rNum] == 0) {
                valid++;
            }
            freq[rNum]++;
            right++;

            //(3)不满足条件时left向右缩小窗口，更新freq和valid
            while (valid > K) {
                int lNum = A[left];
                freq[lNum]--;
                if (freq[lNum] == 0) {
                    valid--;
                }
                left++;
            }

            //(4)保存当前窗口元素的right-left种子数组数量
            res += right - left;
        }

        return res;
    }
}
