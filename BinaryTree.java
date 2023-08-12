package binaryTree;

public class BinaryTree {

	Node root;
	String directions = "";
	
	public void insert(int value) {
		root = insertRecursive(root, value);
	}

	public Node insertRecursive(Node currentNode, int value) {
		if (currentNode == null) {
			return new Node(value);
		}
		if (currentNode.value < value) {
			currentNode.right = insertRecursive(currentNode.right, value);
		}
		else if (currentNode.value > value) {
			currentNode.left =  insertRecursive(currentNode.left, value);
		}
		return currentNode;
	}
	
	public String search(int target) {
		System.out.println("Looking for " + target);
		
		if (target == root.value) {
			return "Root node";
		}

		directions = "";
		
		return searchRecursive(root, target);
	}
	
	public String searchRecursive(Node currentNode, int target) {
		if (currentNode.value == target) {
			return directions;
		}
		
		if (currentNode.right != null && currentNode.right.value <= target){
			return directions += "- L -" + searchRecursive(currentNode.right, target);
		}
		else if (currentNode.left != null) {
			return directions += "- R -" + searchRecursive(currentNode.left, target);
		}

		return directions;
		
	}
	
	public Node delete(int target){
		return deleteRecursive(root, target);
	}

	public Node deleteRecursive(Node current, int target){
		
		if (current == null){
			return current;
		}

		if (current.value > target){
			current.left = deleteRecursive(current.left, target);
			return current;
		}

		else if (current.value < target){
			current.right = deleteRecursive(current.right, target);
			return current;
		}
		
		if (current.left == null){
			Node temp = current.right;
			return temp;
		}
		else if (current.right == null){
			Node temp = current.left;
			return temp; 
		}
		else{
			Node parent = current;

			Node child = parent.right;
			while (child.left != null){
				parent = child;
				child = child.left;
			}

			if (parent != current){
				parent.left = child.right;
			}
			else{
				parent.right = child.right;
			}

			current.value = child.value;

			return current;
		}

	}

	public Node searchNode(Node currentNode, int target)
	{
		if (currentNode.value == target) {
			return currentNode;
		}
		
		if (currentNode.right != null && currentNode.right.value <= target){
			return searchNode(currentNode.right, target);
		}
		
		else if (currentNode.left != null) {
			return searchNode(currentNode.left, target);
		}

		return currentNode;
		
	}
	
	void print() {
		printTree(root, "");
	}
	
	void printTree(Node currentNode, String prefix)
	 {
	    if(currentNode == null) return;

	    System.out.println(prefix + "+" + currentNode.value);
	    printTree(currentNode.right , prefix + "  ");
	    printTree(currentNode.left , prefix  + "  ");
	 }
}
