package com.atgugu.algorithms;


import java.util.Scanner;

/**
 * 消息队列算法
 */
public class QueueArray {
    public static void main(String[] args) {
        //测试
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示所有数据");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):获取数据");
            System.out.println("h(head):获取头部信息");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出~~");
                    break;
                case 'a':
                    System.out.print("输入一个数:");
                    int values = scanner.nextInt();
                    arrayQueue.addQueue(values);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是:" + res);
                    } catch (Exception e) {
                        System.out.println("没有数据可取");
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("头部数据是" + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println("头部没有数据了");
                    }
                    break;
                default:
                    break;

            }
        }
    }
}

//编写一个数组模拟队列  ArrayQueue 的类
class ArrayQueue {
    private int maxSize; //表示数组最大容量
    private int fornt; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        fornt = -1; //指向队列头部前一个位置
        rear = -1; // 指向对象尾部
    }

    //判断队列是否满
    public boolean isFull() {
        //如果长度是4 那么当他满的时候尾指针就应该为 max - 1 = 3;
        return rear == maxSize - 1;
    }

    //判读队列是否为空
    public boolean isEmpty() {
        //当头指针与尾指针相等时 就代表当前队列没有值。
        return rear == fornt;
    }

    //添加数据到队列
    public void addQueue(int num) {
        //判断队列是否为满
        if (isFull()) {
            System.out.println("队列满 不能加入数据");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    //取数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        fornt++;
        return arr[fornt];
    }

    //显示队列的所有数据
    public void showQue() {
        if (isEmpty()) {
            System.out.println("队列为空 不能遍历数据");
        }
        for (int a : arr) {
            System.out.printf(a + "\t");
        }
        System.out.println();
    }

    //显示头数据
    public int hadQue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空 不能返回数据");
        }
        return arr[fornt + 1];
    }
}

