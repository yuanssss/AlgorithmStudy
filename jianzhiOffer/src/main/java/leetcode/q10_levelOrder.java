package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 */
public class q10_levelOrder {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer>al=new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
        TreeNode  node=q.poll();
        if(node!=null)
        {
            al.add(node.val);
            q.add(node.left);
            q.add(node.right);
        }
        }
        int []arrs=new int[al.size()];
        for(int i=0;i<arrs.length;i++)
        {
            arrs[i]=al.get(i);
        }
        return arrs;
    }
}
