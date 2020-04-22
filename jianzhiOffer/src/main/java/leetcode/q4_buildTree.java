package leetcode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 */
public class q4_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
        {
            return null;
        }
        if(preorder.length==1)
        {
            return new TreeNode(preorder[0]);
        }
        TreeNode treeNode=new TreeNode(preorder[0]);
        int root = preorder[0];
        int inFlag = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                inFlag = i;
            }
        }
        //左子树
        treeNode.left=buildTree(Arrays.copyOfRange(preorder,1,inFlag+1), Arrays.copyOfRange(inorder, 0, inFlag));
        //右子树
        treeNode.right=buildTree(Arrays.copyOfRange(preorder,inFlag+1,preorder.length), Arrays.copyOfRange(inorder, inFlag + 1, inorder.length));
        return treeNode;
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
