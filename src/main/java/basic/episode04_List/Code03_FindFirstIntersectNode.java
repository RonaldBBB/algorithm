package basic.episode04_List;

/**
 * @Description 1.找到两个单链表第一个相交节点，如果没有返回null leetcode160
 * 2.考虑链表可能有环 (未测试)
 * @Date 2021/5/30 23:32
 * @Created by xiaofei
 */
public class Code03_FindFirstIntersectNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode headAHasLoop = hasLoop(headA);
        ListNode headBHasLoop = hasLoop(headB);
        // case1: 两者都无环
        if (headAHasLoop == null && headBHasLoop == null) {
            return bothNoLoop(headA,headB);
        }
        // case2: 两者都有环
        if(headAHasLoop!=null&&headBHasLoop!=null){
            return bothHasLoop(headA,headB,headAHasLoop,headBHasLoop);
        }
        // case3: 一个有环一个无环无需讨论
        return null;
    }

    // 两者都有环的情况
    private ListNode bothHasLoop(ListNode headA, ListNode headB,ListNode headAHasLoop,ListNode headBHasLoop) {
        //  case1: 交点出现在环之前
        // 此时两者的环入口必定相同,参考两者都无环情况，把环入口当做终点即可
        if(headAHasLoop==headBHasLoop){
            ListNode copyHeadA = headA;
            int lengthA = 0;
            ListNode copyHeadB = headB;
            int lengthB = 0;
            while (copyHeadA.next != headAHasLoop) {
                copyHeadA=copyHeadA.next;
                lengthA++;
            }
            while (copyHeadB.next != headAHasLoop) {
                copyHeadB=copyHeadB.next;
                lengthB++;
            }
            copyHeadA = headA;
            copyHeadB = headB;
            // A节点先走差值步
            if(lengthA>lengthB){
                for(int i =0;i<lengthA-lengthB;i++){
                    copyHeadA = copyHeadA.next;
                }
            }
            // B节点先走差值步
            else{
                for(int i =0;i<lengthB-lengthA;i++){
                    copyHeadB = copyHeadB.next;
                }
            }
            // 同步比较
            while(copyHeadA!=headAHasLoop){
                if(copyHeadA==copyHeadB)return copyHeadA;
                copyHeadA=copyHeadA.next;
                copyHeadB=copyHeadB.next;
            }
        }
        // case2: 交点出现在环中
        // 使用headAHasLoop走一圈，如果没有遇到headBHasLoop则无环
        ListNode temp = headAHasLoop.next;
        while(temp!=headAHasLoop){
            if(temp==headBHasLoop)return headBHasLoop;
            temp = temp.next;
        }
        return null;
    }
    // 两者都无环的情况
    private ListNode bothNoLoop(ListNode headA, ListNode headB) {

        ListNode copyHeadA = headA;
        int lengthA = 0;
        ListNode copyHeadB = headB;
        int lengthB = 0;
        while (copyHeadA.next != null) {
            copyHeadA=copyHeadA.next;
            lengthA++;
        }
        while (copyHeadB.next != null) {
            copyHeadB=copyHeadB.next;
            lengthB++;
        }
        // 如果末尾节点不相等则不相交
        if(copyHeadA!=copyHeadB)return null;
        copyHeadA = headA;
        copyHeadB = headB;
        // A节点先走差值步
        if(lengthA>lengthB){
            for(int i =0;i<lengthA-lengthB;i++){
                copyHeadA = copyHeadA.next;
            }
        }
        // B节点先走差值步
        else{
            for(int i =0;i<lengthB-lengthA;i++){
                copyHeadB = copyHeadB.next;
            }
        }
        // 同步比较
        while(copyHeadA!=null){
            if(copyHeadA==copyHeadB)return copyHeadA;
            copyHeadA=copyHeadA.next;
            copyHeadB=copyHeadB.next;
        }
        return null;
    }

    //判断是否有环，如果有环返回环的入口节点，否则返回null
    private ListNode hasLoop(ListNode node) {
        if (node == null || node.next == null || node.next.next == null) return null;
        ListNode slow = node.next;
        ListNode fast = node.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时确定有环
        // 将fast重置为初始节点
        fast = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 当两者再次相遇时两者都处于环的入口节点
        return fast;
    }
}
