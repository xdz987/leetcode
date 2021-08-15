## 算法与数据结构学习&刷题记录
- 题目数：400道
- 选题标准：经典学习题、高频重点题
- 包含内容：算法学习笔记、算法刷题笔记、一题多解
- 后续更新：每日签到题...
    - PS：思路笔记录入对应模块刷题总结
    
---
- 今日签到题：
    - 日期：8.15
    - 题型：记忆化dfs/dp
    - 难度：中等
    - 题号：q576
    - 解题思路：
        - 记忆化：矩阵m*n的每个位置设立一个记忆化数组,该数组记录move从0道maxMove的出界路径数量
        1. 初始化memo[i][j][move]每个位置的记忆化数组为-1，表示没有访问过
            - 如不初始化而判断是否为0会导致无限递归
        2. 返回(startRow,startColumn),maxMove的dfs递归
        - 递归函数
            1. 判断是否出界，是则返回1
            2. 判断move是否为0，是则返回0（出不了界）
            3. 判断memo是否存在(x,y,move)的记录，存在则返回
            4. 初始化count为0
            5. count累加遍历四个方向的dfs结果
                - 需模运算(1e9+7)
            6. 保存memo并返回
```java
public class Solution {
    int[][][] memo;
    int mod = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int move = 0;move<=maxMove;move++){
                    memo[i][j][move]=-1;
                }
            }
        }
        return dfs(m,n,maxMove,startRow,startColumn);
    }

    private int dfs(int m, int n, int move, int row, int col){
        if(row<0 || col<0 || row==m || col == n)
            return 1;
        if(move == 0)
            return 0;
        if(memo[row][col][move]!=-1){
            return memo[row][col][move];
        }
        int count = 0;
        count = (count+dfs(m,n,move-1,row+1,col))%mod;
        count = (count+dfs(m,n,move-1,row,col+1))%mod;
        count = (count+dfs(m,n,move-1,row-1,col))%mod;
        count = (count+dfs(m,n,move-1,row,col-1))%mod;
        memo[row][col][move] = count;

        return count;
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
