package AlgorithmAndDataStructureTests.LeetCode.Question237FollowUp2;

/**
 * Created by weizhou on 10/10/16.
 */
public class Node {
    Node[] nodes;
    boolean isWord;

    Node() {
        nodes = new Node[26];
        isWord = false;
    }

    void add(String str) { // add a word to Trie
        if (str.length() == 0) isWord = true; // end of a word
        else {
            int idx = str.charAt(0) - 'a'; // insert a new node
            if (nodes[idx] == null) nodes[idx] = new Node();
            nodes[idx].add(str.substring(1));
        }
    }

    boolean isAbbr(String abbr, int num) {
        if (num > 0) { // number of '*'
            for (Node node : nodes) {
                if (node != null && node.isAbbr(abbr, num - 1)) return true;
            }
            return false; // not exist in the dictionary
        } else {
            if (abbr.length() == 0) return isWord; // at the end of the addr
            int idx = 0; // get the number of '*' at the start of the abbr
            while (idx < abbr.length() && abbr.charAt(idx) >= '0' && abbr.charAt(idx) <= '9') {
                num = (num * 10) + (abbr.charAt(idx++) - '0');
            }
            if (num > 0) return isAbbr(abbr.substring(idx), num); // start with number
            else { // start with non-number
                if (nodes[abbr.charAt(0) - 'a'] != null)
                    return nodes[abbr.charAt(0) - 'a'].isAbbr(abbr.substring(1), 0);
                else return false; // not exist in the dictionary
            }
        }
    }
}
