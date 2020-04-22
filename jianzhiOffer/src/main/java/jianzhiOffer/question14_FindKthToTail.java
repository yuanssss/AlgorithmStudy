package jianzhiOffer;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class question14_FindKthToTail {

    public ListNode2 FindKthToTail(ListNode2 head,int k) {
        Stack<ListNode2> stack=new Stack();
        while (head!=null)
        {
            stack.push(head);
            head=head.next;
        }
        for(int i=0;i<k-1;i++)
        {
            stack.pop();
        }
        //链表长度为5，k>5的情况，一开始没想到
        if(stack.isEmpty())
        {
            return null;
        }
        return  stack.pop();
    }



    public ListNode2 FindKthToTail2(ListNode2 head,int k) { //5,{1,2,3,4,5}
        ListNode2 p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}

class ListNode2 {
    int val;
    ListNode2 next = null;
    ListNode2(int val) {
        this.val = val;
    }
}