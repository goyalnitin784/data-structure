package ds.stackAndqueue;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, LruNode> map = new HashMap<>();
    int maxSize;
    LruNode head;
    LruNode end;
    int currentSize = 0;


    public LRUCache(int N) {
        this.maxSize = N;
    }

    public int get(int x) {
        if(map.get(x)==null){
            return -1;
        }else{
            LruNode lruNode = map.get(x);
            remove(lruNode);
            setHead(lruNode);
            return lruNode.data;
        }
    }

    public void set(int x, int y) {
        LruNode lruNode = new LruNode(x, y);
        if (map.containsKey(lruNode.key)) {
            remove(map.get(lruNode.key));
            setHead(lruNode);
        } else {
            map.put(x, lruNode);
            setHead(lruNode);
            if (currentSize < maxSize) {
                currentSize++;
            }else{
                map.remove(end);
                remove(end);
                end = end.prev;
            }
        }
    }

    private void setHead(LruNode lruNode) {
        if (head == null) {
            head = lruNode;
            end = lruNode;
            lruNode.prev = null;
        } else {
            lruNode.next = head;
            head.prev = lruNode;
            lruNode.prev = null;
        }
    }

    private void remove(LruNode lruNode) {
        if (lruNode.prev == null) {
            head = null;
        } else {
            lruNode.prev.next = lruNode.next;
            if(lruNode.next!=null){
                lruNode.next.prev = lruNode.prev;
            }
        }
    }


}


class LruNode {
    int key;
    int data;
    LruNode prev;
    LruNode next;

    public LruNode(int key, int data) {
        this.key = key;
        this.data = data;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
