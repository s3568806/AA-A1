import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	protected Node listHead;
	protected String nodeVal;
	protected String itemVal;
	
	public SortedLinkedListMultiset() {
		// Implement me!
		
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
		
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		if(listHead != null){
			Node currNode = listHead;
			while(currNode != null){
				System.out.println(currNode.value + " | " + currNode.instance);
				currNode = currNode.nNext;
			}
		}
	} // end of print()
	
	private class Node{
		private T value;
		private int instance;
		private Node nNext;
		private Node nPrev;
		
		public Node(T item){
			value = item;
			nNext = null;
			nPrev = null;
			instance = 1;
		}
	}
} // end of class SortedLinkedListMultiset
