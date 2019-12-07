## QUESTION
One Away: There are three types of edits that can be perfomed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

    Example:
    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pale, bae -> false
    
## HINTS
Can you check each of the conditions separately? What is the relationship between insertion and removal?

## SOLUTIONS
### Ideas
Replacement: Consider two strings, such as bale and pale, that are one replacement away. Yes, that does mean that you could replace a character in bale to make pale. But more precisely, it means that they are different only in one place.

Insertion: The strings apple and aple are one insertion away. This means that if you compared the strings, they would be identical -except for the shift at some point in the strings.

Removal: The strings apple and aple are also one removal away, since removal is just the inverse of insertion.

#### Solution #1: Two steps checking
Merge the insertion and removal check into one step, and check the replacement step separately.

#### Solution #2: All-in-one step checking
Merge all of them into one method.

### Codes
#### Solution #1:
    boolean oneEditAway(String first, String second) {
      if (first.length() == second.length()) {
        return oneEditReplace(first, second);
      } else if (first.length() + 1 == second.length()) {
        return oneEditInsert(first, second);
      } else if (first.length() - 1 == second.length()) {
        return oneEditInsert(second, first);
      }
      return false;
    }
    
    boolean oneEditReplace(String s1, String s2) {
      boolean foundDifference = false;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          if (foundDifference) {
            return false;
          }
          foundDifference = true;
        }
      }
      return true;
    }
    
    boolean oneEditInsert(String s1, String s2) {
      int index1 = 0;
      int index2 = 0;
      while (index2 < s2.length() && index1 < s1.length()) {
        if (s1.charAt(index1) != s2.charAt(index2)) {
          if (index1 != index2) {
            return false;
          }
          index2++;
        } else {
          index1++;
          index2++;
        }
      }
      return true;
    }

#### Solution #2:
    boolean oneEditAway(String first, String second) {
      if (Math.abs(first.length() - second.length()) > 1) {
        return false;
      }
      
      String s1 = first.length() < second.length() ? first : second;
      String s2 = first.length() < second.length() ? second : first;
      
      int index1 = 0;
      int index2 = 0;
      boolean foundDifference = false;
      while (index2 < s2.length() && index1 < s1.length()) {
        if (s1.charAt(index1) != s2.charAt(index2)) {
          if (foundDifference) return false;
          foundDifference = true;
          
          if (s1.length() == s2.length()) { // On replace, move shorter pointer
            index1++;
          }
        } else {
          index1++; // If matching, move shorter pointer
        }
        index2++; // Always move pointer for longer string
      }
      return true;
    }
      
