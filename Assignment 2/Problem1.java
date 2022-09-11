class Problem1{
	public static void main(String args[]){
		// n = 10
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int n = array.length;
		int sum = 0;

		for(int i = 0;i < n;i++){
			sum += array[i];
		}

		System.out.println("Sum is " + sum);
	}
}