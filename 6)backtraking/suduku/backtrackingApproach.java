class Solution {
    public void solveSudoku(char[][] board) {
         getSolved(board);
        
    }
    public boolean getSolved(char[][] board){
       for( int i=0 ;i<9;i++ ){
            for( int j=0; j<9; j++){
                
                if(board[i][j]=='.'){
                    for( char c='1' ; c<='9';c++){
                        
                        if(isValid(board,c,i,j)){
                                board[i][j]=c;
                                if(getSolved(board)) return true;
                                else  board[i][j]='.';
                         }
                    }
                    return false;
                }
            }
       }
        return true;

    }
    
    boolean isValid(char[][] board,char c,int row, int col){
        int col1=0;
        int row1=0;
        while(col1<9){
            if(board[row][col1]==c) return false;
            col1++;
            
        }
        while( row1<9){
             if(board[row1][col]==c) return false;
              row1++; 
        }
        
        col1=(col/3)*3;
        row1=(row/3)*3;
        for( int i=row1; i<row1+3;i++){
            for( int j=col1; j<col1+3; j++){
                if(board[i][j]==c) return false;
            }
        }
        return true;
        
    }
}