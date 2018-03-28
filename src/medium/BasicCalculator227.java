package medium;

public class BasicCalculator227 {
    public static void main(String[] args) {
        BasicCalculator227 calculator = new BasicCalculator227();
        System.out.println(calculator.calculate("3 + 2 * 3 * 4 / 3 + 3"));
        System.out.println(calculator.calculate("3 * 2"));
    }

    public int calculate(String s) {
        int n = 0;
        int n1 = 0;
        int n2 = 0;

        char c;
        for (int i = 0, len = s.length(); i < len; i++) {
            c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (c == '+' || c == '-') {
                boolean inc = c == '+';
                for (i++; i < len; i++) {
                    c = s.charAt(i);
                    if (c == ' ') {
                        continue;
                    }

                    if (c == '+' || c == '-') {
                        i--;
                        break;
                    }

                    if (c == '*' || c == '/') {
                        boolean mul = c == '*';
                        for (i++; i < len; i++) {
                            c = s.charAt(i);
                            if (c == ' ') {
                                continue;
                            }

                            if (c == '+' || c == '-' || c == '*' || c == '/') {
                                i--;
                                break;
                            }

                            n2 = n2 * 10 + (c - '0');
                        }

                        n1 = mul ? (n1 * n2) : (n1 / n2);
                        n2 = 0;
                        continue;
                    }

                    n1 = n1 * 10 + (c - '0');
                }

                n = inc ? (n + n1) : (n - n1);
                n1 = 0;
                continue;
            }

            if (c == '*' || c == '/') {
                boolean mul = c == '*';
                for (i++; i < len; i++) {
                    c = s.charAt(i);
                    if (c == ' ') {
                        continue;
                    }

                    if (c == '+' || c == '-' || c == '*' || c == '/') {
                        i--;
                        break;
                    }

                    n1 = n1 * 10 + (c - '0');
                }

                n = mul ? (n * n1) : (n / n1);
                n1 = 0;
                continue;
            }

            n = n * 10 + (c - '0');
        }

        return n;
    }
}
