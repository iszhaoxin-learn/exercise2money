// Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: l1 = [], l2 = []
// Output: []
// Example 3:

// Input: l1 = [], l2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both l1 and l2 are sorted in non-decreasing order.

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode dummyNode = node;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 == null){
                node.next = l1;
                l1 = l1.next;
            }else if(l2 != null && l1 == null){
                node.next = l2;
                l2 = l2.next;
            }else{
                if(l1.val <= l2.val){
                    node.next = l1;
                    l1 = l1.next;
                }else {
                    node.next = l2;
                    l2 = l2.next;
                }
            }
            node = node.next;
        }
        return dummyNode.next;
    }
}