package leetcode;

import MeiTuan.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
 */
public class q35_isSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        List<Integer> list = new LinkedList<>();
        q35_isSymmetric q=new q35_isSymmetric();
        System.out.println(q.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode u=queue.poll();
            TreeNode v=queue.poll();
            if(u==null&&v==null)
            {
                continue;
            }
            if((u==null||v==null)||u.val!=v.val)
            {
             return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }


}
