package Question8_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.*;

import CareerCupLibrary.AssortedMethods;

public class QuestionS2 {
	class PointNode{
		Point curPt;
		PointNode next;
		public PointNode(Point pt, PointNode nt){
			this.curPt = pt;
			this.next = nt;
		}
		public PointNode getNext(){
			return next;
		}
		
		public Point getPt(){
			return curPt;
		}
		
		public String printForward(){
			StringBuffer sb = new StringBuffer();
			sb.append("[" + curPt.x + "," + curPt.y + "]");
			PointNode nextPt = next;
			while (nextPt != null){
				sb.append("->[" + nextPt.curPt.x + "," + nextPt.curPt.y + "]");
				nextPt = nextPt.next;
			}
			return sb.toString();
		}
	}
	public static int[][] maze = new int[5][5];
	
	public boolean is_free(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void getPaths(int x, int y, PointNode nt) {
		Point p = new Point(x, y);
		PointNode p1 = new PointNode(p, nt);
		if (0 == x && 0 == y) {
			System.out.println(p1.printForward());
		}

		if (x >= 1 && is_free(x - 1, y)) { // Try right
			getPaths(x - 1, y, p1); // Free!  Go right
		}
		if (y >= 1 && is_free(x, y - 1)) { // Try down
			getPaths(x, y - 1, p1); // Free!  Go down
		}
	}
	
	public static void main(String[] args) {
		maze = AssortedMethods.randomMatrix(5, 5, 0, 5);
		AssortedMethods.printMatrix(maze);
		new QuestionS2().getPaths(4, 4, null);
	}

}
