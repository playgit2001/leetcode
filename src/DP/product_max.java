package DP;
//leetcode 152
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//测试用例的答案是一个 32-位 整数。
//子数组 是数组的连续子序列。

public class product_max {
    //别人写的DP算法
    public int maxProduct(int[] nums) {
        int n = nums.length, res = nums[0];
        int[] f = new int[n + 1], g = new int [n + 1];
        f[0] = nums[0];  // 初始化
        g[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            f[i] = Math.max(nums[i], Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i])); //乘积最大值
            g[i] = Math.min(nums[i], Math.min(g[i - 1] * nums[i], f[i - 1] * nums[i])); //乘积最小值
            res = Math.max(res, f[i]);
        }
        return res;
    }

    //我写失败的原因，对于最小值处理不当
    /*public int maxProduct(int[] nums) {
        int[] dp = new int [nums.length];
        dp[0]=nums[0];
        if (nums.length<=1)
            return dp[0];
        for(int i=1;i<nums.length;i++){
            if(Math.abs(dp[i-1]*nums[i])>=Math.abs(nums[i]))
                dp[i]=dp[i-1]*nums[i];
            else
                dp[i]=nums[i];
        }
        int max=-2147483648;
        for(int i=0;i<nums.length;i++)
            if(max<dp[i])
                max=dp[i];
        return max;
    }*/
}
