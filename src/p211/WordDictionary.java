package p211;


public class WordDictionary {
	
	TrieNode trieTree = new TrieNode('0');
	public void addWord(String word) {
		if(word==null || word.length()==0) return;
		
		_addWord(trieTree, word);
	}

	private void _addWord(TrieNode node, String word) {
		char c = word.charAt(0);
		if(node.nodes[c-'a'] == null){
			node.nodes[c-'a'] = new TrieNode(c);
		}
		
		if (word.length() == 1) {
			node.nodes[c-'a'].isEnd = true;
			return;
		}
		
		_addWord(node.nodes[c-'a'], word.substring(1));
	}

	public boolean search(String word) {
		if(word == null || word.length()==0) return false;
		
		return _search(this.trieTree, word);
	}
	
	private boolean _search(TrieNode node, String word) {
		char c = word.charAt(0);
		
		if(c=='.'){
			for (TrieNode n : node.nodes) {
				if(n == null) continue;
				if(word.length()==1){
					if(n.isEnd)
						return true;
				}else if(_search(n, word.substring(1))){
					return true;
				}
			}
			return false;
		}
		
		if(node.nodes[c-'a'] == null) return false;
		if(word.length()==1){
			if(node.nodes[c-'a'].isEnd)
				return true;
			else 
				return false;
		}
		return _search(node.nodes[c-'a'], word.substring(1));
	}

	class TrieNode{
		TrieNode[] nodes = new TrieNode[26];
		char value;
		boolean isEnd = false;
		
		public TrieNode(char c) {
			this.value = c;
		}
	}
	
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		 wordDictionary.addWord("word");
		 System.out.println(wordDictionary.search("w.rdu"));
	}
}
