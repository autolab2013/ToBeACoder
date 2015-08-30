import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MaxComparator implements Comparator<Integer> {
	public MaxComparator() {}
	public int compare(Integer a, Integer b) {
		return b - a;
	}
}

class MinComparator implements Comparator<Integer> {
	public MinComparator() {}
	public int compare(Integer a, Integer b) {
		return a - b;
	}
}

public class Solution {
	public static void main(String[] args) {
//		ArrayList<Integer> list = medianSlidingWindow(nums, k);
//		System.out.println("median is :");
//		for(Integer i : list) {
//			System.out.println(i);
//		}
//		maxheapTest();
//		LintcodeTest();
		testPoll();
	}

	public static void LintcodeTest() {
		int[] nums = {148,1188,665,1269,1720,1723,738,32,60,1563,1248,1560,1146,1963,990,1703,1569,1723,1666,1987,1120,1305,481,1766,742,153,1435,211,1284,222,1548,317,1452,1093,567,1294,1717,1519,1799,457,458,570,753,1267,1872,596,451,1643,1679,983,1328,1154,1474,1794,774,1541,973,716,708,809,15,1260,426,1929,1074,1324,1166,872,22,476,429,354,1829,333,1107,1617,665,1466,1529,1803,270,1016,711,1843,1386,473,55,1565,589,599,84,1503,512,1642,111,367,422,180,711,1408,1305,1867,342,152,1727,1115,1566,436,1230,1243,71,1522,1253,927,62,267,918,466,136,1214};
		int k = 108;
		ArrayList<Integer> list = medianSlidingWindow(nums, k);
		System.out.println("median is :");
		for(Integer i : list) {
			System.out.println(i);
		}
	}

	public static void maxheapTest() {
		int[] nums = {148,1188,665,1269,1720,1723,738,32,60,1563,1248,1560,1146,1963,990,1703,1569,1723,1666,1987,1120,1305,481,1766,742,153,1435,211,1284,222,1548,317,1452,1093,567,1294,1717,1519,1799,457,458,570,753,1267,1872,596,451,1643,1679,983,1328,1154,1474,1794,774,1541,973,716,708,809,15,1260,426,1929,1074,1324,1166,872,22,476,429,354,1829,333,1107,1617,665,1466,1529,1803,270,1016,711,1843,1386,473,55,1565,589,599,84,1503,512,1642,111,367,422,180,711,1408,1305,1867,342,152,1727,1115,1566,436,1230,1243,71,1522,1253,927,62,267,918,466,136,1214};
		int k = 5;
		HashHeap max_heap = new HashHeap(new MaxComparator());
		for(int i=0; i<nums.length; i++) {
			max_heap.add(nums[i]);
			max_heap.printList();
			if(max_heap.size() > k) max_heap.remove(nums[i-k]);
			int poll = max_heap.poll();
			max_heap.printList();
			max_heap.add(poll);
			max_heap.printList();
		}
	}

	public static void simpleTest() {
//		int[] nums = {1,-2,-7,-7,-2,-10,-3,-4,-15};
//		HashHeap min_heap = new HashHeap(new MaxComparator());
//		for(int i=0; i<nums.length; i++) {
//			min_heap.add(nums[i]);
//			min_heap.printList();
//		}
//		System.out.println("test remove");
//		System.out.println("rm -15");
//		min_heap.remove(-15);
//		min_heap.printList();
//		System.out.println("rm -10");
//		min_heap.remove(-10);
//		min_heap.printList();
//		System.out.println("rm -7");
//		min_heap.remove(-7);
//		min_heap.printList();
//		System.out.println("rm -3");
//		min_heap.remove(-3);
//		min_heap.printList();
//		System.out.println("rm -7");
//		min_heap.remove(-7);
//		min_heap.printList();

//		HashHeap heap2 = new HashHeap(false);
//		heap2.add(min_heap.poll());
//		System.out.println("max: ");
//		heap2.printList();
//		System.out.println("max peek: "+heap2.peek());
//		System.out.println("min: ");
//		min_heap.printList();
//		heap2.add(min_heap.poll());
//		System.out.println("max peek: "+heap2.peek());
//		heap2.printList();
//		min_heap.printList();
	}

	public static void testPoll() {
		int[] nums = {148,1188,665,1269,1720,1723,738,32,60,1563,1248,1560,1146,1963,990,1703,1569,1723,1666,1987,1120,1305,481,1766,742,153,1435,211,1284,222,1548,317,1452,1093,567,1294,1717,1519,1799,457,458,570,753,1267,1872,596,451,1643,1679,983,1328,1154,1474,1794,774,1541,973,716,708,809,15,1260,426,1929,1074,1324,1166,872,22,476,429,354,1829,333,1107,1617,665,1466,1529,1803,270,1016,711,1843,1386,473,55,1565,589,599,84,1503,512,1642,111,367,422,180,711,1408,1305,1867,342,152,1727,1115,1566,436,1230,1243,71,1522,1253,927,62,267,918,466,136,1214};
		HashHeap max_heap = new HashHeap(new MaxComparator());
		HashHeap min_heap = new HashHeap(new MinComparator());
		for(int i=0; i<nums.length; i++) {
			max_heap.add(nums[i]);
//			min_heap.add(nums[i]);
		}
//		max_heap.printList();
		while(!max_heap.isEmpty()) {
			min_heap.add(max_heap.poll());
		}
//		max_heap.printList();
//		min_heap.printList();
		while(!min_heap.isEmpty()) {
			max_heap.add(min_heap.poll());
//			min_heap.add(max_heap.poll());
		}
//		max_heap.printList();
		for(int i=0; i<nums.length; i++) {
			nums[i] *= -1;
		}
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++) {
			System.out.println("sorted is "+nums[i] + ", ");
		}
		for(int i=0; i<nums.length; i++) {
			nums[i] *= -1;
		}
//		System.out.println("array [0]: "+nums[0]);
		for(int i=0; i<nums.length; i++) {
//			int poll = min_heap.poll();
			int poll = max_heap.poll();
			if(nums[i] != poll) {
				System.out.println("wrong, ["+i+"] should be " + nums[i]+ ", poll is " + poll);
//				min_heap.printList();
				max_heap.printList();
			}
		}
	}


	public static ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		// write your code here
		ArrayList<Integer> result = new ArrayList<>();
		HashHeap min_heap = new HashHeap(new MinComparator());
		HashHeap max_heap = new HashHeap(new MaxComparator());
		int i = 0;
		while(i < k) {
			if(max_heap.isEmpty() && min_heap.isEmpty()) max_heap.add(nums[i]);
			else if(!max_heap.isEmpty()) {
				if(nums[i] > max_heap.peek()) min_heap.add(nums[i]);
				else max_heap.add(nums[i]);
			} else {
				if(nums[i] < min_heap.peek()) max_heap.add(nums[i]);
				else min_heap.add(nums[i]);
			}
			if(max_heap.size() > min_heap.size() + 1) min_heap.add(max_heap.poll());
			if(min_heap.size() > max_heap.size()) max_heap.add(min_heap.poll());
			i++;
		}
		max_heap.printList();
		System.out.println("max size " + max_heap.size());
		min_heap.printList();
		System.out.println("min size " + min_heap.size());
		if(!max_heap.isEmpty()) result.add(max_heap.peek());
		while(i < nums.length) {
			int obsolete = nums[i-k];
			if(max_heap.contains(obsolete)) max_heap.remove(obsolete);
			else min_heap.remove(obsolete);
			if(max_heap.isEmpty() && min_heap.isEmpty()) max_heap.add(nums[i]);
			else if(!max_heap.isEmpty()) {
				if(nums[i] > max_heap.peek()) min_heap.add(nums[i]);
				else max_heap.add(nums[i]);
			} else {
				if(nums[i] < min_heap.peek()) max_heap.add(nums[i]);
				else min_heap.add(nums[i]);
			}
			if(max_heap.size() > min_heap.size() + 1) min_heap.add(max_heap.poll());
			if(min_heap.size() > max_heap.size()) max_heap.add(min_heap.poll());
			result.add(max_heap.peek());
			i++;
			max_heap.printList();
			System.out.println("max size " + max_heap.size());
			min_heap.printList();
			System.out.println("min size " + min_heap.size());
		}
		return result;
	}
}
