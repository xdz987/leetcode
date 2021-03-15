package 链表.q445_2_两数相加2;

import 链表.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 链表 栈
 * 数据结构效率：LinkedList>Stack
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        //构建栈
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyNode = new ListNode(-1);
        //进位
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int num1 = (s1.isEmpty()) ? 0 : s1.pop();
            int num2 = (s2.isEmpty()) ? 0 : s2.pop();
            int sum = num1 + num2 + carry;
            ListNode node = new ListNode(sum % 10);

            //插入至虚拟节点与数之间
            node.next = dummyNode.next;
            dummyNode.next = node;

            carry = sum / 10;
        }
        return dummyNode.next;
    }
}