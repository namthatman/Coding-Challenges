## QUESTION
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

## HINTS
Try not to clear the whole matrix. Try finding the cells with zeros first before making any changes to the matrix.

## SOLUTION
### Idea
At first glance, this problem seems easy: just iterate through the matrix and everytime we see a cell with value zero, set its row and column to 0. There is one problem with that solution though: when we come across other cells in that row or column, we will se the zeros and change their row and column to zero. Pretty soon, our entire matrix will be set to zeros.

One way around this is to keep a second matrix which flags the zero locations. We would then do a second pass through the matrix to set the zeros.

### Code
    void setZeros(int[][] matrix) {
      boolean[] row = new boolean[matrix.length];
      boolean[] column = new boolean[matrix[0].length];
      
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
          if (matrix[i][j] = 0) {
            row[i] = true;
            column[j] = true;
          }
        }
      }
      
      for (int i = 0; i < row.length; i++) {
        if (row[i]) {
          for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
          }
        }
      }
      
      for (int j = 0; j < column.length; j++) {
        if (column[j]) {
          for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
          }
        }
      }
    }
