package medium;

import java.util.*;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] case1 = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        println(new Solution2().reconstructQueue(case1));

        int[][] case2 = {{71, 16}, {60, 30}, {26, 69}, {24, 10}, {99, 0}, {5, 52}, {88, 0}, {76, 0}, {61, 18}, {68, 30}, {90, 11}, {11, 34}, {44, 10}, {28, 28}, {68, 20}, {83, 2}, {69, 11}, {81, 15}, {6, 6}, {0, 71}, {58, 22}, {84, 15}, {50, 29}, {5, 25}, {16, 50}, {64, 13}, {39, 15}, {24, 48}, {95, 8}, {99, 2}, {36, 33}, {10, 44}, {82, 10}, {13, 79}, {81, 12}, {97, 1}, {40, 3}, {31, 48}, {66, 33}, {46, 20}, {90, 1}, {1, 52}, {42, 18}, {4, 2}, {90, 3}, {28, 6}, {62, 21}, {99, 3}, {5, 48}, {55, 16}, {30, 32}, {70, 3}, {33, 49}, {99, 1}, {82, 7}, {73, 15}, {43, 1}, {72, 6}, {59, 36}, {18, 6}, {25, 16}, {96, 0}, {8, 54}, {44, 25}, {17, 10}, {4, 38}, {37, 37}, {29, 0}, {86, 5}, {79, 12}, {52, 26}, {54, 11}, {73, 22}, {99, 4}, {24, 45}, {7, 32}, {43, 23}, {30, 51}, {13, 4}, {68, 15}, {17, 11}, {11, 43}, {38, 3}, {63, 28}, {48, 18}, {40, 28}, {36, 40}, {22, 44}, {43, 6}, {4, 9}, {78, 10}, {94, 5}, {69, 2}, {26, 39}, {96, 7}, {22, 37}, {22, 30}, {65, 17}, {63, 1}, {20, 41}};
        println(new Solution2().reconstructQueue(case2));
    }

    private static void println(int[][] people) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < people.length; ++i) {
            builder.append("[").append(people[i][0]).append(",").append(people[i][1]).append("], ");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if (ints[0] < t1[0]) {
                        return 1;
                    } else if (ints[0] == t1[0]) {
                        if (ints[1] > t1[1]) {
                            return 1;
                        } else if (ints[1] == t1[1]) {
                            return 0;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            });

            for (int i = 1; i < people.length; ++i) {
                int index = people[i][1];
                int j = 0;
                for (; j < i && index > 0; ++j) {
                    if (people[j][0] >= people[i][0]) {
                        index--;
                    }
                }

                if (index == 0 && i != j) {
                    for (int k = j; k < i; ++k) {
                        int[] tmp = people[k];
                        people[k] = people[i];
                        people[i] = tmp;
                    }
                }
            }

            return people;
        }
    }

    static class Solution2 {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if (ints[0] < t1[0]) {
                        return 1;
                    } else if (ints[0] == t1[0]) {
                        if (ints[1] > t1[1]) {
                            return 1;
                        } else if (ints[1] == t1[1]) {
                            return 0;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            });

            List<int[]> list = new ArrayList<>(people.length);
            for (int i = 0; i < people.length; i++) {
                list.add(people[i][1], people[i]);
            }

            return list.toArray(new int[people.length][2]);
        }
    }
}
