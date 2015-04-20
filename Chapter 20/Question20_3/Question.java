package Question20_3;

import CareerCupLibrary.AssortedMethods;

public class Question {

	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) { 
		return lower + (int)(Math.random() * (higher - lower + 1));
	}

	/* pick M elements from original array.  Clone original array so that
	 * we don�t destroy the input. */
	public static int[] pickMRandomly(int[] original, int m) {
		int[] subset = new int[m];
		int[] array = original.clone();
		for (int j = 0; j < m; j++) {
			int index = rand(j, array.length - 1); 
			subset[j] = array[index];
			array[index] = array[j]; // array[j] is now "dead"
		}
		return subset;
	}
	
	public static void main(String[] args) {
		int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(AssortedMethods.arrayToString(cards));
		int[] set = new int[4];
		int testnum = 100000;
		int[] freq = new int[cards.length];
		for (int j = 0; j < testnum; j++){
			set = pickMRandomly(cards, 4);
			for (int i : set){
				freq[i]++;
			}
		}
		System.out.println(AssortedMethods.arrayToString(set));
		for (int i = 0; i < freq.length; i++){
			double perct = 100.0 * freq[i] / testnum;
			System.out.println(i + " appeared " + perct + "% of time");
		}
	}

}
