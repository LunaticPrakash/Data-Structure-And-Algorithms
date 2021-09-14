import java.util.HashMap;

public class gridTraveller {

    public static Long gridSolver(int m, int n, HashMap<String,Long> memo){
        String key = String.valueOf(m).concat(":").concat(String.valueOf(n));
        if(memo.containsKey(key)) return memo.get(key);
        if(m == 0 || n == 0) return 0L;
        if(m == 1 && n == 1) return 1L;
        memo.put(key,gridSolver(m-1, n, memo) + gridSolver(m, n-1, memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(gridSolver(1, 1, new HashMap<String, Long>()));
        System.out.println(gridSolver(2, 3, new HashMap<String, Long>()));
        System.out.println(gridSolver(3, 2, new HashMap<String, Long>()));
        System.out.println(gridSolver(3, 3, new HashMap<String, Long>()));
        System.out.println(gridSolver(18, 18, new HashMap<String, Long>()));
        
    }
}