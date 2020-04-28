package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class q14_lowestCommonAncestor {
    public static void main(String[] args) {
        q14_lowestCommonAncestor q14 = new q14_lowestCommonAncestor();
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        q14.lowestCommonAncestor(t, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        /*
        /如果root是null，则说明我们已经找到最底了，返回null表示没找到
         如果root与p相等或者与q相等，则返回root
         如果左子树没找到，递归函数返回null，证明p和q同在root的右侧，那么最终的公共祖先就是右子树找到的结点
         如果右子树没找到，递归函数返回null，证明p和q同在root的左侧，那么最终的公共祖先就是左子树找到的结点
         */
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;

        return root;
    }
}
