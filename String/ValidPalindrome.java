/**
*
* Type: Two pointers
* Point: only compare alphanumeric characters
*/

class Solution {
    public boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } 
            
            left++;
            right--;
        }
        
        return true;
    }
}