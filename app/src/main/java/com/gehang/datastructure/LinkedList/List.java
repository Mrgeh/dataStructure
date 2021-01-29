package com.gehang.datastructure.LinkedList;


import org.w3c.dom.Node;

import java.util.LinkedList;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.LinkedList
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/1/26 11:09
 */
public class List {
    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    private Node insertNode;

    /**
     * 链表插入数据
     * @param data 插入的元素
     * @param index 插入的位置
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {

        if (index < 0 || index > size) {
            throw  new IndexOutOfBoundsException("超出链表节点范围");
        }
       // Node insertNode  = new Node(data);
  /*      if (size==0){
            //空链表
            head=insertNode;
            last=insertNode;
        }else if (index==0){

            //插入头部
            insertNode.next=head;
            head = insertNode;
        }
        else if (size==index){
            //插入尾部
            last.next=insertNode;
            last = insertNode;

        }else {
            //插入中间

            Node preNode = get(index-1);
            insertNode.next=preNode.next;
            preNode.next = insertNode;
        }*/
        size++;
    }

    /**
     * 删除链表位置
     * @param index 删除的节点位置
     * @return
     * @throws Exception
     */
    public  Node remove(int index)throws  Exception{
        if(index<0 ||index>=size){

            throw new IndexOutOfBoundsException("超出链表节点范围");

        }

        Node removedNode = null;

//       if (index ==0){
//            //删除头节点
//            removedNode = head;
//            head = head.next;
//        }
//        else if (index==size-1){
//            //删除尾节点
//            Node prevNode = get(index-1);
//            removedNode = prevNode.next;
//            prevNode.next=null;
//            last = prevNode;
//
//        }
//        else {
//            //删除中间节点
//
//            Node  prevNode = get(index-1);
//            Node nextNode = prevNode.next.next;
//            removedNode=prevNode.next;
//            prevNode.next  =nextNode;
//        }
        size--;
        return removedNode;
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3,0);
        linkedList.add(3,0);
        linkedList.add(3,0);
        linkedList.remove(0);

    }
}
