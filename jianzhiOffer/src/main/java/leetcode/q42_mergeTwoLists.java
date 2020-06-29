package leetcode;


/*

将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class q42_mergeTwoLists {
    public static void main(String[] args) {
        q42_mergeTwoLists q=new q42_mergeTwoLists();
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(4);
        ListNode node2=new ListNode(1);
        node2.next=new ListNode(3);
        node2.next.next=new ListNode(4);
        ListNode n=q.mergeTwoLists(node1,node2);
        while (n!=null)
        {
            System.out.println(n.val);
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevpre=new ListNode(-1);
        ListNode pre=prevpre;
        while (l1!=null&&l2!=null)
        {
            if(l1.val>l2.val)
            {
                pre.next=l2;
                l2=l2.next;
            }
            else {
                pre.next=l1;
                l1=l1.next;
            }
            pre=pre.next;
        }

        return prevpre.next;
    }
}
