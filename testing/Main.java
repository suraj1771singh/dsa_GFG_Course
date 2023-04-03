import java.util.HashSet;

class Node {
    int data;
    Node left;
    Node right;
    public Object value;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Main {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(5);
        inorder(root);
        System.out.println("distinct Nodes:" + count);

    }

    static int count = 0;
    static HashSet<Integer> set = new HashSet<>();

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        if (!set.contains(root.data)) {
            set.add(root.data);
            count++;
        }
        inorder(root.right);
    }
}
