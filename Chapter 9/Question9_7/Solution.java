package Question9_7;

import java.util.*;

public class Solution {
	public Solution(ArrayList<HtWt> items, ArrayList<Integer> maxSeq) {
		super();
		this.items = items;
		this.maxSeq = maxSeq;
	}

	ArrayList<HtWt> items;
	ArrayList<Integer> maxSeq;
	int maxLen = 1;
	int maxIndex = 0;

	// Find the maximum length of the sequence
	void lis(ArrayList<HtWt> persons) {
		Collections.sort(persons);
		int n = persons.size();
		for (int i = 1; i < n; i++){
			HtWt curPer = persons.get(i);
			for (int j = i - 1; j >= 0; j--){
				if (persons.get(j).isBefore(curPer) && (maxSeq.get(j) + 1) > maxSeq.get(i)){
					maxSeq.set(i, maxSeq.get(j) + 1);
					curPer.setPre(persons.get(j));
					if (maxLen < maxSeq.get(i)){
						maxLen = maxSeq.get(i);
						maxIndex = i;
					}
				}
			}
		}
	}
	
	public void printResult() {
		System.out.println("max length: " + maxLen);
		System.out.println("max length sequence: " + items.get(maxIndex).printForward());
	}
	
	public static void main(String[] args) {
		ArrayList<HtWt> items = new ArrayList<HtWt>();
		ArrayList<Integer> maxSeq = new ArrayList<Integer>();
		
		HtWt item = new HtWt(65, 40);
		items.add(item);
		
		item = new HtWt(70, 60);
		items.add(item);
		
		item = new HtWt(56, 50);
		items.add(item);
		
		item = new HtWt(75, 70);
		items.add(item);
		
		item = new HtWt(60, 30);
		items.add(item);
		
		item = new HtWt(67, 80);
		items.add(item);
		
		items.add(new HtWt(68, 90));
		items.add(new HtWt(69, 100));
		items.add(new HtWt(65, 45));
		items.add(new HtWt(62, 44));
		items.add(new HtWt(63, 45));
		
		for (int i = 0; i < items.size(); i++){
			maxSeq.add(1);
		}
		Solution q = new Solution(items, maxSeq);
		q.lis(q.items);
		q.printResult();
	}

	public int getMaxLen() {
		return maxLen;
	}

	public void setMaxLen(int maxLen) {
		this.maxLen = maxLen;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}
}
