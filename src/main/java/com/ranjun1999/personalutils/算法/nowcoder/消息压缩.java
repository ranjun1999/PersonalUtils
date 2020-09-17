package com.ranjun1999.personalutils.算法.nowcoder;

/**
 * 每条消息的前面附加一个 4 字节长度的 int 变量来存储消息的长度。
 * 对于长度恰好为 N 的字节的数据包，总共有多少种可能的不同的消息结构？我们定义不同为位置不同，和内容无关。比如说，对于长度为 10 的数据包，有下面 2 种可能的结构：
 * | 4 | 6 |
 * | 4 | 1 | 4 | 1 |
 * 注意，在所有可能的结构中，消息的长度不可以为 0。也就是说，不能出现这样的消息：| 4 | 0 |。
 * @Author: ranjun
 * @Date: 2020/7/27 11:12
 */
public class 消息压缩 {


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/132e81756836456aa7300ec2363c8705?f=discussion
     * 来源：牛客网
     *
     * 高中数学有道题是这样的，一个N阶的楼梯，每次可以选择上一阶或者两阶，一共有多少种上法？
     *     这个问题的关键在最后一步，是上一阶，还是上两阶？上一阶，那么前面 N-1 阶台接有多少种上法
     *     上两阶， 前面 N-2 阶台阶有多少种上法？如果 N-1 和 N-2的上法分别是 f(N-1) 和 f(N-2)，
     *     那么N阶台阶的上法就是 f(N-1) + f(N-2)
     *     这道题也类似，首先数据包接口都是4+N的格式（N>0)，再进一步简化，把一个数N拆成多个数相加，且每个加数都大于等于5
     *     N = a1 + a2 + ... + ai (ai >= 5)
     *     结合上面爬楼梯的例子，就是最后可能是5阶，可能是6阶，可能是7阶，可能是x阶， x>=5
     *     最后一步上5阶，那方案数就是f(N-5),最后一步上6阶就是f(N-6)，一直到f(5)
     *     总共方案数就是f(N) = f(N-5) + f(N-6) + f(N-7) + ... + f(5),另外还有一种可能是一步上N阶，再+1
     *     最终就是：f(N) = f(N-5) + f(N-6) + f(N-7) + ... + f(5) + 1
     *     f(N+1) = f(N-4) + f(N-5) + f(N-6) + f(N-7) + ... + f(5) + 1
     *     所以f(N+1) = f(N-4) + f(N) ==> f(N) = f(N-5) + f(N-1)
     *     上面讨论的都是N>5的情况，N<5时，f(N) = 0,f(5)=1
     * @param N
     * @return
     */
    public int messageCount(int N) {
      int[] r = new int[N+1];
        for (int i = 0; i < r.length; i++) {
            r[i] = 0;
        }
        if (N < 5) {
            return r[N];
        }else {
            r[5] = 0;
            for (int i = 6; i <= N; i++) {
                r[i] = r[i - 1] + r[i-5];
            }
        }

        return r[N];
    }

    public int messageCount2(int N) {
        if (N < 5) {
            return 0;
        }
        if (N == 5) {
            return 1;
        }
        return (messageCount(N-1) + messageCount(N-5)) % 998244353;
    }

    public static void main(String[] args) {

    }
}
