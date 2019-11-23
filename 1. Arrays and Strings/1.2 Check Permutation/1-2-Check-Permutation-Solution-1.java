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
