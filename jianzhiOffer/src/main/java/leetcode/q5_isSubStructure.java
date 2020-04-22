package leetcode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 *
 *

 */
public class q5_isSubStructure {
    public static void main(String[] args) {
        q5_isSubStructure q = new q5_isSubStructure();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        TreeNode b = new TreeNode(3);
//        b.left = new TreeNode(4);

        System.out.println(q.isSubStructure(a, b));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null) {
            int rootA = A.val;
            int rootB = B.val;
            if (rootA == rootB) {
                result = doesSubStructure(A, B);
            }
            if (result != true)
                result = isSubStructure(A.right, B);
            if (result != true)
                result = isSubStructure(A.left, B);
            
        }

        return result;
    }

    public boolean doesSubStructure(TreeNode a, TreeNode b) {
        if (a == null && b != null) return false;
        if (a != null && b == null) return true;
        if (a.val != b.val) return false;
        return doesSubStructure(a.right, b.right) && doesSubStructure(a.left, b.left);
    }
}
