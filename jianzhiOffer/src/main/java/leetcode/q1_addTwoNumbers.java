package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class q1_addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        q1_addTwoNumbers a=new q1_addTwoNumbers();
        ListNode listNode=a.addTwoNumbers(l1,l2);
        while (listNode!=null)
        {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }


    }
    //考虑用队列，但是没完全通过，[9][9]通过不了
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer>queue1=new LinkedList<>();
        Queue<Integer>queue2=new LinkedList<>();
        ArrayList<Integer>al=new ArrayList<>();
        int count1=0;
        int count2=0;
        while(l1!=null)
        {
            queue1.offer(l1.val);
            l1=l1.next;
            count1++;
        }
        while(l2!=null)
        {
            queue2.offer(l2.val);
            l2=l2.next;
            count2++;
        }
        if(count1>count2)
            for(int i=0;i<count1-count2;i++)
            {
                queue2.offer(0);
            }

        if(count1<count2)
            for(int i=0;i<count2-count1;i++)
            {
                queue1.offer(0);
            }


        while(!queue1.isEmpty()||!queue2.isEmpty())
        {
            if(queue1.peek()+queue2.peek()==10)
            {
                al.add(0);
                queue1.poll();
                queue2.poll();
            }
            else
            {
                if(al.size()>0&&al.get(al.size()-1)==0)
                {
                    al.add(queue1.poll()+queue2.poll()+1);
                }

                else
                {
                    al.add(queue1.poll()+queue2.poll());
                }

            }
        }
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        for(int i=0;i<al.size();i++)
        {
            ListNode flag=new ListNode(al.get(i));
            cursor.next=flag;
            cursor=flag;
        }

        return root.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)return null;
        int addOne=0;//addOne为0或者1
        ListNode root=new ListNode(0);
        ListNode dummy=root;
        while (l1!=null||l2!=null||addOne!=0)
        {
            //l1是否为空，如果是返回null，不是返回l1.val
            int l1Val=l1==null?0:l1.val;
            int l2Val=l2==null?0:l2.val;
            int sum=l1Val+l2Val;
            ListNode sumNode=new ListNode(sum%10);
            dummy.next=sumNode;
            dummy=dummy.next;
            addOne/=10;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;

        }
        return root.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}