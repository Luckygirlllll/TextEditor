/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals("Remove: check element 0 is correct ", (Integer)42, list1.get(1));
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.remove(5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		shortList.add("C");
		emptyList.add(1);
	
		assertEquals("check is it a correct adding of the element","C", shortList.get(2));
		assertEquals("check is it a correct adding of the element", (Integer)1, emptyList.get(0));
		assertEquals("check size is correct ", 3, shortList.size());
		
        // TODO: implement this test
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("check size is correct ", 3, list1.size());
		assertEquals("check size is correct ", 0, emptyList.size());
		assertEquals("check size is correct ", 2, shortList.size());
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		shortList.add(1,"C");
		assertEquals("check is it a correct adding of the element","C", shortList.get(1));
		assertEquals("check is it a correct adding of the element","B", shortList.get(2));
		assertEquals("check size is correct ", 3, shortList.size());
		try {
			shortList.add(-1,"G");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(5,"G");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
        // TODO: implement this test
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try {
			shortList.set(-1, "D");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(5,"E");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		shortList.set(1,"G");
		assertEquals("check is it a correct adding of the element","G", shortList.get(1));
		assertEquals("check is it a correct adding of the element","A", shortList.get(0));
		assertEquals("check size is correct ", 2, shortList.size());
	    // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
