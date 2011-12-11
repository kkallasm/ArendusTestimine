package kodune_yl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SortedSet ss = new SortedSet();
		ss.add("a");
		ss.add("s");
		ss.add("d");
		ss.add("a");
		ss.add("66");
		
		List list = new ArrayList<Object>();
		list.add("a");
		list.add("s");
		list.add("a");
		
		List list2 = new ArrayList<Object>();
		list2.add("ddd");
		list2.add("a");
		list2.add("a");
		
		System.out.println(Arrays.toString(ss.asList().toArray()));
		ss.retainAll(list);
		System.out.println(Arrays.toString(ss.asList().toArray()));
		

	}

}
