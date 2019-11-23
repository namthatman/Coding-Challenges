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
