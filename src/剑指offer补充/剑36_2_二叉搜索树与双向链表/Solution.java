package 剑指offer补充.剑36_2_二叉搜索树与双向链表;

/**
 * 方法一：中序遍历
 * Java：100% 80%
 * 复杂度：O(N) O(N)
 */
class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        inorderTraversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inorderTraversal(Node cur) {
        if (cur == null)
            return;
        inorderTraversal(cur.left);
        if (pre != null)
            pre.right = cur;
        else
            head = cur;
        cur.left = pre;
        pre = cur;
        inorderTraversal(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};