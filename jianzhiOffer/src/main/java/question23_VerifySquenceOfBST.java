import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 什么是二叉查找树：
 * 根节点的值大于其左子树中任意一个节点的值，小于其右节点中任意一节点的值，这一规则适用于二叉查找树中的每一个节点。
 */
public class question23_VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        question23_VerifySquenceOfBST question23_verifySquenceOfBST = new question23_VerifySquenceOfBST();
        boolean a = question23_verifySquenceOfBST.VerifySquenceOfBST(arr);
        System.out.println(a);


    }

    /**
     * si路：
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     * 1、确定root；
     * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     * 3、已知左侧的树小于根节点,遍历右子树，若发现有小于root的值，则直接返回false；
     * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        //防止数组越界
        if ( start>=end )
            return true;
        int root=sequence[end];
        int i=start;
        while (sequence[i]<root)
        {
            i++;
        }
        for(int a=i;a<end;a++)
        {
            if(sequence[a]<root)
            {
                return false;
            }
        }
        //注意i-1和end-1
        boolean left=VerifySquenceOfBST(sequence,0,i-1);
        boolean right=VerifySquenceOfBST(sequence,i,end-1);
        return left&&right;
    }
}
