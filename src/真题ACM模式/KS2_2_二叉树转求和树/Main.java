package 真题ACM模式.KS2_2_二叉树转求和树;

import java.util.Scanner;

/**
 * 原题解：不需要前序条件，直接根据满二叉树+中序条件，归并递归计算结果
 * 此改题：非满二叉树+元素不重复
 * 改题方法一：归并递归
 */
public class Main{
    static int[] res;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String sPre = in.nextLine();
        String sMid = in.nextLine();
        String[] preArr = sPre.split(" ");
        String[] midArr = sMid.split(" ");
        int n = preArr.length;
        int[] preNums = new int[n];
        int[] midNums = new int[n];
        res = new int[n];
        for(int i=0;i<n;i++){
            preNums[i] = Integer.parseInt(preArr[i]);
            midNums[i] = Integer.parseInt(midArr[i]);
        }
        traversal(preNums,0,n-1,midNums,0,n-1);
        for(int i=0;i<n-1;i++)
            System.out.print(res[i]+" ");
        System.out.print(res[n-1]);
    }
    private static int traversal(int[] pre,int pLeft,int pRight,
                                 int[] mid,int mLeft,int mRight){
        if(mLeft==mRight){
            return mid[mLeft];
        }
        int cur = pre[pLeft];
        int lRange = 0;
        for(int i=mLeft;i<=mRight;i++){
            if(mid[i]!=cur) lRange++;
            else break;
        }
        int childSum = traversal(pre,pLeft+1,pLeft+lRange,mid,mLeft,mLeft+lRange-1)
                + traversal(pre,pLeft+lRange+1,pRight,mid,mLeft+lRange+1,mRight);
        res[mLeft+lRange] = childSum;
        return childSum+cur;
        //pre [pLeft+1,pLeft+lRange] [pLeft+lRange+1,pRight]
        //mid [mLeft,mLeft+lRange-1] [mLeft+lRange+1,mRight]
    }
}