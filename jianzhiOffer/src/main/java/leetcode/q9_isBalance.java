package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 */
public class q9_isBalance {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        q9_isBalance q=new q9_isBalance();
        System.out.println(q.isBalanced(treeNode));
    }
    public boolean isBalanced(TreeNode root) {
      if (root==null)
          return true;
      boolean result=false;
      int left=deep(root.left);
      int right=deep(root.right);
      if(Math.abs(left-right)<=1)
      {
          result=true;
          if(root.left!=null&&result!=false)
              result=isBalanced(root.left);
          if(root.right!=null&&result!=false)
              result=isBalanced(root.right);
      }
      return result;
    }
    public int deep(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = deep(root.left);
        int right = deep(root.right);
        return Math.max(left, right)+1;
    }
}
