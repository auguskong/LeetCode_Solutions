/* Recursive BFS search
board[i][j] = "#" mark 

*/
public class Solution {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean res = find(board, i, j, word, 0);
					if (res) {
						return true;
					}
				}
			}
		}
		return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int start) {
        //already find the result
        if (start == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#'; //mark it
        boolean res = find(board, i - 1, j, word, start + 1) 
                                    || find(board, i, j - 1, word, start + 1)
                                    || find(board, i + 1, j, word, start + 1)
                                    || find(board, i, j + 1, word, start + 1);

        //Q: what is this statement used for ?	A: cancel the mark - backtrack					
        board[i][j] = word.charAt(start); 
        return res;
    }
}
