package 真题ACM模式.KS2_2_二叉树转求和树;

import java.util.Scanner;

/**
 * 原题
 * 方法一：归并递归
 */
public class Main2{
    static int[] res;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String sMid = in.nextLine();
        String[] midArr = sMid.split(" ");
        int n = midArr.length;
        int[] midNums = new int[n];
        res = new int[n];
        for(int i=0;i<n;i++){
            midNums[i] = Integer.parseInt(midArr[i]);
        }
        traversal(midNums,0,n-1);
        for(int i=0;i<n-1;i++)
            System.out.print(res[i]+" ");
        System.out.print(res[n-1]);
    }
    private static int traversal(int[] mid,int mLeft,int mRight){
        if(mLeft==mRight){
            return mid[mLeft];
        }
        int curI = (mLeft+mRight)>>1;
        int cur = mid[curI];
        int childSum = traversal(mid,mLeft,curI-1)
                + traversal(mid,curI+1,mRight);
        res[curI] = childSum;
        return childSum+cur;
    }
}