package com.npci.oops;

import java.util.Arrays;
import java.util.List;

public class TestComplexStreams {
	public static void main(String[] args) {
		List<Item> list = Arrays.asList(
				new Item(111, "Mobile", 15000, 3.2),
				new Item(112, "Mobile", 25000, 4.2),
				new Item(113, "Mobile", 35000, 4.8),
				new Item(114, "Laptop", 75000, 4.2),
				new Item(115, "Laptop", 125000, 4.9),
				new Item(116, "Laptop", 85000, 4.0),
				new Item(117, "Laptop", 95000, 4.3),
				new Item(118, "Camera", 215000, 3.2),
				new Item(99, "Camera", 115000, 4.2),
				new Item(88, "Camera", 125000, 4.0),
				new Item(120, "Camera", 135000, 4.6)
				);
		System.out.println("-----Simple ForEach for iterating---------");
		list.forEach(x -> System.out.println(x));
		// filter based on the ratings & price
		System.out.println("----- Items having 4+ ratings and price between 70000 to 150000----");
		list.stream()
			.filter(x -> x.getPrice() >= 70000 && x.getPrice() <= 150000)
			.filter(x -> x.getRatings() > 4)
			.sorted((x, y) -> Double.compare(x.getPrice(), y.getPrice()))
			.forEach(x -> System.out.println(x));
		// to the above filter apply sorted(Comparator) method: sort based on price
		// map is used to transform from one to type another type
		System.out.println("---- Item to String ----");
		// distinct removes duplicate values
		List<String> itemNames = list.stream().map(x -> x.getName()).distinct().toList();
		itemNames.forEach(item -> System.out.println(item));
		// counting the results
		long count = list.stream().filter(x->x.getPrice()>100000).count();
		System.out.println("Count of items > 100000: "+count);
		// Convert each Item object into Product object that will have only name & price + tax
		// display all the products having name & price in a separate List<Product>
		System.out.println("--- Transform Item to Product with tax ----");
		List<Product> products = list.stream()
				.map(item -> new Product(item.getName(), Math.round(item.getPrice() * 1.09))).toList();
		products.forEach(product -> System.out.println(product));
	}
}
