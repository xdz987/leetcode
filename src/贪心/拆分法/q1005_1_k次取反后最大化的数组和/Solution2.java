package 贪心.拆分法.q1005_1_k次取反后最大化的数组和;

/**
 * 方法二：贪心
 * Java：89% 76%
 * 局部最优：
 * 1. 存在负数时，k次将绝对值最大的负数转为正数，如还存在k值，则继续2.
 * 2. 均为正数时，k%2为0则保持不变，k%2=1则将最小绝对值转为负数
 */
class Solution2 {
    public int largestSumAfterKNegations(int[] A, int K) {
        int n = A.length;
        //(1)按绝对值快排
        quickSort(A, 0, n - 1);
        //(2)按绝对值大到小，将负数转换为正数
        for (int i = 0; i < n && K > 0; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
                K--;
            }
        }
        //(3)还有剩余k，%2余1，则绝对值最小的数字取相反数
        if (K % 2 == 1) {
            A[n - 1] = -A[n - 1];
        }
        //(4)累加
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        return sum;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >> 1);

        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (Math.abs(nums[i]) > Math.abs(nums[pivot])) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, --index);
        return index;
    }

    private void swap(int[] nums, int p1, int p2) {
        if (p1 == p2) return;
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}