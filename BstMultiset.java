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
		if(root == null){
			root new Node(item);
		}
		else{
			insert(root, item);
		}
	} // end of add()
	
	private Node insert (Node root, T item){
		nodeVal = root.value.toString();
		itemVal = item.toString();
		if (root == null) {
			root = new Node(item);
		}
		else if (item < root.value) {
			root.leftChild = insert(root.leftChild, item);
		}
		else if (item > root.value) {
			root.rightChild = insert(root.rightChild, item);
		}
		else if (item == root.value){
			root.instance ++;
		}
		return root;
	}
	
	public int search(T item) {
		// Implement me!
		Node found = null;
		if(root != null){
			found = traverseTree(root, item);
			return found.instance;
		}
		else{
			return 0;
		}
	} // end of add()
	
	//function to traverse BST
	private Node traveseTree(Node root, T item){
		if(root.value == item || root == null){
			return root;
		}
		
		if(root.value < item){
			traverseTree(root.leftChild, item);
		}
		else{
			traverseTree(root.rightChild, item);
		}
	}

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
			print(root);
		}
	} // end of print()
	
	private void print(Node root){
		if(root == null){
			return;
		}
		System.out.println(root.value + " | " + root.instance);
		print(root.leftChild);
		print(root.rightChild);
	}
	
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
