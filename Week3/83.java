class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            ListNode nextNode = tmp.next;
            if (tmp.val == nextNode.val) {
                tmp.next = nextNode.next;
            } else {
                tmp = tmp.next;
            }
        }
        
        return head;
    }
}