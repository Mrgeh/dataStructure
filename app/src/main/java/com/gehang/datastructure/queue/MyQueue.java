package com.gehang.datastructure.queue;

/**
 * 栈与队列
 * @author Ge Hang
 * @packageName com.gehang.datastructure.queue
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/1/29 15:17
 */
//循环队列

class MyQueue {

    private int[] array;
    /**
     * 对头下标
     */
    private int front;
    /**
     * 队尾下标
     */
    private int rear;

    public MyQueue(int capacity) {
        //设置数组的大小
        this.array = new int[capacity];

    }

    /**
     * 入队
     * @param element 入队的元素
     * @throws Exception
     */
    public  void enQueue(int element) throws  Exception{
        if ((rear+1)%array.length==front){  //(队尾下标+1)%数组长度= 对头下标时，代表队列已满
            throw  new Exception("队列已满");
        }
        array[rear] =element;
        rear = (rear+1)%array.length;//把新的队尾下标赋值给 队尾下标
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public  int deQueue() throws  Exception{
        if (rear == front){
            throw  new Exception("队列已空");
        }
         int deQueueElement = array[front];

        front = (front+1)%array.length;//对队头后一位的下标赋值给队头，原来的对头就出队了。把后一位给前一位

        return deQueueElement;
    }

    public  void output(){
        for (int i = front; i!=rear ; i=(i+1)%array.length) {
            System.out.println(array[i]);

        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue =new MyQueue(9);
        myQueue.enQueue(2);
        myQueue.enQueue(1);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(23);
        myQueue.enQueue(11);
        myQueue.enQueue(5);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.output();
    }
}
