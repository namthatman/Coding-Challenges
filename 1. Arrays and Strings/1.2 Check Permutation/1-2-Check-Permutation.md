## QUESTION
Given two strings, write a method to decide if one is a permutation of the other.

## HINTS


## SOLUTIONS
### Assumptions
Assume that the comparision is case sensitive and whitespace is significant. E.g "god   " != "dog".
There are 128 characters in ASCII.

### Ideas
#### Solution #1: Sort the strings
If two strings are permutations, then we know they have the same characters, but in different orders. Therefore, sorting the strings will put the characters from two permutations in the same order. Then compare the sorted versions.

#### Solution #2: Check if the two strings have identical character counts
We can also use the definition of a permutation - two words with the same character counts. Simply iterate through this code, counting how many times each character appears. Then compare the two arrays.

### Codes
#### Solution #1
    String sort(String s) {
      char[] content = s.toCharArray();
      java.util.Arrays.sort(content);
      return new String(content);
    }
    
    boolean permutation(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      return sort(s).equals(sort(t));
    }

#### Solution #2
    boolean permutation(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      
      int[] letters = new int[128];
      
      char[] s_array = s.toCharArray();
      for (char c: s_array) {
        letters[c]++;
      }
      
      char[] t_array = t.toCharArray();
      for (char c: t_array) {
        letters[c]--;
        if (letters[c] < 0) {
          return false;
        }
      }
      
      return true;
    }
