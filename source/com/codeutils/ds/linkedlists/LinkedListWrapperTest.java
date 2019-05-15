package com.codeutils.ds.linkedlists;

import org.junit.Before;
import org.junit.Test;

public class LinkedListWrapperTest {
	
	LinkedListWrapper<String> linkedListWrapper = new LinkedListWrapper<String>();
	
	@Before
	public void setup() {
		initializeLinkedList();
	}

	@Test
	public void testGetFirstNode() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetFirstNode() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIterate() {
		linkedListWrapper.iterate(linkedListWrapper.getFirstNode());
	}

	private void initializeLinkedList() {
		Node <String> firstNode = Node.getInstance().setData("one");
		Node <String> secondNode = Node.getInstance().setData("two");
		Node <String> thirdNode = Node.getInstance().setData("three");
		Node <String> fourthNode = Node.getInstance().setData("four");
		firstNode.setNextNode(secondNode);
		secondNode.setNextNode(thirdNode);
		thirdNode.setNextNode(fourthNode);
		// set the first node
		linkedListWrapper.setFirstNode(firstNode);
		
	}

	@Test
	public void testAddAtIndex() {
		linkedListWrapper.addAtIndex(2, "newNode");
		linkedListWrapper.addAtIndex(4, "newNodeAgain");
		linkedListWrapper.addAtIndex(0, "startNode");
		linkedListWrapper.addAtIndex(50, "dodgyNode");
		linkedListWrapper.iterate(linkedListWrapper.getFirstNode());
	}

	@Test
	public void testDeleteFromIndex() {
		linkedListWrapper.deleteFromIndex(0);
		linkedListWrapper.deleteFromIndex(5);
		// in order to iterate over a linked list we always start with the first node
		linkedListWrapper.iterate(linkedListWrapper.getFirstNode()); 
	}

}
