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
