//inplace rotate is achieved by two pointers, use multiple steps to achieve
public class Solution {
	public void reversewords(char[] s) {
		reverse(s, 0, s.length - 1);
		int start = 0;
		int end = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '') {
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}
		reverse(s, start, s.length - 1); 
	}

	public void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
}
