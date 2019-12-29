## QUESTION
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.

## HINTS
Try thinking about it layer by layer. Rotating a specific layer would just mean swapping the values in four arrays.

## SOLUTION
### Idea
Perform a circular rotation on each layer, moving the top edge to the right, the right edge to the bottom, the bottom edge to the left, and the left edge to the top. Swap index by index.
    for i = 0 to n
      temp = top[i];
      top[i] = left[i];
      left[i] = bottom[i];
      bottom[i] = right[i];
      right[i] = temp;
      
### Code
    boolean rotate(int[][] matrix) {
      if (matrix.length == 0 || matrix.length != matrix[0].length)
        return false;
      int n = matrix.length;
      for (int layer = 0; layer < n / 2; layer++) {
        int first = layer;
        int last = n - 1 - layer;
        for (int i = first; i < last; i++) {
          int offset = i - first;
          int top = matrix[first][i]; // save top
          
          // left -> top
          matrix[first][i] = matrix[last-offset][first];
          
          // bottom -> left
          matrix[last-offset][first] = matrix[last][last-offset];
          
          // right -> bottom
          matrix[last][last-offset] = matrix[i][last];
          
          // top -> right
          matrix[i][last] = top;
        }
      }
      return true;
    }
