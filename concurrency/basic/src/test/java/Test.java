import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            if (s.equals("b"))
            list.remove("b");
        }
        System.out.println("ahah");

    }

    private static void swap(int a, int b) {
        a = 0;
        b = 0;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, result, "");
        return result;
    }

    public static void generateParenthesis(int n, int leftCount, int rightCount, List<String> result, String temp) {
        if (rightCount == n) {
            result.add(temp);
            return;
        }
        if (leftCount < n) {
            leftCount++;
            generateParenthesis(n, leftCount, rightCount, result, temp + "(");
            leftCount--;
        }
        if (rightCount < leftCount) {
            rightCount++;
            generateParenthesis(n, leftCount, rightCount, result, temp + ")");
        }


    }
}
