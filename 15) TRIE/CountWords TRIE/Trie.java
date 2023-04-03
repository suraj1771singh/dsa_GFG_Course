class Node {
    Node links[];
    Boolean flag;
    int cntPrefix;
    int cntEndWith;

    Node() {
        links = new Node[26];
        flag = false;
        cntEndWith = 0;
        cntPrefix = 0;
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
        insert("apples");
        insert("bat");
        insert("bat");
        insert("apps");
        insert("apps");
        System.out.println(countWordsEqualTo("apples"));
        System.out.println(countWordsStartingWith("app"));
        erase("apples");
        System.out.println(countWordsEqualTo("apples"));
        System.out.println(countWordsStartingWith("app"));
        erase("apples");
        System.out.println(countWordsEqualTo("apples"));
        System.out.println(countWordsStartingWith("app"));
        erase("apples");
        // NOTE : still there is bug, if we delete apples more than 2 times
        System.out.println(countWordsEqualTo("apples"));
        System.out.println(countWordsStartingWith("app"));

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
            node.cntPrefix++;
        }
        node.cntEndWith++;

    }

    // COUNT WORDS
    public static int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else
                return 0;
        }
        return node.cntEndWith;

    }

    // COUNT WORDS STARTING WITH
    public static int countWordsStartingWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else
                return 0;
        }
        return node.cntPrefix;
    }

    // DELETE WORDS
    public static void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.cntPrefix--;
            } else
                return;
        }
        node.cntEndWith--;
    }
}
