/** Write an alg to print all ways of arranging eight queens on an 8*8 chess board
 *  so that none of them share the same row, column or diagonal. In this case, "diagonal"
 *  means all diagonals, not just the two that bisect the board.
 */
 
//9:10PM

/** I think
 *  Best O(n^2)
 *  do it line by line,
 *  list: available cols, delete cols when they are occupied
 *  diagonal: for col j, col j-1 and j+1 is also not available
 */
 
//n = #of queens
//used_cols is empty 
class Coordinate{
	int row;
	int col;
}
public static void eigthQueens(int[][]board, int n, HashSet<Coordinate> used_cols){
	if(n == 0)
		print(board);
	else{
		int n_prev = n;
		for(int c=0; c<board.length; c++){
			if(!used_cols.contains(new Coordinate(board.length-n, c))){
				board[board.length-n][c] = 1;
				used_cols.add(new Coordinate(board.length-n, c))
				if(n == 0){
					for(int tmp = 0; tmp<board.length; tmp++){//corrected
						used_cols.add(new Coordinate(board.length-n, c+1));
					}
				}else if(n == board.length-1){
					for(int tmp = n; tmp>=0; tmp--){//corrected
						used_cols.add(new Coordinate(board.length-n, c-1));
					}
				}else{
					for(int tmp = 0; tmp<board.length; tmp++){//corrected
						used_cols.add(new Coordinate(board.length-n, c+1));
					}
					for(int tmp = n; tmp>=0; tmp--){//corrected
						used_cols.add(new Coordinate(board.length-n, c-1));
					}
				}
				n--;
			}
			if(n_prev == n)//cannot find a place to place a queen
				return;
			eigthQueens(board, n, used_cols);
		}
	}
}

//9:40pm

/** book solution:
 *  I make a mistake!
 *  the diagonal should be all the coordinates has the same row distance as column distance to a given coordinates
 *  corrected with for loop
 *  but check column if valid is more efficient
 */
//book use a columns[] to store queens position 
private boolean isValid(int[] columns, int row, int col){
	for(int i=0; i<columns.length; i++){
		if(columns[i] == col)
			return false;
		if(Math.abs(columns[i]-col) == Math.abs(row - i))//book check for diagonal
			return false;
	}
	 return true;
}
//book uses a single array columns to store the position of queens

