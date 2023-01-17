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

public class _108BottomViewTree {

    // Approach 1 : Recursive Time: O(N) Space: O(N+N)
    public List<Integer> bottomView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    public static void main(String[] args) {

    }
}
