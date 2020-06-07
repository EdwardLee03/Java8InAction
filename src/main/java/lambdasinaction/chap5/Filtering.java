package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 过滤操作
 */
public class Filtering {

    public static void main(String... args) {

        // 实例方法引用函数对象
        // Filtering with predicate
        List<Dish> vegetarianMenu =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // Truncating a stream
        List<Dish> dishesLimit3 =
                Dish.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(Collectors.toList());
        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 =
                Dish.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(Collectors.toList());
        dishesSkip2.forEach(System.out::println);
    }
}
