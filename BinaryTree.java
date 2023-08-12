package binaryTree;

public class BinaryTree {

	Node root;
	
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
		return searchRecursive(root, target);
	}
	
	public String searchRecursive(Node currentNode, int target) {
		String directions = "";
		if (currentNode.value == target) {
			return directions;
		}
		
		if (currentNode.right != null && currentNode.right.value <= target){
			return directions += "- R -" + searchRecursive(currentNode.right, target);
		}
		else if (currentNode.left != null) {
			return directions += "- L -" + searchRecursive(currentNode.left, target);
		}

		return directions;
		
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
	
	public Node delete(Node currentNode, int target) {
		if (currentNode == null) {
			return currentNode;
		}
		
		else if (currentNode.value > target) {
			root.right = delete(currentNode.right, target);
		}
		
		else if (currentNode.value < target) {
			root.left = delete(currentNode.left, target);
		}
		
		else {
			
			if (currentNode.left == null && currentNode.right == null) {
				currentNode = null;
			}
			
			else if (currentNode.left )
		}
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
