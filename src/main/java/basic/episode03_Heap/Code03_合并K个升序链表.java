package basic.episode03_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zyf
 * @date: 2021/7/31 14:54
 * @description:
 */
public class Code03_合并K个升序链表 {


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

    static class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    }


    // 堆
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new NodeComparator());
        ListNode resultDummyHead = new ListNode();
        ListNode copy = resultDummyHead;
        // init
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        while (!heap.isEmpty()) {
            ListNode temp = heap.remove();
            copy.next = temp;
            copy = copy.next;
            if (temp.next != null) heap.add(temp.next);
        }
        return resultDummyHead.next;
    }


    public ListNode mergeKLists猪鼻(ListNode[] lists) {
        ListNode resultDummyHead = new ListNode();
        ListNode copy = resultDummyHead;


        while (true) {
            ListNode temp = null;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && (temp == null || lists[i].val < temp.val)) {
                    temp = lists[i];
                    index = i;
                }
            }
            if (index == -1) break;
            copy.next = lists[index];
            copy = copy.next;
            lists[index] = lists[index].next;
        }
        return resultDummyHead.next;
    }
}
