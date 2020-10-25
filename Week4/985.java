class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answers = new int[queries.length];
        
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) curSum += A[i];
        }
        
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], idx = queries[i][1];
            int origin = A[idx];
            A[idx] += val;
            
            if (origin % 2 == 0 && A[idx] % 2 == 0) curSum += val;
            else if (origin % 2 == 0 && A[idx] % 2 != 0) curSum -= origin;
            else if (origin % 2 != 0 && A[idx] % 2 == 0) curSum += A[idx];
            
            answers[i] = curSum;
        }
        
        return answers;
    }
}