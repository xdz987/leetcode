#### 学习Morris遍历与线索二叉树的前置知识：二叉树前中后序、链表操作

### Morris遍历与线索二叉树
- Morris遍历与线索二叉树关系：线索二叉树是Morris算法的应用
- 当把一颗二叉树进行线索化后，不清除线索，可理解为一个特殊的二叉树数据结构
   - 这颗二叉树最好用于查改，不能增删。否则需要去线索化再重新线索化

### 线索二叉树
- 充分利用叶节点或单枝节点的Null指针，用于指向前驱与后继，使得二叉树变成链表(抽象)形式
   - 只使用left为null标记前驱或right为null标记后继，则变成单向链表
   - 如left为null标记前驱，而right为null标记后继，则形成双向链表

### Morris前、中和后序遍历区别
- 原理：即按二叉树的前中后的顺序来链接前驱后继
- 应用：按照遍历的位置来觉得前中后
   1. 前：不管有无左子树，都是第一次遍历到一个节点时就打印
   2. 中：对于有左子树能够遍历两次的节点在第二次遍历到的时候打印，无左子树只能遍历一次的节点在第一次遍历到的时候就打印。
   3. 后

#### Morris遍历简答
1. 如果cur无左孩子，cur向右移动（cur=cur.right）
2. 如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
   1. 如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
   2. 如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）

#### Morris的遍历次数
- 对于没有左子树的节点只到达一次，对于有左子树的节点会到达两次

#### Morris前序遍历
##### 前序执行位置：不管有无左子树，都是第一次遍历到一个节点时就打印
![image](https://note.youdao.com/src/3A60DA54BDE0483CACE19BAA99F61ABF)

```
public List<Integer> Morris_PreOrder(TreeNode root) {
	List<Integer> res = new ArrayList<>();
	if(root == null)
		return res;
	TreeNode cur = root;
	while(cur != null) {
		if(cur.left == null) {
			res.add(cur.val);
			cur = cur.right;
		} else {
			TreeNode tmp = cur.left;
			while(tmp.right != null && tmp.right != cur)
				tmp = tmp.right;
			if(tmp.right == null) {
				res.add(cur.val); //输出当前节点
				tmp.right = cur;  //找到当前节点的前驱节点
				cur = cur.left;
			} else {
				tmp.right = null;  //恢复二叉树
				cur = cur.right;
			}
		}
	}
	return res;
}
```


#### Morris中序遍历
##### 中序执行位置：对于有左子树能够遍历两次的节点在第二次遍历到的时候打印，无左子树只能遍历一次的节点在第一次遍历到的时候就打印。

- 即root-左子树头-左子树底-执行-左子树头-root-右子树

- 使用后继标记，将二叉树链接成单链表
   - 如为BST，则是升序单链表
- 线索化/update众数/去线索化路线：
   1. root节点-->左子树逐个线索化即root.left然后root.left.right...right...null-->线索化整颗左子树到达最左子节点(升序的第一个)-->update众数-->然后不断走right即后继(刚已经线索化)update众数并去线索化-->到达root节点update众数取线索化-->到达root.right
   2. 位于root.right然后重复(1)
   3. 到达root.right.right然后重复(1)
   4. 直到最后即最右子节点(即升序的最后一个)完成众数查找


![image](http://note.youdao.com/yws/res/36588/7567EC6AB7924747863B5D910204E5F1)
```
public List<Integer> Morris_InOrder(TreeNode root) {
	List<Integer> res = new ArrayList<>();
	if(root == null)
		return res;
	TreeNode cur = root;
	while(cur != null) {
		if(cur.left == null) {
			res.add(cur.val);
			cur = cur.right;
		} else {
			TreeNode tmp = cur.left;
			while(tmp.right != null && tmp.right != cur)
				tmp = tmp.right;
			if(tmp.right == null) {
				tmp.right = cur;  //找到当前节点的前驱节点
				cur = cur.left;
			} else {
				res.add(cur.val);
				tmp.right = null;  //恢复二叉树
				cur = cur.right;
			}
		}
	}
	return res;
}
```
#### Morris后序遍历
##### 后序执行位置：
1. 需要建立一个临时节点，并令该节点的左子节点为root
2. 第二次遍历到的时候，倒序输出某两个节点之间路径上的各个节点。

![image](http://note.youdao.com/yws/res/36599/63EC3F9390924F6486C198CD4FB69484)
```
public List<Integer> Morris_PostOrder(TreeNode root) {
	List<Integer> res = new ArrayList<>();
	if(root == null)
		return res;
	TreeNode virNode = new TreeNode(-1);  //建立临时节点
	virNode.left = root;    //设置临时节点的左子节点为根节点
	TreeNode cur = virNode;
	while(cur != null) {
		if(cur.left == null) {
			cur = cur.right;
		} else {
			TreeNode tmp = cur.left;
			while(tmp.right != null && tmp.right != cur)
				tmp = tmp.right;
			if(tmp.right == null) {
				tmp.right = cur;  //找到当前节点的前驱节点
				cur = cur.left;
			} else {
				tmp.right = null;  //恢复二叉树
				//倒序输出：当前节点左子节点到当前节点前驱节点路径上的所有节点
                TreeNode node = cur.left;
                List<Integer> reOrder = new ArrayList<>();
                while (node != null) {
                    //头插法
                    reOrder.add(0, node.val);
                    node = node.right;
                }
                res.addAll(reOrder);
				cur = cur.right;
			}
		}
	}
	return res;
}
```
