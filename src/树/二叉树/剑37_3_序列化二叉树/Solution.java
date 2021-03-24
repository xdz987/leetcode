package 树.二叉树.剑37_3_序列化二叉树;

import 树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }
}

public class Codec {

    //使用队列层序遍历，然后转换为字符串格式。需要注意的最底层叶节点的null不影响反序列化，所以不需要处理
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder serialize = new StringBuilder();
        serialize.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                serialize.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else
                serialize.append("null,");
        }

        serialize.deleteCharAt(serialize.length() - 1);
        serialize.append("]");
        return serialize.toString();
    }

    //同序列化操作，只是反向操作
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //values数组的下标
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //为null则不处理，否则添加节点和队列
            //left
            if (!values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;
            //right
            if (!values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}