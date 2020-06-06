package lambdasinaction.chap2;

import java.util.*;

/**
 * Chapter 2: Passing code with behavior parameterization / 传递具有参数化行为的代码
 */
public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(
				new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(120, "red")
		);

		// JDK 7 之前版本写法
		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// 匿名实现类对象(JDK 7 之前版本写法)
		// [Apple{color='red', weight=120}]
		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean test(Apple a){
				return "red".equals(a.getColor());
			}
		});
		System.out.println(redApples2);
	}

	// JDK 7 之前版本写法

	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>(inventory.size());
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>(inventory.size());
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>(inventory.size());
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
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

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}

	// 函数式接口

	/**
	 * 具体类型的过滤操作函数接口。
	 * @see java.util.function.Predicate
	 */
	@FunctionalInterface
	interface ApplePredicate{
		boolean test(Apple a);
	}

	// 谓词函数对象类

	static class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
	static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
}
