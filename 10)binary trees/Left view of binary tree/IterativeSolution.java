import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Tree {
    // ---ITERATIVE SOLUTION
    static int prevlevel;

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        f(root, ans);
        return ans;

    }

    void f(Node root, ArrayList<Integer> ans) {

        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            ans.add(q.peek().data);
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }

    }
}