import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class _107LeftViewofTree {

    // Approach 1 : Recursive Time: O(N) Space: O(N+N)
    public List<Integer> leftSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, ans, 0);
        return ans;
    }

    private void solve(TreeNode root, List<Integer> ans, int currDepth) {
        if (root == null)
            return;
        if (ans.size() == currDepth)
            ans.add(root.val);
        solve(root.left, ans, currDepth + 1);
        solve(root.right, ans, currDepth + 1);
    }

    // Approach 2 : Iterative Time: O(N) Space: O(N)
    public List<Integer> leftSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) 
                    ans.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
