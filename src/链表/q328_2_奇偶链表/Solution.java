package 链表.q328_2_奇偶链表;

import 链表.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        OddEvenList oddEvenList = new OddEvenList();
        head = oddEvenList.oddEvenList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

/**
 * 等于与指向的区别：
 * 等于：A=B，将A节点(对象)的地址等于B
 * 指向：A.next=B，将A节点的next成员变量存储为B的节点地址
 * <p>
 * 奇偶链表
 * 1. 先使得odd与head节点地址等于同一地址(第一个节点，奇数开头)。even与evenHead节点地址等于同一地址(第二个节点，偶数开头)
 * 2. 遍历使得odd和head的next变量都指向第三个节点地址，之后使得odd.next指向第五...九、十一节点地址，而head节点地址不变。最后head为奇数第一节点，odd为奇数最后节点
 * 3. 遍历使得even和evenHead的next变量都指向第四节点地址，之后even.next指向第六...十、十二节点地址，而evenHead节点地址不变。最后evenHead为偶数第一节点(2)，even为最后节点或null
 * 4. 拼接奇偶链表，将odd的尾结点指向even的头节点，之后返回odd的头结点，即奇偶链表
 */
class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}