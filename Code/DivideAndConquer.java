
class DivideAndConquer{

	// findMaxMin problem
	public static int[] findMaxMin(int[] array, int left, int right){
		int[] solution = new int[2];
		if(left == right){
			solution[0] = array[left];
			solution[1] = array[left];
			return solution;
		}

		int mid = (left + right) / 2;
		int[] leftSubproblem = findMaxMin(array, left, mid);
		int[] rightSubproblem = findMaxMin(array, mid + 1, right);

		solution[0] = Math.max(leftSubproblem[0], rightSubproblem[0]);
		solution[1] = Math.min(leftSubproblem[1], rightSubproblem[1]);
		return solution;
	}

	// A utility function to swap two elements
    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot 
    */
    public static int partition(int[] array, int low, int high)
    {
  
        // pivot
        int pivot = array[high];
  
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (array[j] < pivot) {
                // Increment index of
                // smaller element
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
            array[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
    */
    static void quickSort(int[] array, int low, int high)
    {
        if (low < high) {
            // pi is partitioning index, array[p]
            // is now at right place
            int pi = partition(array, low, high);
  
            // Separately sort elements before
            // partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Merges two subarrays of array[].
    // First subarray is array[l..m]
    // Second subarray is array[m+1..r]
    public static void merge(int array[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts array[l..r] using
    // merge()
    public static void mergeSort(int array[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
 
            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    // karatsuba problem
    public static long karatsuba(long x, long y) {
 
        // Checking only if input is within range 
        if (x < 10 && y < 10) {
           
            // Multiplying the inputs entered
            return x * y;
        }
      
        // Declaring variables in order to 
        // Find length of both integer
        // numbers x and y
        int xLen = numLength(x);
        int yLen = numLength(y);
 
        // Finding maximum length from both numbers
        // using math library max function
        int n = Math.max(xLen, yLen);
 
        // Rounding up the divided Max length
        int m = (n / 2) + (n % 2);
 
        // Multiplier
        long multiplier = (long)Math.pow(10, m);
 
        // Compute the expressions
        long x_H = x / multiplier;
        long x_L = x % multiplier;
        long y_H = y / multiplier;
        long y_L = y % multiplier;
 
        // Recursive Calls 
        long a = karatsuba(x_H, y_H);
        long d = karatsuba(x_L, y_L);
        long e = karatsuba(x_H + x_L, y_H + y_L) - a - d;
 
        long product = ((a * (long)Math.pow(10, m * 2)) + (e * (long)Math.pow(10, m)) + d);
 
        return product;
 
    }
   
    // karatsuba problem
    // To calculate length of the number
    public static int numLength(long n)
    {
        int length = 0;
        while (n > 0) {
            length++;
            n /= 10;
        }
 
        // Returning length of number n
        return length;
    }

	public static void main(String args[]){
		// findMaxMin problem
		int[] array = new int[]{100, 26, 15, 39, 56, -100};
		int[] solution = findMaxMin(array, 0, array.length - 1);
		System.out.println(solution[0] + " " + solution[1]);

		// quickSort problem
		array = new int[]{100, 26, 15, 39, 56, -100};
		quickSort(array, 0, array.length - 1);
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// mergeSort problem
		array = new int[]{100, 26, 15, 39, 56, -100};
		mergeSort(array, 0, array.length - 1);
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// karatsuba problem
		long product = karatsuba(1234, 5678);
		System.out.println(product);
	}
}