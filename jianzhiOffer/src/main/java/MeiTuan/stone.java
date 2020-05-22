package MeiTuan;

import java.util.Scanner;

/*
沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，
且不存在两个石头有相同的半径。为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
问最少需要操作多少次才能将这n个石头的半径变成升序？

5
4 1 2 5 3
 */
public class stone {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int nums=cin.nextInt();
        int[]arrays=new int[nums];
        for(int i=0;i<arrays.length;i++)
        {
            arrays[i]=cin.nextInt();
            System.out.println(arrays[i]);
        }
//        stone s=new stone();
//        System.out.println(s.stoneSlove(nums,arrays));
    }

    public int stoneSlove(int nums,int[]arrays)
    {
        int []dp=new int[nums];
        dp[0]=0;
        for(int i=1;i<arrays.length;i++)
        {
            if(arrays[i]>arrays[i-1])
            {
                dp[i]=dp[i-1];
            }
            else
            {
                dp[i]=dp[i-1]+1;
            }
        }
        return dp[nums-1];
    }
}
