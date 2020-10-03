class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode beforeHead = new ListNode(-1), afterHead = new ListNode(-1);
        ListNode before = beforeHead, after = afterHead;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            
            head = head.next;
        }
        
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}