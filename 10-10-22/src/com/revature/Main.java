package com.revature;

import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

	}

	// you can't access the nodes of a java linked list so I will just return the
	// index instead.
	public static int findIntersection(LinkedList A, LinkedList B) {
		// identity has map compares references not values of objects
		// unfortionatly there is not set implementation of this
		Map refs = new IdentityHashMap<>(A.size());

		// insert elements of A into map
		for (int i = 0; i < A.size(); i++) {

			Object temp = A.get(i);

			refs.put(temp, temp);
		}

		for (int i = 0; i < B.size(); i++) {
			
			Object temp = B.get(i);
			
			// references to the keys are the same;
			if (refs.containsKey(temp)) {
				return i;
			}
		}

		// return -1 if there is no intersection
		return -1;
	}

	// you can't access the nodes of a java linked list so I will just return the
	// index instead.

	public static int findLoop(LinkedList A, LinkedList B) {

		// identity has map compares references not values of objects
		// unfortionatly there is not set implementation of this
		Map refs = new IdentityHashMap<>(A.size());

		// put first element in
		refs.put(A.get(0), A.get(0));

		// check rest of elements and insert them
		for (int i = 0; i < A.size(); i++) {
			
			Object temp = A.get(i);
			
			//if refs contains element already return index
			if (refs.containsKey(temp)) {
				return i;
			}
			//put element into map
			refs.put(A.get(i), A.get(i));
		}

		// return -1 if there is no intersection
		return -1;
	}

}
