package 剑指offer补充.剑33_2_BST的后序遍历;

/**
 * 方法一：遍历所有子树
 * Java：100% 70%
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int left, int right) {
        //说明只有一个节点
        if (left >= right)
            return true;
        int p = left;
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int mid = p;
        while (postorder[p] > postorder[right]) {
            p++;
        }
        //p!=right说明有不符合BST的子树
        return p == right && verify(postorder, left, mid - 1) && verify(postorder, mid, right - 1);
    }
}