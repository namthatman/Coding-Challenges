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
