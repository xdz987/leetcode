package 排序.q1337_1_元组排序;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[][] sortArr = new int[n][2];
        for(int i=0;i<n;i++){
            sortArr[i][0] = getSum(mat[i]);
            sortArr[i][1] = i;
        }
        quickSort(sortArr,0,n-1,k);

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = sortArr[i][1];
        }
        return res;
    }

    private int getSum(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n;
        while(left<right){
            int mid = (left+right)>>1;
            if(arr[mid] == 0){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private void quickSort(int[][] arr,int left,int right,int k){
        if(left<right){
            int pivot = partition(arr,left,right);
            quickSort(arr,left,pivot-1,k);
            quickSort(arr,pivot+1,right,k);
        }
    }

    private int partition(int[][] arr,int left,int right){
        swap(arr,left,(left+right)>>1);
        int index = left+1;
        for(int i=index;i<=right;i++){
            if(arr[left][0]>arr[i][0] || arr[left][0] == arr[i][0] && arr[left][1] > arr[i][1]){
                swap(arr,i,index++);
            }
        }
        swap(arr,left,--index);
        return index;
    }

    private void swap(int[][] arr,int i1,int i2){
        if(i1!=i2){
            int[] tmp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = tmp;
        }
    }
}