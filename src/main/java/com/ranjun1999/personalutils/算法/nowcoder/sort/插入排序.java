package com.ranjun1999.personalutils.算法.nowcoder.sort;

/**
 * @Author: ranjun
 * @Date: 2020/3/24 20:39
 */
/*
 * 插入排序算法：
 * 1、以数组的某一位作为分隔位，比如index=1，假设左面的都是有序的.
 *
 * 2、将index位的数据拿出来，放到临时变量里，这时index位置就空出来了.
 *
 * 3、从leftindex=index-1开始将左面的数据与当前index位的数据（即temp）进行比较，如果array[leftindex]>temp,
 * 则将array[leftindex]后移一位，即array[leftindex+1]=array[leftindex],此时leftindex就空出来了.
 *
 * 4、再用index-2(即leftindex=leftindex-1)位的数据和temp比，重复步骤3，
 * 直到找到<=temp的数据或者比到了最左面（说明temp最小），停止比较，将temp放在当前空的位置上.
 *
 * 5、index向后挪1，即index=index+1，temp=array[index],重复步骤2-4，直到index=array.length,排序结束，
 * 此时数组中的数据即为从小到大的顺序.
 *
 */
public class 插入排序 {
    /*
     * 插入排序方法
     */
    public static void doInsertSort(int[] array){
        int length  =array.length;
        if (length <= 1)
            return;
        for(int index = 1; index<length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = array[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[leftindex+1] = array[leftindex];
                leftindex--;
            }
            array[leftindex+1] = temp;//把temp放到空位上
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,2,4,6,1,10,12};
        doInsertSort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(", ");
        }
    }
}
