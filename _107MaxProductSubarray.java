package com.datastructures_algorithms.neetcode_150._5_25;

public class _107MaxProductSubarray {
    public int maxProduct(int[] nums){
        if(nums.length == 0)
            return 0;

        int minSoFar = nums[0], maxSoFar = nums[0], result = maxSoFar;

        for(int i = 1; i < nums.length; i++){
            int current = nums[i];

            int prevMin = minSoFar;
            int prevMax = maxSoFar;

            minSoFar = Math.min(current, Math.min(prevMin * current, prevMax * current));
            maxSoFar = Math.max(current, Math.max(prevMin * current, prevMax * current));

            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}
