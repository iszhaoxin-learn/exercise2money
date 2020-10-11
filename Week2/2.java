class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry > 0) return new ListNode(1);
            return null;
        }
        
        int val1 = (l1 == null) ? 0 : l1.val;
        int val2 = (l2 == null) ? 0 : l2.val;
        int sum = val1 + val2 + carry;
        
        ListNode node = new ListNode(sum % 10);
        ListNode p = (l1 == null) ? l1 : l1.next;
        ListNode q = (l2 == null) ? l2 : l2.next;
        node.next = addTwoNumbers(p, q, sum / 10);
        return node;
    }
}