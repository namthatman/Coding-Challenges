# QUESTION
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the 'true' length of the string. You cannot use additional string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
Example:
Input:  "Mr John Smith    ", 13
Output: "Mr%20John%20Smith"

# HINTS
It's often easiest to modify strings by going from the end of the string to the beginning.
You might find you need to know the number of spaces.

# SOLUTION
## Ideas
Two-scan approach. In the first scan, we count the number of spaces. By tripling this number, we can compute how many extra characters we will have in the final string. In the second pass, which is done in reverse other, we actually edit the string. When we see a space, we replace it with %20. If there is no space, then we copy the original character.

## Codes
    void replaceSpaces(char[] str, int trueLength) {
      int spaceCount = 0, index, i = 0;
      
      for (i = 0; i < trueLength; i++) {
        if (str[i] == ' ') {
          spaceCount++;
        }
      }
      
      index = trueLength + spaceCount * 2;
      if (trueLength < str.length) str[trueLength] = '\0'; // End array
      for (i = trueLength - 1; i >= 0; i--) {
        if (str[i] == ' ') {
          str[index - 1] = '0';
          str[index - 2] = '2';
          str[index - 3] = '%';
          index = index - 3;
        } else {
          str[index - 1] = str[i];
          index--;
        }
      }
    }
