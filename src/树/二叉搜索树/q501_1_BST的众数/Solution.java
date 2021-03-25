package 树.二叉搜索树.q501_1_BST的众数;

import 树.二叉搜索树.ListNode;
import 树.二叉搜索树.TreeNode;

import java.util.*;

/**
 * 方法一：尝试。第一次中序找到最大次数，第二次中序判断为最大次数则保存。70% 47%
 * - O(n) O(n)
 * 方法二：中序遍历 + 动态保存众数。 70% 42%
 * - O(n) O(n)
 * 方法三：morris中序遍历(为非递归) + 动态保存众数
 * - O(n) O(1）
 * 1. 将二叉树线索化，转换为单链表，使得不用递归就可升序遍历所有节点
 * 2. 完成二叉树线索化后进行众数统计，并将二叉树还原，即去线索化
 */
class Solution {
    int maxTimes = 0;
    int tmpTimes = 0;
    Set<Integer> save;
    int last;

    public int[] findMode(TreeNode root) {
        save = new HashSet<>();
        last = Integer.MIN_VALUE;
        //第一次中序遍历，先找到最大次数
        find(root, false);
        tmpTimes = 0;
        //第二次遍历，保存众数
        find(root, true);

        int[] res = new int[save.size()];
        int i = 0;
        for (int num : save) {
            res[i++] = num;
        }
        return res;
    }

    private void find(TreeNode root, boolean find) {
        if (root == null) {
            return;
        }
        find(root.left, find);
        //(1)判断前后是否相等
        boolean repeat = root.val == last;
        last = root.val;
        //(2)重复则累加，否则重置为0
        if (repeat) {
            tmpTimes++;
        } else {
            tmpTimes = 0;
        }
        //(3)保存最大次数
        if (tmpTimes > maxTimes) {
            maxTimes = tmpTimes;
        }
        //(4)保存众数
        if (find && tmpTimes == maxTimes) {
            save.add(root.val);
        }

        find(root.right, find);
    }
}

class Solution2 {
    //保存众数List
    List<Integer> modes = new ArrayList<>();
    //当前重复数count，最大重复数maxCount，base第一个重复数(当然后继等于base才叫重复数)，用于比较
    int count, maxCount, base;

    public int[] findMode(TreeNode root) {
        inOrder(root);

        //将List转数组
        int[] res = new int[modes.size()];
        int i = 0;
        for (int num : modes) {
            res[i++] = num;
        }
        return res;
    }

    //中序遍历 查找众数
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        update(root.val);
        inOrder(root.right);
    }

    //更新众数数组
    private void update(int nodeVal) {
        //(1)判断是否重复，是则累加，不是则重新计数
        if (base == nodeVal) {
            count++;
        } else {
            count = 1;
            base = nodeVal;
        }

        //(2)相等则保存众数
        if (count == maxCount) {
            modes.add(base);
        }
        //(3)说明有更多重复数出现，清空数组，添加为(新)重复数
        if (count > maxCount) {
            modes.clear();
            maxCount = count;
            modes.add(base);
        }
    }
}

class Solution3 {
    //同方法二
    List<Integer> modes = new LinkedList<>();
    int count, maxCount, base;

    public int[] findMode(TreeNode root) {
        /* 不同之处，Morris/线索化 */
        //备份root节点，记录节点前缀pre
        TreeNode cur = root, pre = null;
        while (cur != null) {
            //(1)查找前继，如为空则直接update当前节点，cur指向下一个节点
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            //(2)更新当前节点的前缀
            pre = cur.left;
            //(3)当不为null，(并且pre.right!=cur，说明未线索化)，定位到需要线索化连接的地方
            while (pre.right != null && pre.right != cur) {
                //定位到最右子节点，
                pre = pre.right;
            }
            //(4)最右子节点为null，说明是未线索化，则进行线索化。并指向cur.left继续线索化
            if (pre.right == null) {
                //cur为后继
                pre.right = cur;
                /* 前序(忽略)，直接执行 */
                /* 后序1(忽略)，逆序打印其左子树的右边界 */
                //继续查找前缀，目的是为了线索化添加后继
                cur = cur.left;
            }
            //(5)不为null，说明pre.right==cur。则进行去线索化，并update当前节点，cur指向下一个节点
            else {
                pre.right = null;
                /* 中序，直接执行 */
                update(cur.val);
                cur = cur.right;
            }
            /* 后序2(忽略)，逆序打印整棵树的右边界 */
        }

        //同方法二
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    //同方法二
    private void update(int nodeVal) {
        if (base == nodeVal) {
            count++;
        } else {
            count = 1;
            base = nodeVal;
        }
        if (count == maxCount) {
            modes.add(base);
        }
        if (count > maxCount) {
            modes.clear();
            maxCount = count;
            modes.add(base);
        }
    }
}