// Given a collection of intervals, merge all overlapping intervals.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 

// Constraints:

// intervals[i][0] <= intervals[i][1]

class Solution {
  private class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
      return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    }
  }

  public int[][] merge(int[][] intervals) {
    Collections.sort(Arrays.asList(intervals), new IntervalComparator());

    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      }
      // otherwise, there is overlap, so we merge the current and previous
      // intervals.
      else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}
