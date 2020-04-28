package leetcode;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class q17_maxValue {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++) {
                if(i==0&&j==0)continue;//避免了j-1的数组越界，continue是跳出本次循环进行再一次循环
                if(i==0)grid[i][j]+=grid[i][j-1];
                if(j==0)grid[i][j]+=grid[i-1][j];
                else grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[n-1][m-1];
    }
}
