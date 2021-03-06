import java.util.*;
public class jan24 {
    public void customSort (int phy[], int chem[], int math[], int N){
        RC[] arr = new RC[N];
        for(int i = 0; i < N; i++){
            arr[i] = new RC(phy[i],chem[i],math[i]);
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++){
            phy[i] = arr[i].p;
            chem[i] = arr[i].c;
            math[i] = arr[i].m;
        }
    }
    public static class RC implements Comparable<RC>{
        int p , c , m;
        
        RC(int p , int c , int m){
            this.p = p;
            this.c = c;
            this.m = m;
        }
        public int compareTo(RC o){
            if(this.p != o.p) return this.p - o.p;
            else if(this.c != o.c) return o.c - this.c;
            else return this.m - o.m;
        }
    }

    public int pivotIndex(int[] nums) {
        int rsum = 0 , lsum = 0;
        for(int i : nums){
            rsum += i;
        }
        
        for(int i = 0; i < nums.length; i++){
            rsum -= nums[i];
            if(rsum == lsum) return i;
            lsum += nums[i];
        }
        return -1;
    }

    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        if(Character.isUpperCase(word.charAt(0))){
            if(Character.isUpperCase(word.charAt(1))){
                for(int i = 2; i < word.length(); i++){
                    if(Character.isLowerCase(word.charAt(i))) return false;
                }
            }
            else{
                for(int i = 1; i < word.length(); i++){
                    if(Character.isUpperCase(word.charAt(i))) return false;
                }
            }
        }
        else{
            for(int i = 0; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
