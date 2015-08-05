import java.io.*;

public class Matrix
{
    //instance variables: row, column, matrix[][]
    int row, col;
    int matrix[][];
    //constructor
    public Matrix(int r, int c)
    {
	      row = r;
	      col = c;
	      matrix = new int[r][c];
    }
    public void loadMatrix()
    {
	     try{
	         System.out.println("Enter values row wise: ");
	         BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
	         int i,j;
	         for(i=0; i<row; i++){
		           for(j=0; j<col; j++){
		               matrix[i][j] = Integer.parseInt(consoleInput.readLine());
		           }
	          }
	       }
	        catch(IOException e){
	           System.out.println("Error");
	        }
    }
    public void printMatrix()
    {
	     int i,j;
	     for(i=0; i<row; i++){
	        for(j=0; j<col; j++){
		          System.out.print(matrix[i][j] + " ");
	        }
	    System.out.println();
	   }
    }
    //Matrix A * Matrix B = Matrix C
    public void calculate(Matrix b, Matrix c)
    {
	      int i, j, k;
	      int sum = 0;
	      for(i=0; i<row; i++){
	         for(j=0; j<b.col; j++){
		           for(k=0; k<col; k++){
		               sum = sum + matrix[i][k] * b.matrix[k][j];
		            }
		            c.matrix[i][j] = sum;
		            sum = 0;
	        }
	      }
    }
    /* Test whether Matrix A and Matrix other can be multiplied.
    The columns of Matrix A must equal the rows of Matrix other */
    public boolean test(Matrix other)
    {
        return col == other.row;
    }
    public String toString()
    {
	     String temp = " Rows: " + row + "\n"
	     + " Columns: " + col;
	    return temp;
    }
}
