package lambdasinaction.chap3;

import java.util.*;

/**
 * Chapter 3: Lambda expressions / λ表达式、匿名表达式、匿名函数
 */
public class Lambdas {
	public static void main(String ...args){
		// 匿名类对象
		// Simple example
		Runnable r = () -> System.out.println("Hello!");
		r.run();

		// Filtering with lambdas
		List<Apple> inventory = Arrays.asList(
				new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(120, "red")
		);

		// 过滤操作函数
		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println(greenApples);

		// 对象比较函数
		// Comparator.comparing(Apple::getWeight)
		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
		inventory.sort(c);
		System.out.println(inventory);
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>(inventory.size());
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}   

	public static class Apple {
		private final int weight;
		private final String color;

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public String getColor() {
			return color;
		}

		@Override
		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}

	interface ApplePredicate{
		boolean test(Apple a);
	}
}