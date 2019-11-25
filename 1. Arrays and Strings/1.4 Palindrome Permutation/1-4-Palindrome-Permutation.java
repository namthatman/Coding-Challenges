boolean is PermutationOfPalindrome(String phrase) {
  int[] letters = new int[128];
  
  for (char c : phrase.toCharArray()) {
    if (letters[c] == 0) {
      letters[c]++;
    } else {
      letters[c]--;
  
  int sum = 0;
  for (int value : letters) {
    sum += value;
  }
  
  return sum <= 1;
