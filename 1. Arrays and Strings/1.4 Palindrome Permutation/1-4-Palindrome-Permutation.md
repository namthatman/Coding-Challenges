## QUESTION
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that us the same forwards and backwards. A permutation is a rerrangement of letters. The palindrome does not need to limited to just dictionary words.

Example:

Input:   Tact Coa

Output:  True (permutations: "taco cat", "atco cta", etc.)


## HINTS
You do not have to--and should not--generate all permutations. This would be very inefficient.
What characteristics would a string that is a permutation of a palindrome have?
Have you tried a hash table? You should be able to get this down to O(N) time.
Can you reduce the space usage by using a bit vector?


## SOLUTIONS
What does it take to be able to write a set of characters the same way forwards and backwards (palindrome)? We need to have an even number of almost all characters, so that half can be on one side and half can be on the other side. At most one character (the middle character) can have an odd count.


### Assumption
There are 128 characters in ASCII alphabet. (Or 27 characters in English alphabet)


### Ideas
#### Solution #1: Hash table
We use a has table to count* how many times each character appears (count*: first appearance=+1, second appearance=-1, third appearance=+1, so on. We will have 1 value if that character appears odd times, and 0 value if that character appears even times or do not even appear). Then, we sum up the hash table and ensure that the total sum is can only be 0 or 1, otherwise return false.

#### Solution #2: Bit vector (more space efficient)
We can use a single integer (as a bit vector). When we see a letter, we map it to an integer between 0 and 26 (assuming an English alphabet). Then we toggle the bit at that value. At the end of the iteration, we check that at most one bit in the integer is set to 1.

We can easily check that no bits in the integer are 1: just compare the integer to 0. There is actually a very elegant way to check that an integer has exactly one bit set to 1.

E.g. an integer like 00010000. If we subtract 1 from the number, we'll get 00001111. We can check to see that a number has exactly one 1 because if we subtract 1 from it and then AND it with the new number, we should get 0.

00010000 - 1 = 00001111

00010000 & 00001111 = 0


### Codes
#### Solution #1:
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
   
#### Solution #1:
    boolean is PermutationOfPalindrome(String phrase) {
      int bitVector = createBitVector(phrase);
      return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }
    
    
    int createBitVector(String phrase) {
      int bitVector = 0;
      for (char c : phrase.toCharArray()) {
        int x = getCharNumber(c);
        bitVector = toggle(bitVector, x);
      }
      return bitVector;
    }
    
    
    int toggle(int bitVector, int index) {
      if (index < 0) return bitVector;
      
      int mask = 1 << index;
      if ((bitVector & mask) == 0) {
        bitVector |= mask;
      } else {
        bitVector &= ~mask;
      }
      return bitVector;
    }
    
    
    boolean checkExactlyOneBitSet(int bitVector) {
      return (bitVector & (bitVector - 1) == 0;
    }

        
      
