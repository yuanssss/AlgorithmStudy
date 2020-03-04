import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class question5_stack {
    public static void main(String[] args) {
        question5_stack q=new question5_stack();
        q.push(1);
        q.push(2);
        q.pop();
        q.push(3);
        q.push(4);
        q.push(5);
    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        //没有想到这个，假如是mian方法情况，没有这个if就会错误
        if(stack2.empty())
        while (!stack1.empty())
        {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
