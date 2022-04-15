package strRotate;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringRotation {

    public static String input = "animal";

    public static void main(String[] args) {
        for (String line : scrollingText(input)){
            System.out.println(line);
        }
        System.out.println(Arrays.toString(scrollingText(input)));
        System.out.println(Arrays.toString(scrollingText_stream(input)));
    }

    public static String[] scrollingText(String text) {
        String[] result = new String[text.length()];
        StringBuilder stringBuilder = new StringBuilder(text.toUpperCase());
        for (int i = 0; i < result.length; i++) {
            result[i] = stringBuilder.toString();
            stringBuilder.append(stringBuilder.charAt(0)).deleteCharAt(0);
        }
        return result;
    }

    public static String[] scrollingText_stream(String text) {
        return IntStream.range(0, text.length())
                .mapToObj(i -> text.substring(i).toUpperCase() + text.substring(0, i).toUpperCase())
                .toArray(String[]::new);
    }
}
