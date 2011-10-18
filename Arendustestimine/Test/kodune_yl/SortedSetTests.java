package kodune_yl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortedSetTests {
	
	//TODO tükkideks teha + exception testid

	@Test
	public void sortedSet() throws Exception {
		SortedSet ss = new SortedSet();
		ss.add(new Integer(5));
		ss.add(new Integer(4));
		ss.add(new Integer(3));
		assertEquals(3, ss.size());
		ss.remove(5);
		assertEquals(2, ss.size());
		assertArrayEquals(Arrays.asList(4, 3).toArray(), ss.asList().toArray());
		assertEquals(true, ss.contains(4));
		
		ss.add("a");
		ss.add("s");
		ss.add("d");
		ss.add("a");
		ss.add("66");
		assertEquals(6, ss.size());
		
		List list = new ArrayList<Object>();
		list.add("d");
		list.add("a");
		
		assertEquals(true, ss.containsAll(list));
		
		List list2 = new ArrayList<Object>();
		list2.add("ddd");
		list2.add("a");
		list2.add("a");
		
		System.out.println("Enne: "+Arrays.toString(ss.asList().toArray()));
		
		//assertEquals(false, ss.containsAll(list2));
		//ss.removeAll(list);
		ss.retainAll(list);
		
		System.out.println("Pärast: "+Arrays.toString(ss.asList().toArray()));
		//assertEquals(4, ss.size());
		
	}
	
}
