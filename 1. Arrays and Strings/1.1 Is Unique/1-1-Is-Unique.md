## QUESTION
Is Unique: Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?

## HINTS
Try a hash table
Could a bit vector be useful?
Can you solve it in O(N log N) time?
  
## SOLUTION
### Assumptions
128 characters in ASCII alphabet.

### Ideas
Create an array of boolean values, where the flag at index i indicates whether character i in the alphabet is contained in the string.
The second time you see this character you can immediately return false. Also, return false if the string length exceeds 128 characters.

### Codes
    boolean isUniqueChars(String str) {
      if (str.length() > 128) return false;
      boolean[] char_set = new boolean[128];
      for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (char_set[val]) {
          return false;
        }
        char_set[val] = true;
      }
      return true;
    }

