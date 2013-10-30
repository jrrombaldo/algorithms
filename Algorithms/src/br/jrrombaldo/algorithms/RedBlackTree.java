package br.jrrombaldo.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {

    protected Node root;

    class Node {
	public boolean isRed;
	public Node left;
	public Node right;
	public int value;

	public Node(int value) {
	    this.value = value;
	    this.isRed = true;
	}

	@Override
	public String toString() {
	    return value + "(" + isRed + ")";
	}
    }

    public boolean isRed(Node node) {
	if (node == null)
	    return false;
	else
	    return node.isRed;
    }

    public void insert(int val) {
	Node node = new Node(val);
	if (root == null) {
	    root = node;
	    node.isRed = false;
	} else
	    insert(node, this.root);
    }

    public void insert(Node node, Node root) {

	if (node.value > root.value) {
	    if (root.right != null)
		insert(node, root.right);
	    else
		root.right = node;
	} else {
	    if (root.left != null)
		insert(node, root.left);
	    else
		root.left = node;
	}

	
	if (isRed(root.right) && !isRed(root.left))
	    root = rotateLeft(root);
	if (isRed(node.left) && (root.left != null && isRed(root.left.left)))
	    root = rotateRight(root);
	if (isRed(root.left) && isRed(root.right))
	    flipColors(root);
    };

    public Node flipColors(Node node) {
	node.isRed = true;
	node.left.isRed = false;
	node.right.isRed = false;
	return node;
    }

    public Node rotateLeft(Node node) {
	Node x = node.right;
	node.right = x.left;
	x.left = node;
	x.isRed = node.isRed;
	node.isRed = true;
	return node;
    }

    public Node rotateRight(Node node) {
	Node x = node.left;
	node.left = x.right;
	x.right = node;
	x.isRed = node.isRed;
	node.isRed = true;
	return node;
    }

    // same of regular tree
    public Node search(int value) {
	Node node = root;

	while (node != null) {
	    if (node.value == value)
		break;
	    else if (node.value > value)
		node = node.left;
	    else
		node = node.right;
	}
	return node;// null if not found
    }

    // same of regular tree
    public void inOrder(Node root, List<Node> list) {
	if (root == null)
	    return;
	inOrder(root.left, list);
	list.add(root);
	inOrder(root.right, list);
    }

    public static void main(String[] args) {
	RedBlackTree tree = new RedBlackTree();

	// Random rand = new Random();
	// for (int i = 0; i < 20; i++)
	// tree.insert(rand.nextInt(100));
	tree.insert(10);
	tree.insert(45);
	tree.insert(20);
	tree.insert(59);
	tree.insert(65);
	tree.insert(89);
	tree.insert(37);
	tree.insert(8);
	tree.insert(73);
	tree.insert(39);

	System.out.println(tree.search(39));

	List<Node> list = new ArrayList<Node>();
	tree.inOrder(tree.root, list);
	for (Node val : list) {
	    System.out.print(val + " ");
	}
    }

}
