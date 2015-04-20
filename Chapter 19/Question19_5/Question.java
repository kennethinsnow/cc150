package Question19_5;

public class Question {

	public static class Result {
		public int hits;
		public int pseudoHits;
		
		public String toString() {
			return "(" + hits + ", " + pseudoHits + ")";
		}
	};
	
	public static Result estimate(String guess, String solution) {
		Result res = new Result();
		int solution_mask = 0;
		for (int i = 0; i < 4; ++i) {
			System.out.println("solution mask:" + solution_mask);
			System.out.println("charat: " + Integer.toBinaryString((solution.charAt(i) - 'A' + 1)));
			System.out.println("charat shifted: " + Integer.toBinaryString(( 1 << (solution.charAt(i) - 'A' + 1))));
			solution_mask |= 1 << (1 + solution.charAt(i) - 'A');
			
		}
		System.out.println(solution_mask);
		for (int i = 0; i < 4; ++i) {
			if (guess.charAt(i) == solution.charAt(i)) {
				++res.hits;
			} else if ((solution_mask & ( 1 << (1 + guess.charAt(i) - 'A'))) >= 1) {
				++res.pseudoHits;
			}
	 	}
	 	return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result res = estimate("YYGB", "RGGB");
		System.out.println(res.toString());
		int num = 30;
		System.out.println("left shift experiment: " + (1 << num));
		System.out.println("left shift experiment: " + Integer.toBinaryString(1 << num));
		System.out.println("left shift experiment: " + (-1 << num));
		System.out.println("left shift experiment: " + Integer.toBinaryString(-1 << num));
	}

}
