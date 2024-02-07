package com.geek.algorithms.datastructure.linkedlist;

import com.alibaba.fastjson2.JSON;

import java.util.Objects;

/**
 * @ClassName GeekLinkList
 * @Description 链表操作，防止指针丢失，注意判断头结点和尾节点
 * @Author linxin
 * @Date 2019-12-02 15:44
 * @Version 1.0
 **/
public class SingleLinkList<D> {

    private Node<D> head;

    /**
     * 记录尾结点
     */
    private Node<D> tail;

    private int size = 0;

    public SingleLinkList() {
    }

    public SingleLinkList(Node<D> node) {
        this.head = node;
        this.tail = node;
        if (Objects.nonNull(node)){
            this.size = 1;
        }
    }

    public static void main(String[] args) {
        SingleLinkList<String> linkList = new SingleLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.append(new Node<String>("node" + i));
        }
        System.out.println(JSON.toJSONString(linkList));
        linkList.reverse();
        System.out.println(JSON.toJSONString(linkList));
        linkList.reversTest();
        System.out.println(JSON.toJSONString(linkList));

    }

    /**
     * 链表反转的本质是通过循环不断遍历链表元素，并添加到一个新链表（临时）的头部
     * 通过循环遍历，定义一个临时小链表，每次遍历出来的节点作为小链表的新头节点，即每次从旧链表中取出最开头的节点
     * @author linxin
     * @return void
     * @date 2024/1/11 21:17
     */
    public void reverse(){
        // 不用反转的情况
        if (this.head == null || head.next == null){
            return;
        }
        // 从头结点开始遍历
        Node<D> cursor = this.head;
        // 每次循环生产一个小链表，tempHead 作为小链表的临时头结点，游标指针不断向后遍历，
        // 并将每一次遍历出来的节点的next指针指向临时小链表的头部
        Node<D> tempListHead = null;

        while (cursor != null){
            // 定义一个临时节点保存当前指针的下一个Node,实现链表节点的遍历
            Node<D> temp = cursor.next;
            // 当前游标指针的next指向临时小链表头结点，第一次循环临时为null，符合链表最后一个元素为null的条件
            cursor.next = tempListHead;
            // 临时量表头修改为当前游标节点，这样下一次循环出来的节点在上一步中会作为新的节点头
            tempListHead = cursor;
            // 游标指向next
            cursor = temp;
        }

        this.head = tempListHead;
    }

    public void reversTest(){
        Node<D> cursor = this.head;
        Node<D> newHead = null;

        if (this.size < 0){
            return;
        }
        while (null != cursor){
            Node<D> temp = cursor.next;
            cursor.next = newHead;
            newHead = cursor;
            cursor = temp;
        }
        this.head = newHead;
    }


    public int append(Node<D> node){
        if (Objects.isNull(node)){
            return this.size;
        }
        // 有元素了
        if (this.getSize() > 0){
            this.tail.next = node;
            this.tail = this.tail.next;
            this.size +=1;
        }else {
            this.head = node;
            this.tail = node;
            this.size = 1;
        }
        return this.size;
    }




    /**
     * @Author linxin
     * @Description 链表后插入节点
     * @Date 2019-12-02 15:54
     * @Param [node]
     * @return void
     **/
    public void appendNode(Node<D> head){
        while (true) {
            if(head != null){

            }
        }

    }

    /**
     * @Author linxin
     * @Description 删除给定的节点
     * @Date 2019-12-02 15:57
     * @Param [node]
     * @return boolean
     **/
    public boolean deleteNode(Node<D> node){

        while (head.next != null){

        }


        return true;
    }

    /**
     * @Author linxin
     * @Description 往链表头插入
     * @Date 2019-12-02 15:56
     * @Param [node]
     * @return void
     **/
    public void insertHead(Node<D> node){
        if(head == null){
            head =node;
        }
        node.next = head;
        head = node;
    }


    public Node<D> getHead() {
        return head;
    }

    public void setHead(Node<D> head) {
        this.head = head;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
