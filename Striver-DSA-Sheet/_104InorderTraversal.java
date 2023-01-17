import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class _104InorderTraversal {

    // Approach 1 : Recursive Time: O(N) Space: O(N+N)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return solve(root, ans);
    }

    private List<Integer> solve(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        solve(root.left, ans);
        ans.add(root.val);
        solve(root.right, ans);
        return ans;
    }

    // Approach 2 : Iterative Time: O(N) Space: O(N)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (true) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
