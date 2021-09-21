package arrayandstring;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";

        System.out.println("Input:  " + input);
        System.out.println("Output: " + reverseWords(input));
    }

    static String reverseWords(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0, j = 0; i < chars.length; ) {
            if (chars[i] != ' ') {
                while (j < chars.length && chars[j] != ' ') j++;
                reverse(chars, i, j - 1);
                i = j;
            }
            else j = ++i;
        }

        return String.valueOf(chars);
    }

    static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
