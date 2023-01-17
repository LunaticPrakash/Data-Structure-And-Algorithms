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

public class _105PreorderTraversal {

    // Approach 1 : Recursive Time: O(N) Space: O(N+N)
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return solve(root, ans);
    }

    private List<Integer> solve(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        ans.add(root.val);
        solve(root.left, ans);
        solve(root.right, ans);
        return ans;
    }

    // Approach 2 : Iterative Time: O(N) Space: O(N)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (true) {
            if (curr != null) {
                ans.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty())
                    break;
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
