import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

class Assignment_7{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);

		System.out.print("Enter number of houses present in the street: ");
		int size = s.nextInt();

		int[] distances = new int[size];
		System.out.print("Enter the positions of each house from left end: ");
		for(int i = 0;i < size;i++){
			distances[i] = s.nextInt();
		}

		ArrayList<Integer> towerPositions = placeTowers(distances);
		System.out.print("The Positions of the towers from left end are ");
		for(int i = 0;i < towerPositions.size();i++){
			System.out.print(towerPositions.get(i) + "    ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> placeTowers(int[] distances){
		Arrays.sort(distances);
		ArrayList<Integer> towerPositions = new ArrayList<>();
		if(distances.length == 0) return towerPositions;

		towerPositions.add(distances[0] + 4);
		int lastTowerIndex = 0;

		for(int index = 1;index < distances.length;index++){
			if(Math.abs(distances[index] - towerPositions.get(lastTowerIndex)) > 4){
				towerPositions.add(distances[index] + 4);
				lastTowerIndex += 1;
			}
		}

		return towerPositions;
	}
}