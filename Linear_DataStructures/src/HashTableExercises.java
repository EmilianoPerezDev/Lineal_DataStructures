import java.util.*;
import java.util.HashMap;

public class HashTableExercises {

    public char mostRepeatedChar(String input) {
        if (input == null || input.isEmpty())
            return Character.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();
        var chars = input.trim().toCharArray();
        for (var ch : chars) {
            var value = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, value + 1);
        }

        var count = 0;
        char mostRepeatedChar = ' ';
        for (var ch : chars) {
            if (map.get(ch) > count) {
                count = map.get(ch);
                mostRepeatedChar = ch;
            }
        }

        return mostRepeatedChar;
    }

    public int countPairsWithDiff(int[] numbers, int difference) {
        if (numbers.length < 2)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (var number : numbers)
            set.add(number);

        var count = 0;
        for (var number : numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }

        return count;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        return null;
    }

}