package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTreeDS {

    // insert a node
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else
                q.add(temp.right);
        }
        return root;
    }

    // inorder traversal of tree
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // preorder traversal of tree
    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // postorder traversal of tree
    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");

    }

    // sum of all nodes in tree
    public int sum(Node root) {
        if (root == null)
            return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // print all even level nodes
    public void even(Node root, boolean isEven) {
        if (root == null)
            return;
        if (isEven == true)
            System.out.print(root.data + " ");
        even(root.left, !isEven);
        even(root.right, !isEven);
    }

    // print all odd level nodes
    public void odd(Node root, boolean isOdd) {
        if (root == null)
            return;
        if (isOdd == true)
            System.out.print(root.data + " ");
        even(root.left, !isOdd);
        even(root.right, !isOdd);
    }

    // Get difference of values at Even & Odd level
    public int getDiffEvenOdd(Node root) {
        if (root == null)
            return 0;
        return root.data - getDiffEvenOdd(root.left) - getDiffEvenOdd(root.right);
    }

    // Number of nodes in tree
    public int countNodes(Node root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Number of leaf nodes in tree
    public int countLeafNodes(Node root) {
        if (root == null)
            return 0;
        if (root.left != null || root.right != null)
            return countLeafNodes(root.left) + countLeafNodes(root.right);
        else
            return 1;
    }

    // Get height of tree
    public int height(Node root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (lheight > rheight)
            return lheight + 1;
        return rheight + 1;
    }

    // print kth level iterative
    public ArrayList<Integer> kthLevelIter(Node root, int level) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        int k = 0, flag = 0;
        if (root == null || level < 0)
            return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if (k == level) {
                    flag = 1;
                    ans.add(temp.data);
                } else {
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
            }
            k++;
            if (flag == 1)
                break;
        }
        return ans;
    }

    // print nodes at kth level
    public void kthLevel(Node root, int level) {
        if (root == null || level < 0)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        level--;
        kthLevel(root.left, level);
        kthLevel(root.right, level);
    }

    // level order traversal
    public void levelOrder(Node root) {
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            kthLevel(root, i);
        }
    }

    // reverse level order traversal
    public void reverseLevelOrder(Node root) {
        int h = height(root);
        for (int i = h; i >= 0; i--) {
            kthLevel(root, i);
        }
    }

    // print left view of tree
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if (i == 0)
                    ans.add(temp.data);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ans;
    }

    // right view of tree
    public ArrayList<Integer> rightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if (i == n - 1)
                    ans.add(temp.data);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ans;
    }

    class Pair<T, U> {
        T first;
        U second;

        Pair() {
        };

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    // top view of tree
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();

        if (root == null)
            return ans;
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.peek().first;
            int h = queue.peek().second;
            queue.poll();
            if (!map.containsKey(h))
                map.put(h, temp.data);
            if (temp.left != null)
                queue.add(new Pair<>(temp.left, h - 1));
            if (temp.right != null)
                queue.add(new Pair<>(temp.right, h + 1));
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet())
            ans.add(m.getValue());
        return ans;
    }

    // bottom view of tree
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();

        if (root == null)
            return ans;
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.peek().first;
            int h = queue.peek().second;
            queue.poll();
            map.put(h, temp.data);
            if (temp.left != null)
                queue.add(new Pair<>(temp.left, h - 1));
            if (temp.right != null)
                queue.add(new Pair<>(temp.right, h + 1));
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet())
            ans.add(m.getValue());
        return ans;
    }

    // zig-zag traversal tree
    public ArrayList<Integer> zigzag(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            temp = kthLevelIter(root, i);
            if (i % 2 == 0)
                ans.addAll(temp);
            else {
                Collections.reverse(temp);
                ans.addAll(temp);
            }
        }
        return ans;
    }

    // diagonal traversal of tree
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root == null)
            return ans;

        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            while (temp != null) {
                if (temp.left != null)
                    queue.add(temp.left);
                ans.add(temp.data);
                temp = temp.right;
            }
        }
        return ans;
    }

    public void leftBoundary(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.left != null) {
            ans.add(root.data);
            leftBoundary(root.left, ans);
        } else if (root.right != null) {
            ans.add(root.data);
            leftBoundary(root.right, ans);
        }
    }

    public void rightBoundary(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.right != null) {
            ans.add(root.data);
            rightBoundary(root.right, ans);
        } else if (root.left != null) {
            ans.add(root.data);
            rightBoundary(root.left, ans);
        }
    }

    public void leaves(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans.add(root.data);
        else {
            if (root.left != null)
                leaves(root.left, ans);
            if (root.right != null)
                leaves(root.right, ans);
        }
    }

    // boundary traversal of tree
    public ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        ans.add(root.data);
        leftBoundary(root.left, ans);
        leaves(root, ans);
        rightBoundary(root.right, ans);
        return ans;
    }

    // diameter of tree
    public int diameter(Node root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    // mirror of tree
    public Node mirrorify(Node root) {
        if (root == null)
            return null;
        Node mirror = new Node(root.data);
        mirror.right = mirrorify(root.left);
        mirror.left = mirrorify(root.right);
        return mirror;
    }

    // check if tree is balanced
    public boolean isBalanced(Node root){
        if(root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTreeDS tree = new BinaryTreeDS();
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(8);
        root.right.right = new Node(13);
        root.left.left.left = new Node(0);

        System.out.print("\n\nInorder :- ");
        tree.inorder(root);

        System.out.print("\n\nPreorder :- ");
        tree.preorder(root);

        System.out.print("\n\nPostorder :- ");
        tree.postorder(root);

        System.out.print("\n\nLevel order :- ");
        tree.levelOrder(root);

        System.out.print("\n\nReverse Level order :- ");
        tree.reverseLevelOrder(root);

        System.out.println("\n\nSum of all nodes = " + tree.sum(root));
        System.out.println("\nDifference between even and odd level nodes = " + tree.getDiffEvenOdd(root));
        System.out.print("\nAll even level nodes = ");
        tree.even(root, true);
        System.out.print("\n\nAll odd level nodes = ");
        tree.odd(root, false);
        System.out.println("\n\nNo. of nodes = " + tree.countNodes(root));
        System.out.println("\nNo. of Leaf nodes = " + tree.countLeafNodes(root));
        System.out.println("\nHeight of tree = " + tree.height(root));
        System.out.print("\nAll kth level nodes = " + tree.kthLevelIter(root, 2));
        System.out.print("\n\nLeft View = " + tree.leftView(root));
        System.out.print("\n\nRight View = " + tree.rightView(root));
        System.out.print("\n\nTop View = " + tree.topView(root));
        System.out.print("\n\nBottom View = " + tree.bottomView(root));
        System.out.print("\n\nZig Zag Traversal = " + tree.zigzag(root));
        System.out.print("\n\nDiagonal Traversal = " + tree.diagonal(root));
        System.out.print("\n\nBoundary Traversal = " + tree.boundary(root));
        System.out.print("\n\nDiameter = " + tree.diameter(root));
        System.out.print("\n\nInorder of original tree :- ");
        tree.inorder(root);
        System.out.print("\n\nInorder of mirror tree :- ");
        tree.inorder(tree.mirrorify(root));
        System.out.println("\n\nBalanced = " + tree.isBalanced(root));
    }
}