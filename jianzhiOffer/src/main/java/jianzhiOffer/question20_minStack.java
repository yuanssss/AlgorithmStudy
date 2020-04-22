package jianzhiOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *

 *
 * 解题思路：
 * 我们可以设计两个栈：StackDate和StackMin，一个就是普通的栈，另外一个存储push进来的最小值。
 *
 * 首先是push操作：
 * 每次压入的数据newNum都push进StackDate中，然后判断StackMin是否为空，如果为空那也把newNum同步压入 StackMin里；如果不为空，就先比较newNum和StackMin中栈顶元素的大小，如果newNum较大，那就不压入StackMin里，否则 就同步压入StackMin里。如：
 *
 *
 * 接着是pop操作
 * 先将StackDate中取出的数据value与StackMin的栈顶元素比较，因为对应push操作，value不可能小于 StackMin中的栈顶元素，最多是相等。如果相等，那么StackMin中也取出数据，同时返回value，否则只是返回value就可以了。
 *
 * 最后是getMin操作
 * 1
 * 由上就可知，StackMin中存储的数据就是当前最小的，所以只要返回StackMin中的栈顶元素就可以了。
 */
public class question20_minStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    Integer tmp = null;

    public void push(int node) {
        data.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else if (node <= min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        if (data.isEmpty())
            return;
        else if(min.peek()==data.peek())
        {
            min.pop();
        }
        data.pop();

    }

    public int top() {
        if (data.isEmpty())
            throw new RuntimeException();
        else if(min.peek()==data.peek())
        {
            min.pop();
        }
      return   data.pop();
    }

    public int min() {
        return min.peek();
    }
}
