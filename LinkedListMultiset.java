import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{	
	protected Node listHead;
	protected String itemVal;
	protected String nodeVal;
	public LinkedListMultiset() {
		listHead = null;
		itemVal = null;
		nodeVal = null;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		if(listHead == null){
			Node model = new Node(item);
			listHead = model;
		}
		else{
			Node currNode = listHead;
			itemVal = item.toString();
			int check = 0;
			while(currNode != null){
				nodeVal = currNode.value.toString();
				if(nodeVal.compareTo(itemVal) == 0){
					check = 1;
					currNode.instance ++;
				}
				currNode = currNode.nNext;
			}
			if(check == 0){
				Node model = new Node(item);
				currNode = listHead;
				while(currNode.nNext != null){
					currNode = currNode.nNext;
				}
				currNode.nNext = model;
				model.nPrev = currNode;
			}
		}
	} // end of add()
	
	
	public int search(T item) {
		if(listHead != null){
			Node currNode = listHead;
			itemVal = item.toString();
			int found = 0;
			while(currNode != null){
				nodeVal = currNode.value.toString();
				if(nodeVal.compareTo(itemVal) == 0){
					found = 1;
					break;
				}
				currNode = currNode.nNext;
			}
			if(found == 1){
				return currNode.instance;
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
	} // end of add()
	
	
	public void removeOne(T item) {
		if(listHead != null){
			Node currNode = listHead;
			itemVal = item.toString();
			while(currNode != null){
				nodeVal = currNode.value.toString();
				if(nodeVal.compareTo(itemVal) == 0){
					if(currNode.instance > 0){
						currNode.instance--;
					}
				}
				currNode = currNode.nNext;
			}
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		if(listHead != null){
			Node currNode = listHead;
			Node nextNode = null;
			Node prevNode = null;
			itemVal = item.toString();
			while(currNode != null){
				nextNode = currNode.nNext;
				prevNode = currNode.nPrev;
				nodeVal = currNode.value.toString();
				if(nodeVal.compareTo(itemVal) == 0 && currNode == listHead){
					listHead = currNode.nNext;
					currNode = null;
					currNode = nextNode;
				}
				else if(nodeVal.compareTo(itemVal) == 0){
					prevNode.nNext = nextNode;
					nextNode.nPrev = prevNode;
					currNode = null;
					currNode = nextNode;
				}
				else if(nodeVal.compareTo(itemVal) == 0 && currNode.nNext == null){
					currNode = null;
				}
				else{
					currNode = currNode.nNext;
				}
			}
		}
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
} // end of class LinkedListMultiset
