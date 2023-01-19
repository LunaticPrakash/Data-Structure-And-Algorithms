import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class _112RootToNode {

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(A, B, ans);
        return ans;
    }

    private boolean preorder(TreeNode root, int target, ArrayList<Integer> ans) {
        if (root == null)
            return false;

        if (root.val == target) {
            ans.add(root.val);
            return true;
        }

        if (preorder(root.left, target, ans)) {
            ans.add(root.val);
            return true;
        }

        if (preorder(root.right, target, ans)) {
            ans.add(root.val);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
