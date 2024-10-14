/** Leetcode 705
 * Design a HashSet without using any built-in hash table libraries.
 * Implement MyHashSet class:
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 */
package com.srbh.linkedlist;

import java.util.ArrayList;

public class MyHashSet {
	
	private ArrayList<Integer> list;
	
	public MyHashSet() {
		list = new ArrayList<>();
	}

	public void add(int key) {
		if(!list.contains(Integer.valueOf(key)))
			list.add(key);
	}

	public void remove(int key) {
		list.remove(Integer.valueOf(key));
	}

	public boolean contains(int key) {
		return list.contains(Integer.valueOf(key));
	}
}
