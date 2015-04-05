package Question9_7;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class Test_Lis {

	ArrayList<HtWt> items = new ArrayList<HtWt>();
	ArrayList<Integer> maxSeq = new ArrayList<Integer>();

	@Before
	public void setup(){
		items = new ArrayList<HtWt>();
		maxSeq = new ArrayList<Integer>();
	}
	
	@Test
	public void test_basic() {


		items.add(new HtWt(65, 40));
		items.add(new HtWt(67, 80));
		items.add(new HtWt(56, 50));
		
		for (int i = 0; i < items.size(); i++){
			maxSeq.add(1);
		}
		Solution q = new Solution(items, maxSeq);
		q.lis(q.items);
		assertEquals("test maxLength for array of 3", 2, q.getMaxLen());
		assertEquals("test maxIndex for array of 3", 2, q.getMaxIndex());
	}
	
	@Test
	public void test_six() {


		items.add(new HtWt(65, 40));
		items.add(new HtWt(67, 80));
		items.add(new HtWt(56, 50));
		items.add(new HtWt(60, 30));
		items.add(new HtWt(70, 60));
		items.add(new HtWt(80, 70));
		
		for (int i = 0; i < items.size(); i++){
			maxSeq.add(1);
		}
		Solution q = new Solution(items, maxSeq);
		q.lis(q.items);
		assertEquals("test maxLength for array of 6", 4, q.getMaxLen());
		assertEquals("test maxIndex for array of 6", 5, q.getMaxIndex());
	}
	
	@Test
	public void test_eight() {


		items.add(new HtWt(65, 40));
		items.add(new HtWt(67, 80));
		items.add(new HtWt(56, 50));
		items.add(new HtWt(60, 30));
		items.add(new HtWt(70, 60));
		items.add(new HtWt(80, 70));
		items.add(new HtWt(68, 90));
		items.add(new HtWt(69, 100));
		
		for (int i = 0; i < items.size(); i++){
			maxSeq.add(1);
		}
		Solution q = new Solution(items, maxSeq);
		q.lis(q.items);
		assertEquals("test maxLength for array of 8", 5, q.getMaxLen());
		assertEquals("test maxIndex for array of 8", 5, q.getMaxIndex());
	}

	@Test
	public void test_duplicate() {


		items.add(new HtWt(65, 40));
		items.add(new HtWt(67, 80));
		items.add(new HtWt(56, 50));
		items.add(new HtWt(60, 30));
		items.add(new HtWt(70, 60));
		items.add(new HtWt(80, 70));
		items.add(new HtWt(68, 90));
		items.add(new HtWt(69, 100));
		items.add(new HtWt(65, 45));
		items.add(new HtWt(62, 45));
		
		for (int i = 0; i < items.size(); i++){
			maxSeq.add(1);
		}
		Solution q = new Solution(items, maxSeq);
		q.lis(q.items);
		assertEquals("test maxLength for duplicate components", 5, q.getMaxLen());
		assertEquals("test maxIndex for duplicate components", 7, q.getMaxIndex());
	}
	
	@Test
	public void test_duplicate2() {


		items.add(new HtWt(65, 40));
		items.add(new HtWt(67, 80));
		items.add(new HtWt(56, 50));
		items.add(new HtWt(60, 30));
		items.add(new HtWt(70, 60));
		items.add(new HtWt(80, 70));
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
		assertEquals("test maxLength for duplicate components", 6, q.getMaxLen());
		assertEquals("test maxIndex for duplicate components", 8, q.getMaxIndex());
	}
}
