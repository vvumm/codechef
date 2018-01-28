import java.util.Scanner;

public class LittleChefAndSums {

	private int prefixSum(int i, int[] array) {
		int sum = 0;
		for(int j=0; j<=i; j++) {
			sum += array[j];
		}
		return sum;
	}

	private int suffixSum(int i, int[] array) {
		int sum = 0;
		for(int j=i; j<array.length; j++) {
			sum += array[j];
		}
		return sum;
	}

	private void findLeastSums(int[] array) {
		int currentSum = 0;
		boolean isInitialExecution = true;
		int leastSumIndex = 0;
		for(int k=0; k<array.length; k++) {
			int tempSum = prefixSum(k, array) + suffixSum(k, array);
			if(isInitialExecution) {
				currentSum = tempSum;
				isInitialExecution = false;
			}
			if(currentSum < tempSum);
			else {
				if(currentSum==tempSum && leastSumIndex<k);
				else {
					currentSum = tempSum;
					leastSumIndex = k;
				}
			}
		}
		System.out.println(++leastSumIndex);
	}

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int numTcs = scr.nextInt();
		System.out.println(" Num of TCs " + numTcs);
		for(int tc=0; tc<numTcs; tc++) {
			int noOfEntires = scr.nextInt();
		}
	}
	
	/*public static void main(String[] args) {
		LittleChefAndSums obj = new LittleChefAndSums();
		obj.findLeastSums(new int[] {1,2,3});
	}*/

}
