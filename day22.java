public class day22 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        
        if(root.left != null && root.left.val != root.val) return false;
        if(root.right != null && root.right.val != root.val) return false;
        
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        BPair tree = isBST(root);
        return tree.bst;
    }
    
    public BPair isBST(TreeNode root){
        if(root == null) return new BPair(Long.MAX_VALUE , Long.MIN_VALUE , true);
        
        BPair lpair = isBST(root.left);
        BPair rpair = isBST(root.right);
        
        Long min = Math.min(lpair.min , Math.min(rpair.min , root.val));
        Long max = Math.max(root.val , Math.max(lpair.max , rpair.max));
        boolean bst = lpair.bst && rpair.bst && root.val > lpair.max && root.val < rpair.min;
        
        return new BPair(min , max , bst);
    }
    
    public class BPair{
        Long min;
        Long max;
        boolean bst;
        BPair(Long min, Long max, boolean bst){
            this.min = min;
            this.max = max;
            this.bst = bst;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode temp = head;
        ListNode ans = head;
        
        while(n > 0){
            temp = temp.next;
            n--;
        }
        
        if(temp == null) return ans.next;
        
        while(temp.next != null){
            temp = temp.next;
            ans = ans.next;
        }
        
        // ans.next = null;
        ans.next = ans.next.next;
        
        return head;
    }

    public static boolean isConnected(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        isConnectedHelper(graph , visited , 0);
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == false) return false;
        }
        return true;
    }
      
    public static void isConnectedHelper(ArrayList<Edge>[] graph , boolean[] visited, int vtx){
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(!visited[e.nbr]){
                isConnectedHelper(graph , visited , e.nbr);
            }
        }
    }
}
