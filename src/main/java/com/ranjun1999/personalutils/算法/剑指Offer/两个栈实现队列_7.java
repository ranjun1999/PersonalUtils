package com.ranjun1999.personalutils.算法.剑指Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 完成在队尾添加元素，队首删除元素两个操作
 * @Author: ranjun
 * @Date: 2020/7/31 11:53
 */
public class 两个栈实现队列_7 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    /**
     * 将元素添加进stack1中
     * @param val
     */
    public void appendTail(Integer val) {
        stack1.push(val);
    }

    /**
     * 当stack2为空时，把stack1中的元素依次出栈并压入stack2中。
     * 当stack2不为空时，stack2的栈顶元素是最先进栈的元素，可以弹出
     * @return
     */
    public Integer deleteHead() {

        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return stack2.pop();
    }


    //两个队列实现栈
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 进栈，向非空的队列添加元素；
     * 若两个队列都为空，默认先向queue1添加元素
     * @param val
     */
    public void appendHead(Integer val) {
        if (queue2.isEmpty()) {
            queue1.offer(val);
        }else queue2.offer(val);
    }

    /**
     * 出栈
     * 非空队列元素一次出队列并压入另一个空队列，直到非空队列元素只剩一个时，就是最后进队列元素，弹出即可
     * 若两个队列都为空，则抛出异常。
     * @return
     */
    public Integer deleteHead_Stack(){
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }



    public static void main(String[] args) {
        两个栈实现队列_7 stack = new 两个栈实现队列_7();
        stack.appendHead(1);
        stack.appendHead(2);
        stack.appendHead(3);
        System.out.println(stack.deleteHead_Stack());
        System.out.println(stack.deleteHead_Stack());
        System.out.println(stack.deleteHead_Stack());
    }
}
