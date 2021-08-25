import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class day52 {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        
        while(l <= r){
            if(((l*l) + (r*r)) < c) l++;
            else if(((l*l) + (r*r)) > c) r--;
            else return true;
        }
        return false;
    }

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            while(!st.isEmpty() && list.get(st.peek()) < list.get(i)){
                arr[st.pop()] = list.get(i);
            }
            st.push(i);
        }
        return arr;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += nums[i];
            i++;
        }
        return ans;
    }

    static int maximumPath(int N, int Matrix[][]){
        int[][] max = new int[N][N];
        
        for(int i = 0; i < N; i++){
            max[N-1][i] = Matrix[N-1][i];
        }
        
        for(int i = N-2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                if(j == 0){
                    max[i][j] = Matrix[i][j] + Math.max(max[i+1][j] , max[i+1][j+1]);
                }
                else if(j == N-1){
                    max[i][j] = Matrix[i][j] + Math.max(max[i+1][j] , max[i+1][j-1]);
                }
                else{
                    max[i][j] = Matrix[i][j] + Math.max(max[i+1][j] , Math.max(max[i+1][j-1] , max[i+1][j+1]));
                }
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            maxSum = Math.max(max[0][i] , maxSum);
        }
        return maxSum;
    }
}
