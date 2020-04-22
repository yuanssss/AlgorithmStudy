package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class q11_levelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ll = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null)
        q.add(root);
        while (!q.isEmpty()) {
            LinkedList<Integer>l=new LinkedList<>();
            //必须从i=q.size()开始，如果从i=0开始当队列添加左右子树时q.size会发生变化
            for(int i=q.size();i>0;i--)
            {
                TreeNode node=q.poll();
                //当ll.size()==1时其实在运行的时第二层
                if(ll.size()%2==0)l.addFirst(node.val);//奇数层
                else l.addLast(node.val);//偶数层
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            ll.add(l);
        }
        return ll;
    }


}
