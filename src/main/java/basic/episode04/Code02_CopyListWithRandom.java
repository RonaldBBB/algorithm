package basic.episode04;

/**
 * @Description 复制带随机指针的链表 leetcode138,剑指offer35
 * @Date 2021/5/30 21:24
 * @Created by xiaofei
 */
public class Code02_CopyListWithRandom {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node next;
        Node temp;
        Node cur = head;
        while (cur != null) {
            temp = new Node(cur.val);
            next = cur.next;
            cur.next = temp;
            temp.next = next;
            cur = next;
        }
        cur = head;
        // 复制random指针

        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // 抽离复制部分
        Node copy = head.next;
        cur = copy;
        while (head.next.next != null) {
            head.next = head.next.next;
            cur.next = cur.next.next;
            head = head.next;
            cur = cur.next;
        }
        head.next = null;
        cur.next = null;
        return copy;
    }

}
