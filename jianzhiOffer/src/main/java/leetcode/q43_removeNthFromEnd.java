package leetcode;

import java.util.Stack;

/*

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class q43_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode l=new ListNode(1);
        l.next=new ListNode(2);
//        l.next.next=new ListNode(3);
//        l.next.next.next=new ListNode(4);
//        l.next.next.next.next=new ListNode(5);
        int n=1;
        q43_removeNthFromEnd q=new q43_removeNthFromEnd();
        q.removeNthFromEnd(l,n);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head != null) {
            stack1.push(head.val);
            head = head.next;
        }
        int count = 0;
        while (!stack1.isEmpty()) {
            count++;
            int cur = stack1.pop();
            if (count == n) {
                continue;
            }
            stack2.push(cur);

        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (!stack2.isEmpty()) {
            cur.next =new ListNode(stack2.pop());
            cur = cur.next;
        }
        return pre.next;
    }
}
