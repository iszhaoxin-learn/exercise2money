class Node{
    int value;
    Node next;
    Node prev;
    public Node(int value, Node prev, Node next){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    public Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class Solution {
    private Node head;
    private Node current;
    private int size = 0;
    public Solution() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(this.size-1 < index || index<0){
            System.out.println(-1);
            return -1;
        }
        Node current = this.head;
        for(int i=0; i<index; i++)
            current = current.next;
        return current.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(this.head == null){
            this.head = new Node(val);
            this.current = this.head;
        }
        else{
            this.head.prev = new Node(val, null, this.head);
            this.head = this.head.prev;
        }
        this.size += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head == null){
            this.head = new Node(val);
            this.current = this.head;
        }
        else
        {
            Node current = this.head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(val, current, null);
            current = current.next;
        }
        this.size += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(this.size < index)
            return;
        else if(index<0)
            addAtHead(val);
        else if(this.size==index)
            addAtTail(val);
        else{
            if(index==0)
                addAtHead(val);
            else{
                Node current = this.head;
                for(int i=0; i<index-1; i++)
                    current = current.next;
                current.next = new Node(val, current, current.next);
                current.next.next.prev = current.next;
                this.size += 1;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > this.size-1 || index<0)
            return;
        Node current = this.head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        if(this.size-1 == index){
            if(index==0)
                this.head = null;
            else
                current.prev.next = null;
        }
        else{
            if(index == 0) {
                this.head = this.head.next;
                this.head.prev = null;
            }
            else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
        this.size -= 1;
    }

    public void display() {
        Node current = this.head;
        for(int i=0; i<size; i++){
            System.out.print("->");
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println("->");
    }
}