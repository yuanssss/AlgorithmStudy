package leetcode;

import MeiTuan.Tree;

import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

输入:
    2
   / \
  1   3
输出: true

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

 */
public class q27_isValidBST {
    public static void main(String[] args) {
        q27_isValidBST q=new q27_isValidBST();
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(20);
        List<Integer>node=new LinkedList<>();
        q.midTrans(root,node);
        for(Integer list:node)
        {
            System.out.println(list);
        }
    }
    //二叉搜索树的右子树所有结点必须大于根节点，即中序遍历必须是单调递增
    //如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
    // 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。

    public boolean isValidBST(TreeNode root) {
        List<Integer>node=new LinkedList<>();
        midTrans(root,node);
        for(int i=1;i<node.size();i++)
        {
            if(node.get(i)<=node.get(i-1))
            {
                return false;
            }
        }
        return true;

    }
    public List<Integer>midTrans(TreeNode root,List<Integer>node)
    {
        if(root==null)
        {
            return node;
        }
        midTrans(root.left,node);
        node.add(root.val);
        midTrans(root.right,node);
        return node;
    }
}
