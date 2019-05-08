package com.codeutils.ds.linkedlists;

/**
 * This class represents the Node class which will hold 
 * the general structure of the Linked List Node
 * @author diyuser2
 *
 * @param <V>
 */

public class Node<V> {
 private V data;
 private Node<V> nextNode;
 
 public Node <V> setData(V value){
	 this.data = value;
	 return this;
 }
 
 
 public Node <V> setNextNode(Node p_node){
	 this.nextNode = p_node;
	 return this;
 }
 
 public Node<V> getNextNode(){
	 return this.nextNode;
 }
 
 public V getData() {
	 return this.data;
 }
 
 private Node() {
	 
 }
 public static Node getInstance (){
	 Node node = new Node();
	 return node;
 }
 
	
}
