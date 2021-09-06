package basic.episode04_List;

import java.util.PriorityQueue;

/**
 * @Description lc23
 * @Date 2021/8/27 15:00
 * @Created by xiaofei
 */
public class Code05_合并K个升序链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) if (node != null) heap.add(node);
        ListNode resultDummyHead = new ListNode();
        ListNode copy = resultDummyHead;
        while (!heap.isEmpty()) {
            ListNode temp = heap.remove();
            if (temp.next != null) heap.add(temp.next);
            copy.next = temp;
            copy = copy.next;
        }
        copy.next = null;
        return resultDummyHead.next;
    }
}
