import java.util.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}

}

class Tree{
	Node root = null;

	Tree(int[] values){
		this.root = constructTree(values, 0);
	}

	Node constructTree(int[] values, int index){
		if(index >= values.length) return null;

		Node root = new Node(values[index], null, null);
		root.left = constructTree(values, 2 * index + 1);
		root.right = constructTree(values, 2 * index + 2);

		return root;
	}

	void convertToHeap(){
		heapify(this.root);
	}

	void heapify(Node root){
		if(root == null) return;
		
		heapify(root.left);
		heapify(root.right);

		swapNodes(root);
	}

	void swapNodes(Node root){

		if(root.left == null && root.right == null) return;
		if(root.left == null){
			if(root.value < root.right.value){
				int value = root.value;
				root.value = root.right.value;
				root.right.value = value;
				swapNodes(root.right);
			}
		}
		else if(root.right == null){
			if(root.value < root.left.value){
				int value = root.value;
				root.value = root.left.value;
				root.left.value = value;
				swapNodes(root.left);
			}
		}
		else{
			if(root.value < root.left.value && root.value > root.right.value){
				int value = root.value;
				root.value = root.left.value;
				root.left.value = value;
				swapNodes(root.left);
			}
			else if(root.value < root.right.value && root.value > root.left.value){
				int value = root.value;
				root.value = root.right.value;
				root.right.value = value;
				swapNodes(root.right);
			}
			else if(root.value < root.right.value && root.value < root.left.value){
				if(root.left.value < root.right.value){
					int value = root.value;
					root.value = root.right.value;
					root.right.value = value;
					swapNodes(root.right);
				}
				else{
					int value = root.value;
					root.value = root.left.value;
					root.left.value = value;
					swapNodes(root.left);
				}
			}
		}
	}

	void traverse(){
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(this.root);

		while(queue.size() != 0){
			Node node = queue.remove(0);
			System.out.print(node.value + " ");

			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}

		System.out.println();
	}
}

class Problem2{
	public static void main(String args[]){
		int[] values = new int[]{24, 12, 38, 3, 45, 2, 56, 8, 100, 6};
		Tree tree = new Tree(values);
		tree.traverse();
		tree.convertToHeap();
		tree.traverse();
	}
}