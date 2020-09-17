package com.ranjun1999.personalutils.算法.nowcoder.dynamic;

/**
 * 假设没面包和饮料是捆绑销售，就是说，一个大包装里面x个面包+y个饮料，花费t元。
 *每种大包装只能最多买一个
 * 请计算为了满足一定量的面包与饮料需求，一共最少花费多少钱
 * @Author: ranjun
 * @Date: 2020/7/29 10:00
 */
public class 花钱最少方案 {


    /**
     * 动态规划的0-1背包问题，dp[i][j]存储的是当需要i个面包和j个饮料时的最小所需钱数
     *
     * .DP本身每次记录的是局部最优，使用DP时要确定两大要素：
     * （1）边界。本题的边界是dp[i][j]=0，即不需要面包和饮料时不花钱。
     * （2）状态转移方程。如果不顾空间开销，那么实际的状态转移方程就需要开三维数组，即记录对于当前第k个捆绑套餐，当需要i个面包和j个饮料时所需的最小金额dp[k][i][j]；
     * 进行滚动数组优化后，用当前的位置存储上一个捆绑套餐所需的最小金额，即实现降维，得到的状态转移方程为：
     * dp[i][j] = min(   dp[i][j]  ,   dp[  max(i-packageSum[k][0],0)  ][  max(j-packageSum[k][1],0)  ] + packageSum[k][2]   );
     * 在这里，max(i-packageSum[k][0],0)和max(j-packageSum[k][1],0)的意思是，只要当前捆绑套餐内带有的面包数或饮料数大于所需数量，那么就视为完成对于面包或饮料的需求，即达到当前剩余需求为0。
     *
     * 注意最优化问题中dp数组内元素的初始状态。因为这道题是求最小值，而且滚动数组优化后会从非数组首元素开始循环，所以我赋初值时给所有dp元素取了一个尽可能大的值：99999。另外，dp[0][0]要赋值为0，理由上面解释过了
     * @param breadNum int整型
     * @param beverageNum int整型
     * @param packageSum int整型二维数组 每个一维数组中有三个数，依次表示这个包装里面的面包数量、饮料数量、花费
     * @return int整型
     */
    public int minCost (int breadNum, int beverageNum, int[][] packageSum) {
        // write code here
        //dp[i][j]:当需要i个面包和j个饮料时花费的最少钱
        int[][] dp = new int[breadNum + 1][beverageNum + 1];

        int size = packageSum.length;
        for(int i=0;i<=breadNum;i++)
        {
            for(int j=0;j<=beverageNum;j++)
            {
                dp[i][j] = 99999;
            }
        }
        //不需要面包和饮料时不花钱
        dp[0][0] = 0;
        for(int k=0;k<size;k++)    //第一层循环，遍历所有货品
        {
            for(int i=breadNum;i>=0;i--)    //第二层循环，枚举需要的面包数
            {     //倒序原因：滚动数组策略，省略了上一个货品时的空间，即当前dp[i][j]实际保存的是上一个货品dp的状态
                for(int j=beverageNum;j>=0;j--)     //二维背包问题，三维数组滚动优化为二维数组
                {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[Math.max(i-packageSum[k][0], 0)][Math.max(j-packageSum[k][1], 0)]
                                    + packageSum[k][2]);
                }
            }
        }

        return dp[breadNum][beverageNum];
    }
}
