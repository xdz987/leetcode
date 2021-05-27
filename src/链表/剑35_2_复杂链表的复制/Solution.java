package 链表.剑35_2_复杂链表的复制;

import 链表.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 题解：DeepCopy难点在于random变量指向的是原链表节点，需要讲random脱离原链表
 * 方法一：原地法-拼接与拆分：
 * 1. 在原链表的每个节点后新增一个相同val的节点
 * 2. 再讲新节点的random=原节点random.next
 * 3. 将新旧链表分离
 */
class CopyRandomList {
    //拼接与拆分
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node copyHead = head;

        //(1)每个节点增加新节点
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }
        head = copyHead;

        //(2)给新增节点random属性赋值
        while (head != null && head.next != null) {
            if (head.random != null)
                head.next.random = head.random.next;
            head = head.next.next;
        }

        //(3)分离新旧链表
        head = copyHead;
        copyHead = head.next;
        Node dummyNode = new Node(-1);
        dummyNode.next = copyHead;
        while (copyHead != null && copyHead.next != null) {
            head.next = head.next.next;
            copyHead.next = copyHead.next.next;

            head = head.next;
            copyHead = copyHead.next;
        }
        head.next = null;

        return dummyNode.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}