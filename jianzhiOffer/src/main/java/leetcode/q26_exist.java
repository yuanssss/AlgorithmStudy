package leetcode;

/*

给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

 */
public class q26_exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (bfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(char[][] board, int i, int j, char[] word, int k) {
        if (k == word.length) return true;
        if (i < 0 || i > board.length || j < 0 || j > board[i].length || board[i][j] != word[k])
            return false;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = bfs(board, i - 1, j, word, k + 1) || bfs(board, i + 1, j, word, k + 1) ||
                bfs(board, i, j - 1, word, k + 1) || bfs(board, i, j + 1, word, k + 1);
        board[i][j] = temp;
        return res;
    }
}
