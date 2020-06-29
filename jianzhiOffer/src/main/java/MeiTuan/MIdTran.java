package MeiTuan;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MIdTran {
    public static void main(String[] args) {
      TreeNode root=new TreeNode(1);
        root.left=new TreeNode(4);
        root.right=new TreeNode(2);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(7);
        InOrder(root);
    }
    public static void InOrder(TreeNode root) {
        if(root==null)return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;//辅助节点
        stk.add(p);
        while(!stk.isEmpty()) {
            //只要你有左孩子，就将左孩子压入栈中
            if(p!=null &&  p.left!=null) {
                stk.add(p.left);
                p = p.left;
            }else {
                p = stk.pop();//弹出栈顶节点  左孩子--->根节点
                System.out.print(p.val+" ");
                if(p!=null && p.right!=null) {//如果栈点元素有右孩子的话，将有节点压入栈中
                    stk.add(p.right);
                    p = p.right;
                }else
                {
                    p = null;//p=stk.pop;已经访问过p了，p设置为null
                }
            }
        }
    }

    public List<Integer>inOrder2(TreeNode root)
    {
        List<Integer>list=new LinkedList<>();
        if(root==null)
        {
            return null;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode p=root;
        stack.push(p);
        while (!stack.isEmpty())
        {
            if(p!=null&&p.left!=null)
            {
                stack.push(p.left);
                p=p.left;
            }
            else
            {
                list.add(p.val);
                p=stack.pop();
                if(p!=null&&p.right!=null)
                {
                    stack.push(p.right);
                    p=p.right;
                }
                else
                {
                    p=null;
                }
            }
        }
        return list;
    }




}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}