package leetcode;

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


 */
public class q31_numsTree {
    public static void main(String[] args) {
        q31_numsTree q=new q31_numsTree();
        int a=q.numTrees(6);
        System.out.println(a);
    }


/*
巧妙之处在于，我们可以将 [1,2] 构建不同左子树的数量表示为 G(2)G(2),
从 [4, 5, 6, 7]` 构建不同右子树的数量表示为 G(4)G(4)。这是由于 G(n)G(n)
和序列的内容无关，只和序列的长度有关。
于是，F(3,7) = G(2)*G(4)



 */
    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        } else {


            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            if (n > 2) {
                for (int i = 3; i <= n; i++) {
                    for (int j = 1; j <= i; j++) {
                        int max = Max(j, i);
                        int min = Min(j, i);
                        if (min == 1) {
                            dp[i] = dp[max] + dp[i];
                        } else if (max == 1) {
                            dp[i] = dp[min] + dp[i];
                        } else {
                            dp[i] += dp[max] * dp[min];//应该是笛卡尔积而不是和
                        }
                    }
                }
            }
            return dp[n];
        }
    }

    public int Max(int j, int i) {
        int count = 0;
        for (int k = 1; k <= i; k++) {
            if (j < k) {
                count++;
            }
        }
        return count;
    }

    public int Min(int j, int i) {
        int count = 0;
        for (int k = 1; k <= i; k++) {
            if (k < j) {
                count++;
            }
        }
        return count;
    }
}
