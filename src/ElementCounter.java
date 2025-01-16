import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ElementCounter {

    public static <T> Map<T, Long> countElements(T[] array) {
        if (array == null || array.length == 0) {
            return Map.of(); // Возвращаем пустую Map для пустого или null массива
        }
        return Arrays.stream(array)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {

        String[] stringArray = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Long> stringCounts = countElements(stringArray);
        System.out.println("String counts: " + stringCounts);
        // Вывод: String counts: {banana=2, cherry=1, apple=3}


        Integer[] intArray = {1, 2, 3, 2, 1, 1, 4, 5, 4};
        Map<Integer, Long> intCounts = countElements(intArray);
        System.out.println("Integer counts: " + intCounts);
        // Вывод: Integer counts: {1=3, 2=2, 3=1, 4=2, 5=1}


        String[] emptyArray = {};
        Map<String, Long> emptyCounts = countElements(emptyArray);
        System.out.println("Empty counts: " + emptyCounts);
        // Вывод: Empty counts: {}


        Map<String, Long> nullCounts = countElements(null);
        System.out.println("Null counts: " + nullCounts);
        // Вывод: Null counts: {}
    }
}