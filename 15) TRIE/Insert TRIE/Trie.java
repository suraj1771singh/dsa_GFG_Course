
class Node {
    Node links[];
    Boolean flag;

    Node() {
        links = new Node[26];
        flag = false;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }
}

class Trie {
    static Node root;

    public static void main(String[] args) {
        root = new Node();
        insert("apples");
        insert("apps");
        insert("bat");
        insert("bac");
        System.out.println(search("bac"));
        System.out.println(startsWith("apps"));

    }

    // INSERT
    // TC : O(len)
    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            // Move to the new referance type
            node = node.get(word.charAt(i));
        }
        node.setEnd();

    }

    // SEARCH
    // TC : O(len)
    public static boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node.flag;
    }

    // STARTWITH
    // TC : O(len)
    public static boolean startsWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return true;
    }
}