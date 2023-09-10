import java.util.Stack;

public class StringReverser {

    public StringBuffer reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (var ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reversedString = new StringBuffer();
        while (!stack.empty())
            reversedString.append(stack.pop());

        return reversedString;
    }
}
