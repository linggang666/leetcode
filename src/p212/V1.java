package p212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		if(board.length==0 || board[0].length==0 || words.length==0)
			return res;
		
		TrieNode root = new TrieNode('*');
		for (String word:words) {
			buildTrie(root, word);
		}
		
		int rows = board.length, cols = board[0].length;
		boolean[][] flags = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				traverse(i, j, board, root, res, flags);
			}
		}
        return res;
    }
	
	private void traverse(int i, int j, char[][] board, TrieNode trie, List<String> res, boolean[][] flags) {
		if(i<0 || 
				i>=board.length || 
				j<0 ||
				j>=board[0].length || 
				flags[i][j] ||
				trie.sub[board[i][j]-'a'] == null){
			return;
		}
		
		char c = board[i][j];
		if(trie.sub[c-'a'].isEnd){
			res.add(trie.sub[c-'a'].word);
			trie.sub[c-'a'].isEnd = false;
		}
		
		flags[i][j] = true;
		traverse(i-1, j, board, trie.sub[c-'a'], res, flags);
		traverse(i+1, j, board, trie.sub[c-'a'], res, flags);
		traverse(i, j-1, board, trie.sub[c-'a'], res, flags);
		traverse(i, j+1, board, trie.sub[c-'a'], res, flags);
		flags[i][j] = false;
	}

	private void buildTrie(TrieNode root, String word) {
		if(word == null || word.length()==0) 
			return;
		
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(temp.sub[c-'a'] == null){
				temp.sub[c-'a'] = new TrieNode(c);
			}
			temp = temp.sub[c-'a'];
		}
		temp.isEnd = true;
		temp.word = word;
	}

	class TrieNode{
		boolean isEnd = false;
		char val;
		String word;
		TrieNode[] sub;
		public TrieNode(char val) {
			this.val = val;
			this.sub = new TrieNode[26];
		}
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		String[] words = {"benda","besan","bend"};
		char[][] board = {
				{'a','b','c','d'},
				{'h','e','a','j'},
				{'o','s','g','f'},
				{'w','c','y','k'},
				
		};
		
		char[][] a = {
				{'s','e','e','n','e','w'},	
				{'t','m','r','i','v','a'},	
				{'o','b','s','i','b','d'},	
				{'w','m','y','s','e','n'},	
				{'l','t','s','n','s','a'},	
				{'i','e','z','l','g','n'}	
		};
		List<String> list = v.findWords(a, words);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
