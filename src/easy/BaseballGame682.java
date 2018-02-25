package easy;

public class BaseballGame682 {
    public static void main(String[] args) {
        System.out.println(new BaseballGame682().calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(new BaseballGame682().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
    public int calPoints(String[] ops) {
        int[] scores = new int[ops.length];
        int index = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                if (index < 2) {
                    continue;
                }

                scores[index] = scores[index - 2] + scores[index - 1];
                index++;
                continue;
            }

            if (ops[i].equals("C")) {
                if (index == 0) {
                    continue;
                }

                index--;
                scores[index] = 0;
                continue;
            }

            if (ops[i].equals("D")) {
                if (index == 0) {
                    continue;
                }

                scores[index] = scores[index - 1] * 2;
                index++;
                continue;
            }

            scores[index] = Integer.parseInt(ops[i]);
            index++;
        }

        int score = 0;
        for (int i = 0; i < index; i++) {
            score += scores[i];
        }
        return score;
    }
}
