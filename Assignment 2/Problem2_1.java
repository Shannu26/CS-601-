class Problem2_1{

	static void convertToMaxHeap(int[] array){
		for(int i = array.length / 2 - 1; i >= 0; i--){
			heapify(array, i);
		}
	}

	static void heapify(int[] array, int i){
		
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

	public static void main(String args[]){
		int[] values = new int[]{24, 12, 38, 3, 45, 2, 56, 8, 100, 6};
		for(int i = 0;i < values.length;i++){
			System.out.print(values[i] + " ");
		}
		System.out.println();
		convertToMaxHeap(values);
		for(int i = 0;i < values.length;i++){
			System.out.print(values[i] + " ");
		}
	}
}