package AlgorithmAndDataStructureTests.LeetCode.Question264;

/**
 * Created by weizhou on 12/7/16.
 */
public class TrieNode {
    private final int R = 26;
    private final TrieNode[] children;
    private String item;

    public TrieNode() {
        children = new TrieNode[R];
        item = "";
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public TrieNode getChild(int i) {
        if (i >= 26 || i < 0) throw new IllegalArgumentException();
        return children[i];
    }

    public void setChild(int i, TrieNode node) {
        children[i] = node;
    }
}
