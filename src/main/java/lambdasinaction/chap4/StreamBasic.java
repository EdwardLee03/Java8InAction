package lambdasinaction.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Chapter 4: Working with Streams / 数据流操作
 */
public class StreamBasic {

    public static void main(String... args) {
        // 实例方法函数对象
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu)
                .forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu)
                .forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>(dishes.size());
        // for-each
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>(lowCaloricDishes.size());
        // lowCaloricDishes.sort((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()))
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
