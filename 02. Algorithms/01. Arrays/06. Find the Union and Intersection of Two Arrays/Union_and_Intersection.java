import java.util.*;

public class UnionAndIntersection {

	public static void main(String[] args) {
		int arr1[] = { 7, 1, 5,5, 2, 3, 6,11,18 };
        	int arr2[] = { 3, 8, 6,5, 20, 7,18 };
		
		Set<Integer> union=new HashSet<>();
		for(int val:arr1) {
			union.add(val);
		}
		for(int val:arr2) {
			union.add(val);
		}
		System.out.println("Union= "+union);
		union.clear();// clearing union set to reuse for finding intersection
		for(int val:arr1) {
			union.add(val);
		}
		Set<Integer> intersection=new HashSet<>();
		for(int val:arr2) {
			intersection.add(val);
		}
		intersection.retainAll(union); // https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
		System.out.println("Intersection= "+intersection);
	}
}
