import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class question24_FindPath {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(1);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(1);
        treeNode.right.left=new TreeNode(1);
        treeNode.right.right=new TreeNode(1);
        question24_FindPath question24_findPath=new question24_FindPath();
        System.out.println(question24_findPath.FindPath(treeNode,3));
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        //回退操作
        list.remove(list.size()-1);
        return listAll;
    }



        public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
            ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
            if(root==null)return paths;
            find(paths,new ArrayList<Integer>(),root,target);
            return paths;
        }
        public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
            path.add(root.val);
            if(root.left==null&&root.right==null){
                if(target==root.val){
                    paths.add(path);
                }
                return;
            }
            //当时考虑到了但是不知道怎么写
            ArrayList<Integer> path2=new ArrayList<>();
            path2.addAll(path);
            //减法作为参数，起到了回退的效果
            if(root.left!=null)find(paths,path,root.left,target-root.val);
            if(root.right!=null)find(paths,path2,root.right,target-root.val);
        }
    }


