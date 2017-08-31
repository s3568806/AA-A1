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
			root = new Node(item);
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
		else if (itemVal.compareTo(nodeVal) < 0) {
			root.leftChild = insert(root.leftChild, item);
		}
		else if (itemVal.compareTo(nodeVal) > 0) {
			root.rightChild = insert(root.rightChild, item);
		}
		else if (nodeVal.compareTo(itemVal) == 0){
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

	public void removeOne(T item) {
		// Implement me!
		Node found == null;
		if(root != null){
			found = traverseTree(root, item);
			if(found.instance > 0){
				found.instance --;
			}
		}
	} // end of removeOne()
	
	//function to traverse BST
	private Node traverseTree(Node root, T item){
		nodeVal = root.value.toString();
		itemVal = item.toString();
		if(itemVal.compareTo(nodeVal) == 0 || root == null){
			return root;
		}
		else if(itemVal.compareTo(nodeVal) < 0){
			root = traverseTree(root.leftChild, item);
			return root;
		}
		else{
			root = traverseTree(root.rightChild, item);
			return root;
		}
	}
	
	public void removeAll(T item) {
		Node found = null;
		if(root != null){
			found = traverseTree(root, item);
			//Case 1: the deleted node has no children
			if(found.leftChild == null && found.rightChild == null){
				found == null;
			}
			//Case 2: the deleted node has one child
			else if(found.leftChild == null && found.rightChild != null){
				if(found == root){
					root = null;
					root = found.rightChild;
				}
				
			}
			else if(found.leftChild != null && found.rightChild == null){
				if(found == root){
					root = null;
					root = found.leftChild;
				}
				
			}
			//Case 3: the deleted node has two children
		}
	} // end of removeAll()

	public void print(PrintStream out) {
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
