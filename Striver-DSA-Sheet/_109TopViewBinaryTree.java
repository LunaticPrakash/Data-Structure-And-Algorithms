import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair<T, U> {
    public T first;
    public U second;

    Pair() {
    };

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class _109TopViewBinaryTree {
    // Approach 1 : Iterative Time: O(N) Space: O(N+N+N)
    public List<Integer> rightView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        if (root == null)
            return ans;

        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            TreeNode curr = queue.peek().first;
            int h = queue.peek().second;
            queue.poll();

            if (!map.containsKey(h))
                map.put(h, curr.val);
            if (curr.left != null)
                queue.add(new Pair<>(curr, h - 1));
            if (curr.right != null)
                queue.add(new Pair<>(curr, h + 1));
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            ans.add(m.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
