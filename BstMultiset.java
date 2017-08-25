import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	protected Node root;
	protected String nodeVal;
	protected String itemVal;
	public BstMultiset()	{
		root = null;
		nodeVal = null;
		itemVal = null;
	} // end of BstMultiset()

	public void add(T item) {
		root = inser(root, item);
	} // end of add()
	
	protected Node insert (Node root, T item){
		itemVal = item.toString();
		nodeVal = root.value.toString();
		if (root == null) {
			root = new Node(item);
		}
		else if (key < root.mKey) {
			root.leftChild = insert(root.leftChild, item);
		}
		else if (key > root.mKey) {
			root.rightChild = insert(root.rightChild, item);
		}
		else {
			root.instance ++;
		}
		return root;
	}
	
	public int search(T item) {
		// Implement me!
		
		// default return, please override when you implement this method
		return 0;
	} // end of add()

	public void removeOne(T item) {
		// Implement me!
		if(root != null){
			
		}
	} // end of removeOne()
	
	public void removeAll(T item) {
		// Implement me!
		if(root != null){
			
		}
	} // end of removeAll()

	public void print(PrintStream out) {
		// Implement me!
		if(root != null){
			
		}
	} // end of print()
	
	class Node{
		private T value;
		private int instance;
		private Node leftChild;
		private Node rightChild;
		
		public Node(T item){
			value = item;
			leftChild = null;
			rightChild = null;
			instance = 1;
		}
	}
} // end of class BstMultiset
