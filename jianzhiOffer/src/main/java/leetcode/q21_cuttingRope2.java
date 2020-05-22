package leetcode;
/*

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class q21_cuttingRope2 {
    public static void main(String[] args) {
        q21_cuttingRope2 q=new q21_cuttingRope2();
        int a=q.cuttingRope(10);
        System.out.println(a);
    }
    public int cuttingRope(int n) {
        int[]dp=new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
