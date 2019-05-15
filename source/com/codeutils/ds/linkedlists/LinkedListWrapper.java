package com.codeutils.ds.linkedlists;

/**
 * This is the wrapper around basic Node object to 
 * give the Node object the function of a linked list
 * @author diyuser2
 *
 * @param <V>
 */
public class LinkedListWrapper <V> {
	private Node <V> firstNode;

	public Node <V> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node <V> firstNode) {
		this.firstNode = firstNode;
	}
	
	/**
	 * This iterate method will iterate over the entire linked list 
	 * and print out the data member 
	 */
	public void iterate(Node<V> p_node) {
		
		if (p_node.getNextNode()  == null) {// base case end of the linked list
			System.out.println(p_node.getData());
			return;
		} else {
			System.out.println(p_node.getData());
			iterate(p_node.getNextNode());
		}
	}
	
	/**
	 * This method will add a new node with data at a particular index
	 * has to make sure that pointers to next node and pointers of previous node
	 * is adjusted
	 * @param index
	 * @param data
	 */
	public void addAtIndex(int index, V data) {
		int count = 0;
		Node<V> newNode = Node.getInstance().setData(data);
		if (index == 0) {
			newNode.setNextNode(firstNode);
			firstNode= newNode;
		} else {
			Node<V> prevNode = firstNode;
			Node<V> nextNode = prevNode.getNextNode();
			count++;
			while (nextNode != null) {
				if (count == index) {
					prevNode.setNextNode(newNode);
					newNode.setNextNode(nextNode);
					break;
				}
				prevNode = nextNode;
				nextNode = nextNode.getNextNode();
				count ++;
			}
			if(nextNode == null && count != index) {
				System.out.println("index is out of bound for value="+index);
			}
		}
	}
	
	
	/**
	 * This method will remove the existing node at a particular index
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		int count = 0;
		if (index == 0) {
			Node<V> nextNode = firstNode.getNextNode();
			if(nextNode != null) {
				firstNode = nextNode;
			} else {
				firstNode = null;
				System.out.println("This means that our Linked List is empty");
			}
		} else {
			Node<V> prevNode = firstNode;
			Node<V> nextNode = prevNode.getNextNode();
			count++;
			while (nextNode != null) {
				if (count == index) {
					Node<V> nextNode2 = nextNode.getNextNode();
					prevNode.setNextNode(nextNode2);
					break;
				}
				prevNode = nextNode;
				nextNode = prevNode.getNextNode();
				count ++;
			}
			if(nextNode == null && count != index) {
				System.out.println("index is out of bound for value="+index);
			}
		}
	
		
	}

}
