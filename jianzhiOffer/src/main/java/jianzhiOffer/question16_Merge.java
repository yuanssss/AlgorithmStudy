package jianzhiOffer;/*
输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。
 */

public class question16_Merge {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(7);
        listNode2.next.next = new ListNode(10);
        Merge2(listNode1, listNode2);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
    //一图胜千言
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode res = null;
        if(list1.val<list2.val){
            res = list1;
            res.next = Merge(list1.next, list2);
        }else{
            res = list2;
            res.next = Merge(list1, list2.next);
        }
        return res;
    }

    /**
     * 比较两个链表的首结点，哪个小的的结点则合并到第三个链表尾结点，并向前移动一个结点。
     * 步骤一结果会有一个链表先遍历结束，或者没有
     * 第三个链表尾结点指向剩余未遍历结束的链表
     * 返回第三个链表首结点
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1, ListNode list2) {
//新建一个头节点，用来存合并的链表。
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root = head;//存放合并的链表
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = list1;//head相当于root的临时指针，比如 root：1-2-7-10 head：2-7-10，head就是root的第二个指针
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return root.next;
    }
}
