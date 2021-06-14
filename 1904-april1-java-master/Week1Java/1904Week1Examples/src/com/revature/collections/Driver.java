package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Driver {

	public static void main(String[] args) {
		System.out.println("====LISTS====");
		ArrayList l1 = new ArrayList();
		l1.add(1);
		l1.add("1");
		l1.add(true);
		System.out.println(l1);
		System.out.println(l1.remove(true));

		/*
		 * Generics -a generic enforces a type for a collection -this allows for more
		 * dynamic coding and compile time safety. -for example, determining that your
		 * array list will be a certain type at least allows you to rest assured that
		 * you can call particular methods on items in the list -generics are enclosed
		 * within the <>
		 */
		System.out.println("=====GENERIC LIST=====");
		List<Integer> nums = new ArrayList<>();
		nums.add(15);
		nums.add(new Integer(200));
		nums.add(38);
		nums.add(3278);
//		nums.add("String"); Can't do this because of generic
//		type enforcement
		System.out.println(nums);

		System.out.println(nums.get(2)); // retrieves at a
//		specific index
		System.out.println(nums.remove(1));// remove based on index
		System.out.println(nums.remove(new Integer(39)));
		// removal based on item in list
		System.out.println(nums);

		nums.set(1, 25);
		System.out.println(nums);// changes an exisiting index
		// to a new value

		System.out.println("===========Iterating through collections=========");
		for (Integer i : nums) {
			System.out.println(i);
		}

		Iterator it = nums.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
//		System.out.println(it.next()); NoSuchElementException

		// note that iterators can only go forward. if you want
//		to reset an iterator, you need a new one

		/*
		 * the list hierarchy provides another type of iterator it is one that supports
		 * both next AND prev, allowing for bidirectional movement. this is called the
		 * ListIterator
		 */

		System.out.println("=======ListIterator======");
		ListIterator li = nums.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}
		/*
		 * core methods to remember -add -remove -get -set
		 */

		System.out.println("===SETS===");
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(4);
		set.add(5);
		set.add(4);
		set.add(2);
		set.add(467);
		set.add(288);
		set.add(4567);
		set.add(55672);
		set.add(45687);
		set.add(258);

		set.remove(467);
		System.out.println(set);
		int count = 0;
		for (Integer i : set) {
			if (count == 3) {
				System.out.println(i);
				break;
			}
			count++;
		}
		//note that sets do not support random access
//		if you want a particular item, you would have
//		to loop through the set
		System.out.println(set.contains(4));
		
		/*
		 * core methods:
		 * -add
		 * -contains
		 * -remove
		 */
		
		System.out.println("====QUEUE====");
		Queue<Integer> q = new ArrayBlockingQueue<>(4); //queue of size 4
		q.offer(5); //offer inserts from the back of the queue
		q.offer(7);
		q.offer(8);
		q.offer(9);
		System.out.println(q);
		
		Integer result;
		while((result =q.poll())!=null) {//poll removes front of queue
			System.out.println(result);
			System.out.println(q);
		}

		q.offer(5);
		q.offer(8);
		q.offer(9);
		q.offer(2);
		
		System.out.println(q.peek());//see next titem in queue
//		without removing it
		System.out.println(q);
		
		/*
		 * core methods
		 * -offer/add
		 * -poll/remove
		 * -peek/element
		 */
		
		System.out.println("=====MAPS=====");
		Map<Integer,String> map = new HashMap<>();
		map.put(3, "treasure");
		map.put(6, "boot-e");
		map.put(1, "goggle-maps");
		map.put(3, "sassy intellisense");
		map.put(9, null);
		map.put(null, null);
		
		System.out.println(map.size());
		System.out.println(map.entrySet());
		System.out.println(map);
		//iteration through a map
		for(Integer i: map.keySet()) {
			System.out.println(map.get(i));
			//when using the get method, you input the
//			key and are returned the value
		}
		
		//Hash Tables
		Map<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "one");
		ht.put(2, "something");
		ht.put(3, "something else");
		ht.put(4, "something something");
//		ht.put(null, null);
//		ht.put(0, null); note that hashtables cannot have null values
		System.out.println(ht);
		
		/*
		 * Hashtable vs Hashmap
		 * -Hashmaps can support null keys or values
		 * -Hashtables support neither
		 * -Hashtables are considered a legacy class
		 * 		-legacy meaning that it isn't quite deprecated
		 * 		-it still has one unique use case
		 * 		-hashtables are synchronized, hashmaps are not
		 */
				
		

	}

}
