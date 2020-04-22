package jianzhiOffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class question4_binaryTree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        reConstructBinaryTree(pre, in);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        if(pre.length==1)
        {
            return new TreeNode(pre[0]);
        }
        //上面两个递归终止条件没有考虑到
        TreeNode treeNode=new TreeNode(pre[0]);
        int flag = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                flag=i;
                break;
            }

        }
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间,之前不知道有这个方法走了很多弯路子
        treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,flag+1),Arrays.copyOfRange(in,0,flag));
        treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,flag+1,pre.length),Arrays.copyOfRange(in,flag+1,in.length));
        return treeNode;
    }

    //大神做法

    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree2(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree2(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                //i-startIn是左子树结点的个数，即左子树的长度，startPre+（i-startIn）为新左子树的endPre
                root.left=reConstructBinaryTree2(pre,startPre+1,startPre+(i-startIn),in,startIn,i-1);
                root.right=reConstructBinaryTree2(pre,startPre+(i-startIn)+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
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
