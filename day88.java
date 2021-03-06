import java.util.*;
public class day88 {
    static int candies(int m, int n){
        int x = (n * m) - n - m;
        return (x / 2) + 1;
    }

    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> list = new ArrayList<>();
        
        int clvl = 0 , llvl = 1;
        while(clvl < n){
            clvl += llvl;
            llvl *= 2;
        }
        llvl /= 2;
        
        while(n != 0){
            list.add(n);
            n = (3 * llvl - n - 1) / 2;
            llvl /= 2;
        }
        Collections.reverse(list);
        return list;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return treeCons(inOrder , 0 , inOrder.length - 1);
    }
    
    public static TreeNode treeCons(int[] inorder , int inS , int inE){
        if(inS > inE) return null;
        
        int mid = (inS + inE) / 2;
        TreeNode node = new TreeNode(inorder[mid]);
        
        node.left = treeCons(inorder , inS , mid - 1);
        node.right = treeCons(inorder , mid + 1 , inE);
        
        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return BSTcon(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    int i;
    public TreeNode BSTcon(int[] preorder , int min , int max){
        TreeNode node = new TreeNode(preorder[i]);
        
        if(i+1 != preorder.length && preorder[i+1] < preorder[i] && preorder[i+1] > min){
            node.left = BSTcon(preorder , min , preorder[i++]);
        } 
        if(i+1 != preorder.length && preorder[i+1] > preorder[i] && preorder[i+1] < max){
            node.right = BSTcon(preorder , preorder[i++] , max);
        } 
        
        return node;
    }

    class Node{
        int data;
        Node left , right;
        Node(int data){
            this.data = data;
        }
    }

    public Node constructBST(int[] arr){
        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(null , Integer.MIN_VALUE , Integer.MAX_VALUE));
        Node root = null;
        int idx = 0;
        while(pq.size() > 0 && idx < arr.length){
            Pair temp = pq.remove();
            if(arr[idx] < temp.min || arr[idx] > temp.max) continue;
            
            Node node = new Node(arr[idx]);
            
            if(temp.par == null) root = node;
            else{
                if(temp.par.data > node.data) temp.par.left = node;
                else temp.par.right = node;
            }
            
            pq.add(new Pair(node , temp.min , node.data));
            pq.add(new Pair(node , node.data , temp.max));
        }
        return root;
    }
    class Pair{
        Node par;
        int min , max;
        Pair(Node par , int min , int max){
            this.par = par;
            this.min = min;
            this.max = max;
        }
    }
}
