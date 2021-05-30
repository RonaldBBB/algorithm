package basic.episode04;

/**
 * @Description 判断链表是否为回文链表
 * @Date 2021/5/30 20:46
 * @Created by xiaofei
 */
public class Code01_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public boolean isPalindromList(Node head) {
        if (head == null || head.next == null) return true;
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分
        Node current = slow.next;
        slow.next=null;
        Node before = null;
        Node after;

        while(current!=null){
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }

        while(before!=null){
            if(head.value!=before.value)return false;
            head=head.next;
            before=before.next;
        }
        return true;
    }
}
