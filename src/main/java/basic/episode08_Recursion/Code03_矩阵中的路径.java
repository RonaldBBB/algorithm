package basic.episode08_Recursion;


/**
 * @author: zyf
 * @date: 2021/6/20 21:33
 * @description: offer12 leetcode79 回溯体现在重置visited和重置index
 */
public class Code03_矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[0] == board[i][j]) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j]=true;
                    if (exist(board, chars, i, j, 1, visited)) return true;
                }
            }
        }
        return false;
    }

    // 回溯 长度限制为chars.length
    // index表示下一个需要匹配的字符在chars中的位置
    public boolean exist(char[][] board, char[] chars, int i, int j, int index, boolean[][] visited) {
        if (index == chars.length) return true;
        int m = board.length;
        int n = board[0].length;
        if (i + 1 < m && !visited[i + 1][j] && board[i + 1][j] == chars[index]) {
            visited[i + 1][j] = true;
            if (exist(board, chars, i + 1, j, index + 1, visited)) return true;
            visited[i + 1][j] = false;
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && board[i - 1][j] == chars[index]) {
            visited[i - 1][j] = true;
            if (exist(board, chars, i - 1, j, index + 1, visited)) return true;
            visited[i - 1][j] = false;
        }
        if (j + 1 < n && !visited[i][j + 1] && board[i][j + 1] == chars[index]) {
            visited[i][j + 1] = true;
            if (exist(board, chars, i, j + 1, index + 1, visited)) return true;
            visited[i][j + 1] = false;
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && board[i][j - 1] == chars[index]) {
            visited[i][j - 1] = true;
            if (exist(board, chars, i, j - 1, index + 1, visited)) return true;
            visited[i][j - 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {

/*        System.out.println(
                new Code03_矩阵中的路径().
                        exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));*/

        System.out.println(new Code03_矩阵中的路径().exist(new char[][]{{'a', 'a'}}, "aaa"));
    }
}
