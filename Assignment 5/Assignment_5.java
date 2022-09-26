import java.util.*;

class Assignment_5{

	public static int linearXpowN(int x, int n){
		if(n == 0) return 1;
		return x * linearXpowN(x, n - 1);
	}

	public static int logarithmicXpowN(int x, int n){
		if(n == 1) return x;
		int product = 1;
		if(n % 2 != 0){
			product = x;
			n -= 1;
		}
		int subProduct = logarithmicXpowN(x, n / 2);
		return product * subProduct * subProduct;
	}

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		System.out.println(linearXpowN(x, n));
		System.out.println(logarithmicXpowN(x, n));
	}
}