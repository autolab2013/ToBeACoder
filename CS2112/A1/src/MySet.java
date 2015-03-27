import java.util.HashSet;


public class MySet {
	private HashSet<Integer> seta;
	private HashSet<Integer> setb;
	private HashSet<Integer> union;
	private HashSet<Integer> intersection;
	
	public MySet(int[] a, int[] b){
		union = new HashSet<Integer>();
		intersection = new HashSet<Integer>();
		for(int i=0;i<a.length;i++){
			seta.add(a[i]);
		}union = seta;
		intersection = seta;
		for(int i=0;i<b.length;i++){
			union.add(b[i]);
			setb.add(b[i]);
		}
	}
	
	public HashSet<Integer> getUnion(){
		return union;
	}
	
	public HashSet<Integer> getIntersection(int[] a, int[] b){
		intersection.retainAll(setb);
		return intersection;
	}
}
