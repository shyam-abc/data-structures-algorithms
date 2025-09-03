package com.datastructures_algorithms.neetcode_150._5_25;

public class _120BurstBalloons {
    int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1; arr[n + 1] = 1;
        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];

        int[][] memo = new int[n + 2][n + 2];
        return dfs(arr, 0, n + 1, memo);
    }

    int dfs(int[] arr, int left, int right, int[][] memo) {
        if (left + 1 == right)
            return 0;
        if (memo[left][right] != 0)
            return memo[left][right];

        int best = 0;
        for (int k = left + 1; k < right; k++) {
            best = Math.max(best,
                    dfs(arr, left, k, memo) +
                            arr[left] * arr[k] * arr[right] +
                            dfs(arr, k, right, memo)
            );
        }
        return memo[left][right] = best;
    }
}
