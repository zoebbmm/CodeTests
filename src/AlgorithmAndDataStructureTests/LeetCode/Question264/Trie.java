package AlgorithmAndDataStructureTests.LeetCode.Question264;

/**
 * Created by weizhou on 12/7/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c - 'a') == null) curr.setChild(c - 'a', new TrieNode());
            curr = curr.getChild(c - 'a');
        }
        curr.setItem(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c - 'a') == null) return false;
            curr = curr.getChild(c - 'a');
        }
        return curr.getItem().equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.getChild(c - 'a') == null) return false;
            curr = curr.getChild(c - 'a');
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
