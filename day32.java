public class day32 {
    Boolean balancedNumber(String N) {
        int n = N.length();
        if(n == 0) return false;
        
        int mid = n / 2;
        int leftsum = 0;
        int rightsum = 0;
        for(int i = 0; i < mid; i++){
            leftsum += (int)(N.charAt(i) - '0');
            rightsum += (int)(N.charAt(n - i - 1) - '0');
        }
        
        if(rightsum == leftsum){
            return true;
        }
        return false;
    }

    public boolean isUgly(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        
        int[] prime = {2 , 3 , 5};
        int i = 0;
        while(i < 3){
            while(n % prime[i] == 0){
                n /= prime[i];
            }
            i++;
        }
        
        if(n == 1) return true;
        
        return false;
    }
}