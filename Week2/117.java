class Solution {
    public Node connect(Node root) {
        Node curLevelStart = root, nextLevelSentinal = new Node(-1);
        
        while (curLevelStart != null) {
            Node curLevelMove = curLevelStart, nextLevelMove = nextLevelSentinal;
            while (curLevelMove != null) {
                if (curLevelMove.left != null) {
                    nextLevelMove.next = curLevelMove.left;
                    nextLevelMove = nextLevelMove.next;
                }
                
                if (curLevelMove.right != null) {
                    nextLevelMove.next = curLevelMove.right;
                    nextLevelMove = nextLevelMove.next;
                }
                
                curLevelMove = curLevelMove.next;
            }
            curLevelStart = nextLevelSentinal.next;
            nextLevelSentinal.next = null;
        }
        
        return root;
    }
}