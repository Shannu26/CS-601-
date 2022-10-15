import java.util.Scanner;

class Question2{

	public static void buildHeap(int[] array){
		for(int i = array.length / 2 - 1; i >= 0; i--){
			heapify(array, i);
		}
	}

	public static void heapify(int[] array, int i){
		
		int largest = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		
		if(leftChild < array.length && array[leftChild] > array[largest]){
			largest = leftChild;
		}
		if(rightChild < array.length && array[rightChild] > array[largest]){
			largest = rightChild;
		}

		if(largest == i) return;
		int value = array[i];
		array[i] = array[largest];
		array[largest] = value;
		heapify(array, largest);
	}

	public static int search(int[] array, int index, int value){
		if(index >= array.length) return -1;
		if(array[index] == value) return index;

		int leftValue = search(array, 2 * index + 1, value);
		if(leftValue != -1) return leftValue;

		int rightValue = search(array, 2 * index + 2, value);
		return rightValue;
	}

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);

		System.out.print("Enter the size of heap: ");
		int size = s.nextInt();
		int[] heap = new int[size];

		System.out.print("Enter the values of heap: ");
		for(int i = 0;i < size;i++){
			heap[i] = s.nextInt();
		}

		System.out.print("Array before converting to max heap: ");
		for(int i = 0;i < size;i++){
			System.out.print(heap[i] + " ");
		}

		buildHeap(heap);

		System.out.print("\nArray after converting to max heap: ");
		for(int i = 0;i < size;i++){
			System.out.print(heap[i] + " ");
		}

		System.out.print("\nEnter the value you want to search: ");
		int searchValue = s.nextInt();
		int result = search(heap, 0, searchValue);
		System.out.println(result);
	}
}