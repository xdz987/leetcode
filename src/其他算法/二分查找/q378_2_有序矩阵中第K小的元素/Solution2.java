package 其他算法.二分查找.q378_2_有序矩阵中第K小的元素;

/**
 * 方法二：归并排序
 * Java：4ms 50%
 */
class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = 0;
        int[] sortArr = sort(matrix,0,n-1);
        return sortArr[k-1];
    }

    private int[] sort(int[][] matrix,int left,int right){
        if(left == right){
            return matrix[left];
        }
        int mid = (left+right)>>1;
        return merge(sort(matrix,left,mid),sort(matrix,mid+1,right));
    }

    private int[] merge(int[] left,int[] right){
        int lN = left.length;
        int rN = right.length;
        int[] arr = new int[lN+rN];
        int arrI = 0;
        int lI = 0;
        int rI = 0;
        while(lI<lN && rI<rN){
            if(left[lI] <= right[rI]){
                arr[arrI++] = left[lI++];
            }else{
                arr[arrI++] = right[rI++];
            }
        }
        for(int i=lI;i<lN;i++){
            arr[arrI++] = left[i];
        }
        for(int i=rI;i<rN;i++){
            arr[arrI++] = right[i];
        }
        return arr;
    }
}