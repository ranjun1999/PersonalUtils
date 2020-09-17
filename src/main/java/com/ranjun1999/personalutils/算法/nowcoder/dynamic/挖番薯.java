package com.ranjun1999.personalutils.算法.nowcoder.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个番薯洞中有一定数量的番薯。同时，我们知道番薯洞的连接路径，并规定路径是单向且小序号指向大序号，也无环。
 * 可以从任意一处开始挖，然后沿着连接往下挖（仅能选择一条路径），当无连接时，结束。
 * 设计一种挖番薯的方案，使得可以挖到更多的番薯。
 * 输出路径。
 * @Author: ranjun
 * @Date: 2020/7/28 10:06
 */
public class 挖番薯 {
    //保存每个节点可以指向的后继节点
    List<List<Integer>> next;
    //判断每个节点是否有前驱节点
    List<Boolean> vis;
    int maxCnt;
    String maxPath;
    /**
     * 输入：
     *[5,10,20,5,4,5],[[1,2],[1,4],[2,4],[3,4],[4,5],[4,6],[5,6]]
     * 输出：
     * "3-4-5-6"
     * 很明显 先去第三点拿20个番薯，再去第四个点拿5个，再去第五个点拿4个，再去第六个点拿5个。这个方案最优
     *
     * 这里使用深度优先遍历会超时，要使用动态规划
     * @param potatoNum int整型一维数组 依次表示序号为1,2,3..的番薯洞各有多少个番薯
     * @param connectRoad int整型二维数组 每个一维数组[x,y]表示从第x号番薯洞到第y号有路
     * @return string字符串
     */
    public  String digSum (int[] potatoNum, int[][] connectRoad) {
        // write code here
        next = new ArrayList<>(potatoNum.length + 1);
        vis = new ArrayList<>(potatoNum.length + 1);

        for (int i = 0; i < potatoNum.length + 1; i++) {
            next.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < potatoNum.length + 1; i++) {
            vis.add(false);
        }

        for (int i = 0; i < connectRoad.length; i++) {
            next.get(connectRoad[i][0]).add(connectRoad[i][1]);
        }
        for (int i = 1; i <= potatoNum.length; i++) {
            if (vis.get(i)) {
                continue;
            }
            int cnt = potatoNum[i-1];
            String path = String.valueOf(i);
            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxPath = path;
            }
            dsf(i,cnt,path,potatoNum);
        }
        return maxPath;
    }

    //深度优先遍历
    public void dsf(int a, int cnt, String path , int[] potatoNum) {
        for (int i = 0; i < next.get(a).size(); i++) {
            int b = next.get(a).get(i);
            vis.set(b,true);
            int temp = cnt + potatoNum[b - 1];
            String tempPath = path + "-" + b;
            if (temp > maxCnt) {
                maxCnt = temp;
                maxPath = tempPath;
            }
            dsf(b,temp,tempPath,potatoNum);
        }

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/3ad354a576e04232bad4636cc6149b1e?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 方法一有很多重复的计算。
     * 例如：
     *
     * [5,10,20,5,4,5],[[1,2],[1,4],[2,4],[3,4],[4,5],[4,6],[5,6]]
     * 在节点 1 中计算了 1-2-4-5-6，在节点 3 中计算了 3-4-5-6，重复计算了路径 4-5-6。
     *
     * 为了防止这些重复计算，换一下思路，从 n 到 1 遍历节点。
     *
     *  cnt[i]表示从节点 i 开始到无连接时的最大番薯数目：取节点 i 的后继节点的最大值，再加上节点 i 本身的值。
     *   next 记录每个节点的后继节点。
     * 最后，遍历所有节点，返回其最大值对应的路径。
     * @param potatoNum
     * @param connectRoad
     * @return
     */
    public String digSum_Dynamic(int[] potatoNum, int[][] connectRoad) {

        int n = potatoNum.length;
        // write code here
        next = new ArrayList<>(potatoNum.length + 1);
        for (int i = 0; i < potatoNum.length + 1; i++) {
            next.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < connectRoad.length; i++) {
            next.get(connectRoad[i][0]).add(connectRoad[i][1]);
        }

        List<Integer> cnts = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            cnts.add(0);
            paths.add("");
        }

        for(int i=n; i>=1; --i){
            cnts.set(i,potatoNum[i-1]);
            paths.set(i,String.valueOf(i));

            int tmp = 0;
            int e = 0;
            for(int j=0; j < next.get(i).size(); ++j){
                int b = next.get(i).get(j);
                if(cnts.get(b) > tmp){
                    tmp = cnts.get(b);
                    e = b;
                }
            }
            if(tmp > 0){
                cnts.set(i,cnts.get(i) +tmp);
                paths.set(i,paths.get(i) + "-" + paths.get(e));
            }
        }

        int maxCnt = 0;
        String maxPath = "";
        for(int i=1; i<=n; ++i){
            if(cnts.get(i) > maxCnt){
                maxCnt = cnts.get(i);
                maxPath = paths.get(i);
            }
        }
        return maxPath;
    }




    public static void main(String[] args) {
        int[][] connectRoad = {{1,2},{1,4},{2,4},{3,4},{4,5},{4,6},{5,6}};
        int[] potatoNum = {5,10,20,5,4,5};
        String res = new 挖番薯().digSum(potatoNum,connectRoad);
        System.out.println(res);
    }
}
