package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
//import org.junit.Test;
//import org.testng.Assert;
//import javafx.application.Application;
import org.testng.annotations.Test;

public class Stream1 {
	// public static void main(String args[]) {
	// Count the number of names starting with alphabet A in list
	
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ankit");
		names.add("Abhishek");
		names.add("Banny");
		names.add("Deep");
		names.add("Adi");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {

			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}

		}
		System.out.println(count);
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anupm");
		names.add("Abhishek");
		names.add("Banny");
		names.add("Deep");
		names.add("Adi");

		long d = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(d);

		long e = Stream.of("Anupm", "Abhishek", "Banny", "Deep", "Adi").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(e);

		// names.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
		names.stream().filter(s -> s.length() > 3).limit(1).forEach(s -> System.out.println(s));

	}

	@Test

	// print name which have last letter as "a" with Uppercase
	public void streamMap() {

		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Ram");
		names1.add("Syam");
		names1.add("Raghu");
		names1.add("Suraj");
		names1.add("Gaman");

		Stream.of("Anupm", "Abhishek", "Banny", "Deep", "Adi").filter(s -> s.endsWith("p")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print names which have first letter as a with uppercase and sorted
		List<String> names = Arrays.asList("Anupm", "Abhishek", "Banny", "Deep", "Adi");
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Merging 2 different lists

		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		// newStream.forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Deep"));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test

	public void Streamcollect() {
		List<String> collect = Stream.of("Anupm", "Abhishek", "Banny", "Deep", "Adi").filter(s -> s.startsWith("A"))
				.sorted().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(collect.get(0));

		// Print unique number from this array
		// sort the array - 3 rd index - 3,2,1,3,7,9,1,6,7
		List<Integer> values = Arrays.asList(2, 9, 8, 1, 7, 9, 1, 6, 7);
//		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
