package AlgorithmAndDataStructureTests.LeetCode.Question68FollowUp3;

import java.util.HashMap;

/**
 * Created by weizhou on 9/21/16.
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }
}
