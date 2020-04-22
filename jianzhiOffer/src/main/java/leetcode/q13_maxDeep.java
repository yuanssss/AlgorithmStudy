package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

 */
public class q13_maxDeep {
    //方法一：层序遍历
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            //必须从i=q.size()开始，如果从i=0开始当队列添加左右子树时q.size会发生变化
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                //当ll.size()==1时其实在运行的时第二层
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res++;
        }
        return res;
    }

    //方法二：递归
    public int maxDepth2(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=maxDepth2(root.left);
        int right=maxDepth2(root.right);
        return Math.max(left,right)+1;
    }
}
