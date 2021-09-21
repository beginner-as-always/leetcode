package arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class BinomialCoefficient {
    public static void main(String[] args) {
        System.out.println(binomialCoefficients(4));
    }

    static List<Integer> binomialCoefficients(int n) {
        List<Integer> result = new ArrayList<>();

        for (int m = 0; m <= n; m++) {
            int k = Math.min(m, n - m);
            int prod = 1;

            for (int i = 0; i < k; i++) {
                prod = prod * (n - i) / (i + 1);
            }

            result.add(prod);
        }

        return result;
    }
}
