package leetcode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 */
public class q6_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        swap(root);
        if (root.right != null)
            mirrorTree(root.right);
        if (root.left != null)
            mirrorTree(root.left);
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
