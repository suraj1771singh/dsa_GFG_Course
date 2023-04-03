import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LeetcodeVersion1 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        inorderTraveral(map, 0, 0, root);

        for (TreeMap<Integer, PriorityQueue<Integer>> i : map.values()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (PriorityQueue<Integer> j : i.values()) {
                while (!j.isEmpty())
                    temp.add(j.poll());
            }
            ans.add(temp);
        }
        return ans;
    }

    public void inorderTraveral(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int hd, int level,
            TreeNode root) {
        if (root == null)
            return;
        inorderTraveral(map, hd - 1, level + 1, root.left);
        if (!map.containsKey(hd))
            map.put(hd, new TreeMap<>());

        if (!map.get(hd).containsKey(level))
            map.get(hd).put(level, new PriorityQueue<>());

        map.get(hd).get(level).offer(root.val);

        inorderTraveral(map, hd + 1, level + 1, root.right);
    }
}