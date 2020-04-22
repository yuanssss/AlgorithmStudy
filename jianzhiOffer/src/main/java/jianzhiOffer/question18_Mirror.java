package jianzhiOffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class question18_Mirror {


    /**

     *
     * 我们或许还记得递归的终极思想是数学归纳法，我们思考递归的时候一定不要去一步一步看它执行了啥，只会更绕。
     * 我们牢牢记住，思考的方式是我们首先假设子问题都已经完美处理，我只需要处理一下最终的问题即可，子问题的处理方式与最终那个处理方式一样，
     * 但是问题规模一定要以1的进制缩小。最后给一个递归出口条件即可。
     *
     * 对于本题，首先假设root的左右子树已经都处理好了，即左子树自身已经镜像了，右子树自身也镜像了，
     * 那么最后一步就是交换左右子树，问题解决。所以我只需要将root.left和root.right交换即可。
     * 下面进入递归，就是处理子问题。子问题的处理方式与root一样，只是要缩小问题规模，
     * 所以只需要考虑root.left是什么情况，root.right是什么情况即可
     * @param root
     */
    public void Mirror(TreeNode root) {
        reverseTree(root);
    }

    public void reverseTree(TreeNode root) {
        if(root==null)
        {
            return;
        }
        swap(root);
        reverseTree(root.left);
        reverseTree(root.right);
    }
    public void swap(TreeNode root)
    {
        TreeNode temp=null;
        temp=root.right;
        root.right=root.left;
        root.left=temp;
    }


    public void Mirror2(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;

        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;

        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

}
