package com.npci.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSimpleStreams {
	public static void main(String[] args) {
		// collection with integer values
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println(integers);
		// a new list to maintain only the numbers divisible by 3
		// old approach
		List<Integer> integers3 = new ArrayList<>();
		for(int x : integers) {
			if(x % 3 == 0) {
				integers3.add(x);
			}
		}
		System.out.println("-------------------------------");
		System.out.println(integers3);
		// using streams
		List<Integer> items = integers.stream().filter(x -> x % 3 == 0).toList();
		System.out.println("-------------------------------");
		System.out.println(items);
	}
}
