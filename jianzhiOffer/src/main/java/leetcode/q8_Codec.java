package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 */
public class q8_Codec {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        q8_Codec q = new q8_Codec();
        String data=q.serialize(treeNode);
        q.deserialize(data);



    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                sb.append(node.val + ",");
                q.add(node.left);
                q.add(node.right);
            } else sb.append("null,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]"))
            return null;
        String[] strs = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.add(root);
        int i=1;
        while (!q.isEmpty()) {
            TreeNode node=q.poll();
            if (!strs[i].equals("null")) {
             node.left=new TreeNode(Integer.parseInt(strs[i]));
             q.add(node.left);
            }
            i++;
            if(!strs[i].equals("null"))
            {
                node.right=new TreeNode(Integer.parseInt(strs[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}
