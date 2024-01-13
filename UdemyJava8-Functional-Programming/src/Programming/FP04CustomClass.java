package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Courses{
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	@Override
	public String toString() {
		return "Courses [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudent="
				+ noOfStudent + "]";
	}
	public Courses(String name, String category, int reviewScore, int noOfStudent) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudent = noOfStudent;
	}
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

public class FP04CustomClass {
	public static void main (String args[]) {

		List<Courses> courses = List.of(
				new Courses("Spring Boot","Cloud",91,100),
				new Courses("Spring","Framework",92,110),
				new Courses("Kubernetes","Cloud",93,120),
				new Courses("Java","Framework",94,130),
				new Courses("python","Framework",95,140));
		
		
		//allMatch,anyMatch and NoneMatch
		Predicate<? super Courses> reviewScorGreaterNinty = course -> course.getReviewScore() > 90;
		Predicate<? super Courses> reviewScorGreaterNintyFive = course -> course.getReviewScore() > 95;
		Predicate<? super Courses> reviewScorGreater99 = course -> course.getReviewScore() > 99;

		System.out.println(courses.stream().allMatch(reviewScorGreaterNinty));
		System.out.println(courses.stream().noneMatch(reviewScorGreaterNintyFive));
		System.out.println(courses.stream().anyMatch(reviewScorGreater99));
		
		//sorting
		
		Comparator<Courses> sortingIncreasing=Comparator.comparing(Courses::getNoOfStudent);
		Comparator<Courses> sortingDesc=Comparator.comparing(Courses::getReviewScore).reversed();

		Comparator<Courses> sortingComparator=Comparator.comparing(Courses::getReviewScore)
				.thenComparing(Courses::getNoOfStudent).reversed();

		System.out.println(courses.stream().sorted(sortingIncreasing).collect(Collectors.toList()));
		System.out.println(courses.stream().sorted(sortingDesc).collect(Collectors.toList()));
		System.out.println(courses.stream().sorted(sortingComparator).collect(Collectors.toList()));
		
		//Limit upto 2 data
		System.out.println(courses.stream().sorted(sortingIncreasing)
				.limit(2).collect(Collectors.toList()));
		//skip to 3 data
		System.out.println(courses.stream().sorted(sortingIncreasing)
				.skip(2).collect(Collectors.toList()));
		
		//take While it will fetch data until condition satisfy after it will break

		System.out.println(courses.stream().takeWhile(course -> course.getReviewScore() <=92).collect(Collectors.toList()));
		//drop while it will skip the data 
		System.out.println(courses.stream().dropWhile(course -> course.getReviewScore() <=92).collect(Collectors.toList()));
		
		//top score with the comparator max will return last element in the list
		System.err.println(courses.stream().max(sortingComparator));
		//min will return first element
		System.err.println(courses.stream().min(sortingComparator));
		//optional empty handle
		System.out.println(courses.stream().filter(reviewScorGreater99).max(sortingComparator));
//		Optional.empty
		System.out.println(courses.stream().filter(reviewScorGreater99).max(sortingComparator)
				.orElse(new Courses("API","Framework",96,1000)));
		
		//find First it will return first element in the list
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).findFirst());

		//find any will return any of the elemet in the list
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).findAny());
		
		// Total no of students in courses
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).mapToInt(Courses::getNoOfStudent).sum());
		// Average no of students in courses
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).mapToInt(Courses::getNoOfStudent).average());
		//count of courses
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).mapToInt(Courses::getNoOfStudent).count());
		//max and min of students
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).mapToInt(Courses::getNoOfStudent).max());
		System.out.println(courses.stream().filter(reviewScorGreaterNinty).mapToInt(Courses::getNoOfStudent).min());
		
		
		//group of courses base on category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Courses::getCategory,Collectors.counting())));
		System.out.println(courses.stream().collect(Collectors.groupingBy(Courses::getCategory,Collectors.maxBy(
				Comparator.comparing(Courses::getReviewScore)))));
		//map only by the name
		System.out.println(courses.stream().
				collect(Collectors.groupingBy(Courses::getCategory,
				Collectors.mapping(Courses::getName, Collectors.toList()))));
		
		//To create stream with range of 1 to 99
		System.out.println(IntStream.range(1, 100).sum());
		//To create stream with range of 1 to 100
		System.out.println(IntStream.rangeClosed(1, 100).sum());
		
		//First 10 elements to print even number and sum
		System.out.println(IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum());
		
		//First 10 elements to print power of number 2 and sum
		System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum());
		
		List<Integer> squareOfNumList = IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());
		System.out.println(squareOfNumList);

	}

}
