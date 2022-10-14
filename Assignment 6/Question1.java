import java.util.Scanner;

class Node{
	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

class Question1{

	public static Node insert(Node tree, int value){
		if(tree == null){
			Node node = new Node(value, null, null);
			return node;
		}
		if(value < tree.value){
			tree.left = insert(tree.left, value);
		}
		else{
			tree.right = insert(tree.right, value);
		}
		return tree;
	}

	public static void inorder(Node tree){
		if(tree == null) return;
		inorder(tree.left);
		System.out.print(tree.value + " ");
		inorder(tree.right);
	}

	public static void preorder(Node tree){
		if(tree == null) return;
		System.out.print(tree.value + " ");
		inorder(tree.left);
		inorder(tree.right);
	}

	public static void postorder(Node tree){
		if(tree == null) return;
		inorder(tree.left);
		inorder(tree.right);
		System.out.print(tree.value + " ");
	}

	public static void main(String args[]){
		Node tree = null;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter the initial size of tree: ");
		int size = s.nextInt();
		System.out.print("Enter the initial values of tree: ");
		for(int i = 0;i < size;i++){
			int value = s.nextInt();
			tree = insert(tree, value);
		}

		while(true){
			System.out.println("Current Tree's");
			System.out.print("Pre-Order Traversal: ");
			preorder(tree);
			System.out.print("\nIn-Order Traversal: ");
			inorder(tree);
			System.out.print("\nPost-Order Traversal: ");
			postorder(tree);

			System.out.print("\nDo you want to insert a new element? Enter 1 for Yes and 0 for No: ");
			int choice = s.nextInt();
			if(choice == 0){
				System.out.println("You have chosen to exit the application.");
				System.out.println("Thank You. Bye Bye...");
				break;
			}

			System.out.print("Enter the element you want to insert: ");
			int value = s.nextInt();
			insert(tree, value);
		}
	}
}