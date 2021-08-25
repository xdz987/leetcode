## 算法与数据结构学习&刷题记录
- 题目数：400道左右
- 选题标准：经典学习题、高频重点题
- 包含内容：算法学习笔记、算法刷题笔记、一题多解
- 后续更新：牛客真题+ACM模式
    
---
- 牛客真题+ACM模式：
    - 日期：8.25
    - 题型：DFS/回溯
    - 难度：中等
    - 题号：XM13
    - 解题思路：同力扣91
        - 如题目求【变化数】可使用动态规划
            - 当然也可以采用回溯/dfs，但只是计算变化数大材小用了，浪费时空
        - 如记录【每种变化】则采用回溯/dfs

```java
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    final static char[] RECORD = new char[]{
            ' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'
    };
    static StringBuilder res;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(bf.ready()){
            String number = bf.readLine();
            res = new StringBuilder();
            dfs(number.toCharArray(),0,new StringBuilder(),false);
            System.out.println(res.toString().trim());
        }
    }
    //flag：标志前一个转换的字母是否大于9
    //传递start作为下标
    private static void dfs(char[] sArr,int start,StringBuilder track,boolean flag){
        if(start == sArr.length){
            res.append(track.toString());
            res.append(" ");
            return;
        }
        if(sArr[start]>'0' && sArr[start]<='9'){
            dfs(sArr,start+1,new StringBuilder(track).append(RECORD[sArr[start]-'0']),false);
        }
        //前一个字母由<=9组成才可与当前字母组合
        if(!flag && start>0 && (sArr[start-1] == '1' || (sArr[start-1] == '2' && sArr[start]<='6'))){
            StringBuilder copy = new StringBuilder(track);
            copy.deleteCharAt(copy.length()-1);
            int RIndex = (sArr[start-1]-'0')*10+(sArr[start]-'0');
            copy.append(RECORD[RIndex]);
            dfs(sArr,start+1,copy,true);
        }
    }
}
```
```java
class Solution {
    public int numDecodings(String s) {
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        if(sArr[0] == '0') return 0;
        if(n==1)return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(sArr[i-1] != '0'){
                dp[i] += dp[i-1];
            }
            if(i>1 && sArr[i-2]!='0' && (sArr[i-2]=='1' || (sArr[i-2]=='2' && sArr[i-1] <= '6'))){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
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
