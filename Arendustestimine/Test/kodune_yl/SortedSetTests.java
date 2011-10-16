package kodune_yl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SortedSetTests {

	@Test
	public void sortedSet() throws Exception {
		SortedSet ss = new SortedSet();
		ss.add(new Integer(5));
		ss.add(new Integer(4));
		ss.add(new Integer(3));
		assertEquals(3, ss.size());
		ss.remove(5);
		assertEquals(2, ss.size());
		assertEquals(2, ss.asList().size());
		assertArrayEquals(Arrays.asList(4, 3).toArray(), ss.asList().toArray());
	}
	
}
