package com.atyeti.collections.list.linkedList;


public class ReversedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next = new ListNode(2);
          head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

   System.out.println("original List:");
        printList(head);
        System.out.println("reversed  list:");
    ListNode reverseHead=reverseList(head);
    printList(reverseHead);
    }}