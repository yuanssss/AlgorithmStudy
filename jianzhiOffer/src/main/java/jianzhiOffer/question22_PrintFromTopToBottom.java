package jianzhiOffer;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class question22_PrintFromTopToBottom {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //利用队列作为辅助存储
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root==null)
            return arrayList;
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            arrayList.add(temp.val);
        }
        return arrayList;
    }


}
