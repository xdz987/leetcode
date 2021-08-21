## 算法与数据结构学习&刷题记录
- 题目数：400道左右
- 选题标准：经典学习题、高频重点题
- 包含内容：算法学习笔记、算法刷题笔记、一题多解
- 后续更新：牛客真题+ACM模式
    
---
- 今日签到题：
    - 日期：8.21
    - 题型：二叉树
    - 难度：简单/中等
    - 题号：KS2
    - 解题思路：归并递归
        - 原题：不需要前序条件
            - 确定节点：curI=(left+right)>>1
            - 确定范围：[left,curI-1],[curI+1,right]
        - 改题：非满二叉树，元素不重复
            - 看LC的前中序构建二叉树
    
```java
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
```

### 数组与矩阵
### 双指针
- 快慢指针
- 左右指针
- 二分查找：二分、左侧边界二分、右侧边界二分

### 区间
- 滑动窗口：固定窗口、可变窗口(满足条件最小/最大窗口)
- 前缀和

### 分治
### 排序
- 堆排、归并、快排、选排、冒泡

### 栈与队列

- 栈与队列转换
- 单调栈/辅助栈
- 单调队列

### 堆/优先队列

- 固定堆
- 双堆

### 字符串

- KMP应用
- 一般型题
- 技巧型题

### 链表

- 链表节点批量操作
- 单节点查找/操作

### 树

- 二叉树
  1. 修改二叉树
  2. 构建二叉树
  3. 搜索二叉树
  4. 层序遍历二叉树
  - 递归前、后、层序等
  - 迭代前、中、后序
- 二叉搜索树
  1. 构架BST
  2. 修改BST
  3. 搜索BST
  4. 其他算法
    - 中序遍历、二分法等
- 字典树/前、后缀树/Trie
- Morris前、中、后序遍历

### 图论

- 并查集
    - 路径压缩、平衡性优化/条件选择
- 拓扑排序
    - 邻接表
        1. BFS+入度表
        2. DFS+标记表
- 二分图
    - 邻接表
        1. DFS+标记表
        2. BFS+标记表
        3. 并查集
- 最小生成树【未】

### 其他算法

- 位运算
    - 位移、异或、与运算
    - 综合统计
    - 有限自动状态机
    - 摩尔投票法
- 数学题型
    - 质数、最大公约数最小公倍数、进制转换、阶乘、字符串加法减法、相遇问题、多数投票问题
    - 其他算法

### 回溯

- 排列
- 组合
- 子集
- Flood Fill
    - DFS/回溯(可相互转)
- 字符串问题
- 游戏问题

### 贪心

- 传递法
- 取差值法
- 枚举排除法
- 拆分法
- 范围覆盖法
- 元组/双维度/区间

### 动态规划

1. 斐波那契类型问题
    1. 斐波那契数列
    2. 打家劫舍题型
2. 分割整数问题【子问题纵向传递】
3. 矩阵路径问题【方向选择】
    1. 矩阵路径——组合问题
    2. 矩阵路径——最值问题
4. 背包问题
    1. 0/1背包——最值问题
    2. 0/1背包——元素和
    3. 0/1背包——元素和的组合
    4. 完全背包——最值问题
    5. 完全背包——组合问题
    6. 完全背包——排列问题
5. 股票买卖问题【多状态转移】
6. 最长xx子序列
    1. 最长公共子序列【元素相等】
    2. 最长递增子序列【元素递增/减】
    3. 最长回文子序列【回文串】
    4. xx子序列的数量
7. 区间计算
