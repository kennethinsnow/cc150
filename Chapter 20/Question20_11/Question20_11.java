package Question20_11;

import CareerCupLibrary.AssortedMethods;

public class Question20_11 {
	private static int g_row1, g_row2, g_col1, g_col2;
	public static int getMaxMatrix(int[][] original){
		int maxArea = Integer.MIN_VALUE;
		int rowCount = original.length;
		int columnCount = original[0].length;
		int[][] matrix = precomputeMatrix(original);
		for (int row1 = 0; row1 < rowCount; row1++){
			for (int row2 = row1; row2 < rowCount; row2++){
				for (int col1 = 0; col1 < columnCount; col1++){
					for (int col2 = col1; col2 < columnCount; col2++){
						int sum = computeSum(matrix, row1, row2, col1, col2);
						if (maxArea < sum){
							maxArea = sum;
							g_row1 = row1;
							g_row2 = row2;
							g_col1 = col1;
							g_col2 = col2;
						}
					}
				}
			}
		}
		return maxArea;
	}
	
	private static int[][] precomputeMatrix(int[][] matrix){
		int[][] sumMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				if (i == 0 && j == 0){
					sumMatrix[i][j] = matrix[i][j];
				}else if (j == 0){
					sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
				}else if (i == 0){
					sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
				}else{
					sumMatrix[i][j] = sumMatrix[i][j - 1] + sumMatrix[i - 1][j] - sumMatrix[i - 1][j - 1] + matrix[i][j];
				}
			}
		}
		return sumMatrix;
	}
	
	private static int computeSum(int[][] sumMatrix, int i1, int i2, int j1, int j2){
		if (i1 == 0 && j1 == 0){
			return sumMatrix[i2][j2];
		}else if (i1 == 0){
			return sumMatrix[i2][j2] - sumMatrix[i2][j1 - 1];
		}else if (j1 == 0){
			return sumMatrix[i2][j2] - sumMatrix[i1 - 1][j2];
		}else{
			return sumMatrix[i2][j2] - sumMatrix[i2][j1 - 1] - sumMatrix[i1 - 1][j2] + sumMatrix[i1 - 1][j1 - 1];
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(30, 30, -5, 5);
		AssortedMethods.printMatrix(matrix);
		System.out.printf("largest sum: %d, row1: %d, row2: %d, col1: %d, col2: %d\n", getMaxMatrix(matrix), 
				getRow1(), getRow2(), getCol1(), getCol2());
	}

	public static int getRow1() {
		return g_row1;
	}

	public static int getRow2() {
		return g_row2;
	}

	public static int getCol1() {
		return g_col1;
	}

	public static int getCol2() {
		return g_col2;
	}
}
