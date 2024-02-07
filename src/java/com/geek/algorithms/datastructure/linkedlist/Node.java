package com.geek.algorithms.datastructure.linkedlist;

/**
 * @ClassName GeekSingleLinkListNode
 * @Description 链表的接口
 * @Author linxin
 * @Date 2019-12-02 15:44
 * @Version 1.0
 **/

public class Node<D> {

    public D data;

    public Node next;


    public Node(D data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(D data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
