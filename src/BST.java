// James Yue
// 4/8/24

// BinaryTree is a program that can do three things: 1. check if a number is part of the tree,
// 2. recursively sort the tree into three different sorts (preorder, inorder, and postorder),
// 3. and can correctly insert a number in the tree

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.BaseStream;

/**
 * An Integer Binary Search Tree
 * @author: James Yue
 * @version: 4/8/24
 */
// C.T. Can write an algorithm to solve a problem recursively, including a base case and a recursive step.
// C.T. Can trace through a given recursive method to understand its behavior and the results returned when called.
// C.T. Can use ArrayList methods.
// C.T. Can write algorithms to traverse and modify Arrays and ArrayLists.
public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    // Checks whether a given value is actually in the tree
    public boolean search(int val) {
        // TODO: Complete the search function
        // Call onto the finder() helper method taking in the root and value
        return finder(root, val);
    }

    // C.T. Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
    // Helper method to search()
    public boolean finder(BSTNode root, int val) {
        // Base case: If the root is null, the value is not in the tree
        if (root == null) {
            return false;
        }
        // If the root of the tree equals the value, return true
        else if (root.getVal() == val)
        {
            return true;
        }
        // If the value is greater than the root, recursively search the subtree on the left
        else if (root.getVal() > val)  {
            return finder(root.getLeft(), val);
        }
        // If the value is less than the root, recursively search the subtree on the right
        else if (root.getVal() < val)  {
            return finder(root.getRight(), val);
        }
        // The value is not found
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // An ArrayList to store the inorder node's
        ArrayList<BSTNode> order = new ArrayList<>();
        // Call to the helper method of inorder, which initiates the traversal
        inOrder(order, root);
        // Return the ArrayList that stores the inorder traversal
        return order;
    }

    // C.T. Can utilize class-scope instance variables and local parameters in methods.
    // Helper method to recursively traverse the inorder tree
    public void inOrder(ArrayList<BSTNode> order, BSTNode current) {
        // Base case: If current is null, return
        if (current == null) {
            return;
        }
        // Inorder follows left, root, right
        // Recursively perform the inorder traversal on the left subtree
        inOrder(order, current.getLeft());
        // Add the current node to the ArrayList of order
        order.add(current);
        // Recursively perform the inorder traversal on the right subtree
        inOrder(order, current.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // An ArrayList to store the preorder node's
        ArrayList<BSTNode> order = new ArrayList<>();
        // Call to the helper method of preorder, which initiates the traversal
        preOrder(order, root);
        // Return the ArrayList that stores the preorder traversal
        return order;
    }

    // Helper method to recursively traverse the preorder tree
    public void preOrder(ArrayList<BSTNode> order, BSTNode current) {
        // Base case: If current is null, return
        if (current == null) {
            return;
        }
        // Preorder follows root, left, right
        // Add the current node to the ArrayList of order
        order.add(current);
        // Recursively perform the inorder traversal on the left subtree
        preOrder(order, current.getLeft());
        // Recursively perform the inorder traversal on the right subtree
        preOrder(order, current.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // An ArrayList to store the postorder node's
        ArrayList<BSTNode> order = new ArrayList<>();
        // Call to the helper method of postorder, which initiates the traversal
        postOrder(order, root);
        // Return the ArrayList that stores the postorder traversal
        return order;
    }

    // Helper method to recursively traverse the postorder tree
    public void postOrder(ArrayList<BSTNode> order, BSTNode current) {
        // Base case: If current is null, return
        if (current == null) {
            return;
        }
        // Postorder follows left, right, root
        // Recursively perform the inorder traversal on the left subtree
        postOrder(order, current.getLeft());
        // Recursively perform the inorder traversal on the right subtree
        postOrder(order, current.getRight());
        // Add the current node to the ArrayList of order
        order.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    // Insert a new node with a value into the Binary Tree
    public void insert(int val) {
        // TODO: Complete insert
        // Call the insertNode() method and set it to the root of the Binary Tree
        root = insertNode(root, val);
    }

    // Helper method to insert() to insert a new node into the Binary Tree
    public BSTNode insertNode(BSTNode current, int val) {
        // Base case: If the current node equals null, create a new node with the value and return it
        if (current == null) {
            return new BSTNode(val);
        }
        // If the value is less than the current value, recursively insert the node onto the left subtree
        if (val < current.getVal()) {
            current.setLeft(insertNode(current.getLeft(), val));
        }
        // If the value is greater than the current value, recursively insert the node onto the right subtree
        else if (val > current.getVal()) {
            current.setRight(insertNode(current.getRight(), val));
        }
        // Return the current node
        return current;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}