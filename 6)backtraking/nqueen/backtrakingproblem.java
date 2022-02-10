import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtrakingproblem {
    public static void main(String[] args) {
        int n = 9;
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        getnqueen(ans, board, n, 0);

    }

    public static void getnqueen(List<List<String>> ans, char[][] board, int n, int col) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board)
                list.add(new String(row));
            ans.add(list);
        }
        for (int row = 0; row < n; row++) {
            if (isMoveValid(board, row, col,n)) {
                board[row][col] = 'q';
                getnqueen(ans, board, n, col + 1);
                board[row][col] = '.';
            }
        }
    }

   public  static boolean isMoveValid(char[][] board, int row, int col,int n) {
         // check upper diagonal
         int duprow = row;
         int dupcol = col; 
         
         while(row >= 0 && col >= 0) {
             if(board[row][col] == 'Q') return false;
             row--;
             col--;
         }
         
         
         col = dupcol; 
         row = duprow;
         while(col>=0) {
             if(board[row][col] == 'Q') return false;
             col--; 
         }
     
         row = duprow;
         col = dupcol; 
         while(row<n && col>=0) {
             if(board[row][col] == 'Q') return false;
             row++;
             col--; 
         }
         
         return true; 

    }

}
