package kodune_yl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortedSetTests {
	
	//TODO exception testid
	
	SortedSet ss;
	
	@Before
	public void sortedSet() throws Exception{
		ss = new SortedSet();
		ss.add(1);
		ss.add(2);
		ss.add(3);
		ss.add("a");
		ss.add("b");
	}

	
	@Test
	public void addRemove_test() {
		
		assertEquals(5, ss.size());
		ss.add(3);
		assertEquals(5, ss.size());
		ss.remove(2);
		assertEquals(4, ss.size());
		assertEquals(true, ss.contains(1));
		assertEquals(false, ss.contains(2));
		assertArrayEquals(Arrays.asList(1,3,"a","b").toArray(), ss.asList().toArray());			
	}
	
	@Test
	public void containsAll_test(){		
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add("a");
		
		assertEquals(true, ss.containsAll(list));
		
		list.add(9);
		
		assertEquals(false, ss.containsAll(list));	
	}
	
	@Test
	public void removeAll_test(){
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add("a");
		list.add("a");
		
		ss.removeAll(list);
		
		assertEquals(3, ss.size());
		assertArrayEquals(Arrays.asList(2,3,"b").toArray(), ss.asList().toArray());
	}
	
	@Test
	public void retainAll_test(){
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add("a");
		list.add("a");
		
		ss.retainAll(list);
		
		assertEquals(2, ss.size());
		assertArrayEquals(Arrays.asList(1,"a").toArray(), ss.asList().toArray());
		//System.out.println("ss: "+Arrays.toString(ss.asList().toArray()));
	}
	
}
