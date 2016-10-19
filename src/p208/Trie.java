package p208;

class TrieNode {
	
	TrieNode[] nodes = new TrieNode[26];
	boolean isEnd = false;
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        _insert(root, word);
    }
    
    private void _insert(TrieNode node, String word) {
    		if(word == null || word.length() == 0) return;
    		
    		char c = word.charAt(0);
    		if(node.nodes[c-'a'] == null){
    			node.nodes[c-'a'] = new TrieNode();
    		}
    		if(word.length() == 1){
    			node.nodes[c-'a'].isEnd = true;
    		}else{
    			_insert(node.nodes[c-'a'], word.substring(1));
    		}
    		
	}

	// Returns if the word is in the trie.
    public boolean search(String word) {
         return _search(root, word);
    }

    private boolean  _search(TrieNode node, String word) {
    		if(word == null || word.length()==0) return false;
    		
    		char c = word.charAt(0);
    		if(node.nodes[c-'a'] == null){
    			return false;
    		}
    		if(word.length() == 1 && node.nodes[c-'a'].isEnd){
    			return true;
    		}
    		return _search(node.nodes[c-'a'], word.substring(1));
	}

	// Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return _startsWith(root, prefix);
    }

	private boolean _startsWith(TrieNode node, String prefix) {
		if(prefix == null || prefix.length()==0) return false;
		
		char c=prefix.charAt(0);
		if(node.nodes[c-'a'] == null){
			return false;
		}
		if(prefix.length() == 1){
			return true;
		}
		return _startsWith(node.nodes[c-'a'], prefix.substring(1));
	}
	
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		System.out.println(trie.startsWith("hell"));
	}
}