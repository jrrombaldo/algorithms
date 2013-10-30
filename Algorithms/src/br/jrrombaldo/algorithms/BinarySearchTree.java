package br.jrrombaldo.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends BaseAlgorithm {

    protected class Node {
	public Node left;
	public Node right;
	public int value;

	@Override
	public String toString() {
	    return String.valueOf(value);
	}
    }

    protected Node root;
    protected int count;

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

    public void insert(int val) {
	Node node = new Node();
	node.value = val;
	if (this.root == null)
	    this.root = node;
	else
	    insert(node, this.root);
    }

    public void insert(Node node, Node root) {
	if (root == null)
	    root = node;
	else if (node.value > root.value) {
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
    }

    public void inOrder(Node root, List<Integer> list) {
	if (root == null)
	    return;
	inOrder(root.left, list);
	list.add(root.value);
	inOrder(root.right, list);
    }
    

    public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
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

	System.out.println(tree.search(33));


	List<Integer> list = new ArrayList<Integer>();
	tree.inOrder(tree.root, list);
	for(Integer val : list){
	    System.out.print(val+" ");
	}
    }

}
