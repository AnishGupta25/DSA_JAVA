import java.util.*;
public class feb9 {
    public int findPairs(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i : nums) map.put(i , map.getOrDefault(i , 0) + 1);
        
        int res = 0;
        
        for(int i : map.keySet()){
            if(k > 0 && map.containsKey(i+k) || k == 0 && map.get(i) > 1) res++;
        }
        return res;
    }
}
