## QUESTION
String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).

## HINTS
Easy thing first, compress the string, then compare the lengths. Be careful that you are not repeatedly concatenating strings together. This can be very inefficient.

## SOLUTION
### Idea
Iterating through the string, copying characters to a new string and couting the repeats. At each iteration, check if the current character is the same as the next character. If not, add its compressed version to the result.

### Code
    String compress(String str) {
      StringBuilder compressed = new StringBuilder();
      int countConsecutive = 0;
      for (int i = 0; i < str.length(); i++) {
        countConsecutive++;
        
        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
          compressed.append(str.charAt(i));
          compressed.append(countConsecutive);
          countConsecutive = 0;
        }
      }
      return compressed.length() < str.length() ? compressed.toString() : str;
    }
