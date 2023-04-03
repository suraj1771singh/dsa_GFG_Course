import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//----------------GFG
//Complete the function below
//Node is as follows:
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        f(root, 0, map);
        for (Map.Entry i : map.entrySet()) {
            ans.add((int) i.getValue());
        }
        return ans;
    }

    public void f(Node root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;
        f(root.left, hd - 1, map);
        int sum = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, sum + root.data);
        f(root.right, hd + 1, map);
    }
}

// Time Complexity : O(n * log(hd)) + O(hd)
//  hd: hd is number of possible horizontal lines
