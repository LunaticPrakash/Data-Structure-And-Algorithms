import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

class Triplet<T, U, V> {
    public T first;
    public U second;
    public V third;

    Triplet() {
    };

    Triplet(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class _111VerticalOrderTraversal {

    // Approach 1 : Iterative Time: O(N) Space: O(N+N+N)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        return ans;
    }

    public static void main(String[] args) {

    }
}
