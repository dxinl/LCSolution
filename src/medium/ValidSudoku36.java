package medium;

public class ValidSudoku36 {
    public static void main(String[] args) {
        System.out.println(new ValidSudoku36().isValidSudoku(new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        char[][] found1 = new char[9][9];
        char[][] found2 = new char[9][9];
        char[][] found3 = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int index = board[i][j] - '0';
                if (found1[i][index - 1] == 'x')
                    return false;
                else
                    found1[i][index - 1] = 'x';

                if (found2[index - 1][j] == 'x')
                    return false;
                else
                    found2[index - 1][j] = 'x';

                int row = (index - 1) / 3;
                int column = index - 1 - row * 3;
                row += (i > 5 ? 6 : (i > 2 ? 3 : 0));
                column += (j > 5 ? 6 : (j > 2 ? 3 : 0));
                if (found3[row][column] == 'x')
                    return false;
                else
                    found3[row][column] = 'x';
            }
        }
        return true;
    }
}
