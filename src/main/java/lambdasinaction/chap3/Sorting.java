package lambdasinaction.chap3;

import java.util.*;

/**
 * Chapter 3: Lambda expressions / λ表达式、匿名表达式、匿名函数
 */
public class Sorting {

    public static void main(String...args){

        // 1、比较器对象
        List<Apple> inventory = new ArrayList<>(Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"))
        );

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, "green"));
        
        // 2、比较器匿名对象
        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight()); 
        }});
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, "red"));
        
        // 3、lambda表达式、匿名表达式
        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        
        // reshuffling things a little
        inventory.set(1, new Apple(10, "red"));
        
        // 4、匿名函数对象
        // [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);       
    }

    public static class Apple {
        private final Integer weight;
        private final String color;

        public Apple(Integer weight, String color){
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

    /**
     * 苹果比较器
     */
    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
