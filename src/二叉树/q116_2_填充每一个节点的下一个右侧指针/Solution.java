package 二叉树.q116_2_填充每一个节点的下一个右侧指针;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * root左右子树分别展开并进行链接
 * 前缀：水平，对每个节点进行操作
 */
class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        //链接左右节点
        node1.next = node2;

        //连接left和right节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        //将right连接
        connectTwoNode(node1.right, node2.left);
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};