package com.tukjax.cargo.algorithm.list;


/**
 * 指定范围内的链表反转
 *
 */
public class reverseChain {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(7);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
       //ListNode forst = reverseN(listNode1, 4);

        ListNode forst = reverseKGroup(listNode1, 2);

        while (forst != null ){
            System.out.println(forst.val);
            forst = forst.next;
        }

    }
    static ListNode successor = null; // 后驱节点

    //反转链表的一部分
    static ListNode reverseBetween(ListNode head, int begin, int end) {

        if (begin == 1){
            return reverseN(head, begin);
        }
        head.next = reverseBetween(head.next, begin-1, end -1);

        return head;
    }


    //反转链表的前n个
    static ListNode reverseN(ListNode head, int size) {

        if (size == 1){
            successor = head.next;

            return head;
        }
        ListNode last = reverseN(head.next, size-1);

        head.next.next = head;
        System.out.println(head.next.val +"的后继被改为" + head.val);
        head.next = successor;
        return last;
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }


    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
