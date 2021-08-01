package basic.episode_0永恒经典;

import java.util.HashMap;

/**
 * @author: zyf
 * @date: 2021/7/31 20:27
 * @description: leetcode146
 * LinkedList不好用需要自建链表，使用两个空节点来固定头尾
 * 双向链表删除两行 插入四行
 */
public class Code01_LRU {
    static class Node{
        Node prev;
        Node next;
        Integer key;
        Integer value;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }

        Node(){}
    }

    int capacity;

    HashMap<Integer,Node> map = new HashMap<>();
    Node start;
    Node end;
    public Code01_LRU(int capacity) {
        this.capacity = capacity;
        start = new Node();
        end = new Node();
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            temp.prev=start;
            temp.next = start.next;
            start.next.prev = temp;
            start.next = temp;

            return temp.value;
        }else return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.value = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            temp.next = start.next;
            temp.prev = start;
            start.next.prev = temp;
            start.next = temp;
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            node.prev = start;
            node.next = start.next;
            start.next.prev = node;
            start.next = node;

            if(map.size()>capacity){
                Node toBeDeleted = end.prev;
                map.remove(toBeDeleted.key);
                toBeDeleted.prev.next = end;
                end.prev = toBeDeleted.prev;
            }
        }
    }
}
