/**
 *  11.6 Given an M*N matrix in which each row and each column is sorted in ascending 
 *  order, write a method to find an element.
 */

class Coord{
	public int x;
	public int y;
} 

//basic idea:
//start with right most corner:
//	if rightmost > x, search in left col 
// 	if < x, search next row
//	while row < M and col >= 0
public Coord findInMatrix(int[][] mat, int M, int N, int element){
	//rightmost
	int row = 0;
	int col = N-1;
	while(row < M-1 && col >=0 ){
		if(mat[row][col] == element) return new Coord(row, col);
		if(mat[row][col] > element) col--;
		else row++;
	}return null;
} 

