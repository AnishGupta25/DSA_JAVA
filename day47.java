import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class day47 {
    public static void orderofcompile(ArrayList<Edge>[] graph, int vtces) {
        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < vtces; i++) {
          if (!visited[i]) {
            Topological(graph, st, visited, i);
          }
        }
        while (st.size() > 0) {
          System.out.println(st.pop());
        }
    }
    
    public static void Topological(ArrayList<Edge>[] graph, Stack<Integer> st, boolean[] visited, int src) {
        visited[src] = true;
        for (Edge e : graph[src]) {
          if (!visited[e.nbr]) {
            Topological(graph, st, visited, e.nbr);
          }
        }
        st.push(src);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a , b) -> Integer.compare(a[1],b[1]));
        
        int arrows = 1;
        int dia = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > dia){
                arrows += 1;
                dia = points[i][1];
            }
        }
        return arrows;
    }

    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
          for (int i = 0; i < boxes.length; i++) {
            System.out.print(boxes[i]);
          }
          System.out.println();
          return;
        }
    
        for (int i = 0; i < boxes.length; i++) {
          if (boxes[i] == 0) {
            boxes[i] = ci;
            permutations(boxes, ci + 1, ti);
            boxes[i] = 0;
          }
        }
    }

    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {
          for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] != 0)
              System.out.print("i");
            else System.out.print("-");
          }
          System.out.println();
          return;
        }
    
        for (int i = 0; i < boxes.length; i++) {
          if (boxes[i] == 0 && i > lb) {
            boxes[i] = ci;
            lb = i;
            combinations(boxes, ci + 1, ti, lb);
            boxes[i] = 0;
          }
        }
    }

    public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
        if(cb > tb){
            if(ssf == ts)
            System.out.println(asf);
            return;
        }
        
        combinations(cb + 1 , tb , ssf + 1 , ts , asf + "i");
        combinations(cb + 1 , tb , ssf + 0 , ts , asf + "-");
    }

    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        if (cb > tb) {
          if (ssf == ts) {
            System.out.println(asf);
          }
          return;
        }
        for (int i = 0; i < ts; i++) {
          if (items[i] == 0) {
            items[i] = 1;
            permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
            items[i] = 0;
          }
        }
    
        permutations(cb + 1, tb, items, ssf + 0, ts, asf + 0);
    }

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if (row == tq) {
          if (qpsf == tq) {
            System.out.println(asf);
            System.out.println();
          }
          return;
        }
    
        int nr, nc;
        String sep = "";
        if (col < tq - 1) {
          nr = row;
          nc = col + 1;
          sep = "\t";
        }
        else {
          nr = row + 1;
          nc = 0;
          sep = "\n";
        }
        for (int i = 0; i < tq; i++) {
          if (!queens[i]) {
            queens[i] = true;
            queensPermutations(qpsf + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queens);
            queens[i] = false;
          }
        }
        queensPermutations(qpsf, tq, nr, nc, asf + "-" + sep, queens);
    }

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
      if(row == tq){
          if(qpsf == tq){
              System.out.println(asf);
          }
          return;
      }
      
      int nr , nc;
      String sep = "";
      if(col < tq - 1){
          nc = col+1;
          nr = row;
          sep = "";
      }
      else{
          nc = 0;
          nr = row+1;
          sep = "\n";
      }
      queensCombinations(qpsf+1 , tq , nr , nc , asf+"q"+sep);
      queensCombinations(qpsf , tq , nr , nc , asf+"-"+sep);
    }
}
