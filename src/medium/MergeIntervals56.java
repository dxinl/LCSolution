package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MergeIntervals56 {
    /**
     * Definition for an interval.
     */
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(0, 0));
        intervals.add(new Interval(-1, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(13, 15));
        System.out.println(new MergeIntervals56().merge(intervals));
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<>();
        if (intervals.isEmpty()) {
            return list;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> edges = new HashMap<>();
        for (Interval interval : intervals) {
            if (interval.end > max)
                max = interval.end;

            if (interval.start < min) {
                min = interval.start;
            }

            edges.put(interval.start, (edges.getOrDefault(interval.start, 0) + 1));
            edges.put(interval.end, (edges.getOrDefault(interval.end, 0) - 1));
        }

        int count = 0;
        int start = 0;
        for (int i = min; i <= max; i++) {
            Integer c = edges.get(i);
            if (c == null) {
                continue;
            }

            if (c == 0 && count == 0) {
                list.add(new Interval(i, i));
                continue;
            }

            if (count == 0) {
                start = i;
                count = c;
            } else {
                count += c;
                if (count == 0) {
                    list.add(new Interval(start, i));
                }
            }
        }

        return list;
    }
}
