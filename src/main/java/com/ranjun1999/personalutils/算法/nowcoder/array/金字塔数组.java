package com.ranjun1999.personalutils.算法.nowcoder.array;

/**
 * 在整个num数组中找出长度最长的金字塔数组，如果金字塔数组不存在，请输出0。
 * 金字塔数组：数组中的值是呈现递增趋势的，到了最大值以后，数组中的值呈现递减的趋势
 * <p>
 * 输入：5,[1,5,3,3,1]
 * 输出：3
 *
 * @Author: ranjun
 * @Date: 2020/7/27 15:17
 */
public class 金字塔数组 {


    /**
     * @param n
     * @param num
     * @return 返回长度
     */
    public static int getMaxLength(int n, int[] num) {
        int maxLength = 0;
        int i = 0, next = 0;
        while (i < n - 1) {
            if ((i + 1) < n && num[i + 1] <= num[i]) {
                i++;
                continue;
            } else {
                next = i + 1;
                while (next < n && num[next] > num[next - 1]) {
                    next++;
                }
                if (next < n && num[next] == num[next - 1]) {
                    i = next;
                    continue;
                } else {
                    while (next < n && num[next] < num[next - 1]) {
                        next++;
                    }
                    maxLength = Math.max(maxLength, next - i);
                    i = next - 1;
                }

            }

        }
        return maxLength;
    }


    int getMaxLength2(int n, int[] num) {
        // write code here
        int cnt = 0, f1 = 0, f2 = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            while ((num[i] > num[i - 1]) && i < n) {
                cnt++;
                i++;
                f1 = 1;
            }
            while ((num[i] < num[i - 1]) && i < n) {
                cnt++;
                i++;
                f2 = 1;
            }
            if (f1 > 0 && f2 > 0) ans = Math.max(ans, cnt + 1);
            if (num[i] != num[i - 1]) i--;
            f1 = f2 = cnt = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {957, 420, 332, 900, 576, 815, 315, 651, 614, 823, 249, 391, 812, 309, 113, 476, 697, 196, 615, 795, 240, 976,
                151, 392, 232, 208, 713, 301, 177, 935, 420, 332, 113, 711, 993, 546, 217, 799, 586, 827, 618, 127, 602, 320, 747,
                40, 310, 56, 87, 154, 637, 974, 579, 744, 892, 79, 638, 351, 100, 383, 956, 311, 544, 845, 340, 425, 346, 91, 608,
                722, 230, 538, 44, 686, 993, 158, 187, 505, 435, 326, 63, 850, 723, 728, 352, 265, 585, 194, 111, 218, 226, 67, 715, 930,
                783, 275, 716, 817, 424, 864, 726, 313, 255, 954, 887, 326, 535, 922, 884, 319, 671, 855, 881, 172, 329, 416, 905, 392, 553,
                593, 901, 25, 778, 248, 655, 150, 322, 31, 674, 248, 569, 487, 818, 324, 598, 690, 418, 47, 955, 922, 254, 819, 434, 889, 685, 954, 688,
                1000, 84, 240, 113, 884, 375, 789, 220, 189, 712, 587, 272, 505, 765, 950, 671, 721, 334, 530, 122, 346, 100, 257, 758, 607, 752, 364,
                533, 197, 971, 129, 343, 735, 9, 15, 443, 659, 20, 774, 97, 988, 326, 114, 906, 2, 199, 98, 698, 391, 760, 731, 620, 202, 214, 235, 758, 186, 804, 107, 471, 691, 818, 348, 687, 13, 2, 109, 950, 190, 213, 811, 496, 36, 673, 627, 190, 112, 230, 276, 392, 383, 785, 985, 579, 523, 928, 669, 549, 537, 568, 223, 145, 268, 963, 360, 583, 754, 118, 11, 434, 197, 914, 445, 49, 93, 664, 349, 22, 804, 539, 405, 579, 491, 601, 137, 415, 19, 530, 424, 571, 302, 476, 145, 217, 342, 262, 792, 47, 782, 452, 161, 392, 617, 971, 555, 236, 519, 485, 689, 458, 567, 390, 117, 627, 497, 672, 830, 936, 387, 660, 700, 806, 255, 698, 865, 673, 939, 155, 978, 567, 217, 301, 862, 247, 904, 583, 734, 778, 739, 518, 150, 16, 336, 935, 915, 214, 91, 661, 422, 183, 4, 613, 408, 16, 6, 833, 94, 264, 602, 506, 359, 480, 11, 233, 602, 120, 891, 839, 678, 242, 7, 652,
                725, 378, 494, 445, 176, 566, 792, 737, 833, 587, 460, 735, 565, 41, 458, 824, 104, 367, 858, 458, 550, 897, 949, 784, 199, 289, 931,
                412, 258, 509, 180, 278, 965, 384, 411, 778, 988, 450, 415, 341, 776, 508, 100, 792, 362, 263, 651, 280, 192, 821, 149, 884, 39, 547,
                949, 993, 723, 964, 54, 628, 450, 465, 946, 294, 375, 104, 366, 444, 774, 715, 146, 111, 683, 539, 413, 672, 400, 916, 688, 81,
                910, 626, 130, 401, 492, 860, 692, 638, 270, 49, 510, 167, 944, 616, 58, 794, 555, 236, 926, 308, 902, 520, 768, 959, 545, 895, 406,
                81, 382, 703, 739, 843, 602, 711, 441, 350, 674, 190, 763, 997, 961, 606, 529, 63, 761, 706, 634, 683, 360, 707, 805, 586, 613, 265, 593, 535, 379, 488, 766, 146, 421, 945, 107, 685, 866, 699, 938, 126, 68, 593, 40, 87, 707, 397, 25, 234, 640, 325, 396, 761, 366, 70, 930, 381, 787, 503, 69, 453, 456, 927, 631, 578, 341, 504, 392, 696, 329, 142, 157, 776, 256, 739, 237, 892, 910, 109, 893, 722, 650, 379, 590, 172, 15, 340, 749, 919, 479, 256, 476, 371, 841, 211, 656, 210, 533, 791, 27, 469, 637, 752, 618, 931, 462, 78, 201, 435, 759, 591, 477, 381, 810, 548, 834, 492, 696, 229, 854, 774, 386, 398, 158, 375, 85, 804, 873, 994, 334, 523, 578, 866, 998, 938, 289, 112, 855, 138, 307, 942, 472, 154, 569, 27, 238, 54, 343, 800, 364, 73, 590, 643, 611, 577, 60, 593, 837, 98, 370, 770, 951, 966, 374, 183, 342, 803, 354, 191, 475, 221, 533, 907, 289, 270, 713, 990, 534, 971, 396, 913, 457, 441, 747, 574, 363, 288, 956, 123, 929, 646, 611, 961, 769, 463, 415, 758, 154, 76, 213, 928, 233, 945, 454, 563, 706, 572, 365, 325, 331, 914, 107, 919, 743, 60, 798, 38, 794, 803, 223, 564, 288, 695, 812, 881, 43, 134, 462, 661, 413, 715, 483, 202, 986, 5, 246, 342, 545, 922, 733, 831, 509, 508, 955, 874, 943, 354, 735, 325, 695, 938, 302, 19, 563, 654, 637, 960, 206, 180, 641, 934, 652, 610, 458, 479, 461, 642, 149, 252, 585, 810, 705, 805, 51, 992, 484, 570, 873, 372, 231, 73, 498, 822, 231, 561, 961, 393, 502, 983, 794, 576, 681, 887, 434, 41, 955, 877, 563, 103, 467, 196,
                160, 420, 921, 287, 350, 382, 70, 534, 836, 161, 404, 347, 277, 662, 116, 998, 715, 947, 967, 86, 822};
//        int[] a = {1,2,3,4,5,4,3,2,1};
        System.out.println(getMaxLength(a.length, a));
    }
}
