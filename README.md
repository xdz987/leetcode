## 算法与数据结构学习&刷题记录
- 题目数：400道左右
- 选题标准：经典学习题、高频重点题
- 包含内容：算法学习笔记、算法刷题笔记、一题多解
- 后续更新：牛客真题+ACM模式
    
---
- 今日签到题：
    - 日期：8.20
    - 题型：找规律
    - 难度：简单
    - 题号：QQ11
    - 解题思路：
        - 题意：最多需要两次操作完成升序
        1. 当数字数量<=1时，无需排序操作
            - 直接返回0即可
        2. 遍历数组，取min，max值
        3. 当第一位为min值时，将后n-1个数排序即可
            - 所以直接返回1
        4. 当最后一位为max值时，将前n-1个数排序即可
            - 所以直接返回1
```java
class Solution {
    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        int left = 0;
        int right = sArr.length-1;
        while(left<right){
            if(!isVowel(sArr[left])){
                left++;
                continue;
            }
            if(!isVowel(sArr[right])){
                right--;
                continue;
            }
            char tmp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = tmp;
            left++;
            right--;
        }
        return new String(sArr);
    }

    private boolean isVowel(char c){
        return c == 'A' || c== 'a' || c== 'E'||c=='e'||c=='I'||c=='i'||c=='O'||c=='o'||c=='U'||c=='u';
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
