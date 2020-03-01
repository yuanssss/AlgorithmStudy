import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class question3_ArrayList {
    //最初的做法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer>arrayList=new ArrayList<>();
        ArrayList<Integer>out=new ArrayList<>();
        int count=0;
        while (listNode!=null)
        {
            arrayList.add(listNode.val);
            listNode=listNode.next;
            count++;
        }
        for(int i=count-1;i>=0;i--)
        {
            out.add(arrayList.get(i));
        }
        return out;
    }

    //方法2：使用栈内存结构
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer>stack=new Stack<>() ;
        ArrayList<Integer>arrayList=new ArrayList<>();
        while (listNode!=null)
        {
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty())
        {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //方法3：使用递归，ArrayList一定要写到外面

    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead3(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}

 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}