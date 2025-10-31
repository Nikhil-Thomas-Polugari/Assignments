import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n: size of board
     *  2. INTEGER k: number of obsticles
     *  3. INTEGER r_q: x-coord for queen
     *  4. INTEGER c_q: y-coord for queen
     *  5. 2D_INTEGER_ARRAY obstacles: coords of obsticles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        int moves = 0;
        for(int i = r_q; i <= n; i++){
            moves++;
        }
        for(int i = c_q; i <= n; i++){
            moves++;
        }
        for(int i = r_q; i >= 0; i--){
            moves++;
        }
        for(int i = c_q; i >= 0; i--){
            moves++;
        }
        while (r_q <= n && c_q <= n){
            moves++;
            r_q++;
            c_q++;
        }
        while (r_q >= 0 && c_q >= 0){
            moves++;
            r_q--;
            c_q--;
        }
        for(int i = 1; i <= k; i++){
            for(int j = obstacles.get(i).get(1); j <= n; j++){
                moves++;
            }
            for(int j = obstacles.get(i).get(2); j <= n; j++){
                moves++;
            }
            for(int j = obstacles.get(i).get(1); j >= 0; j--){
                moves++;
            } 
            for(int j = obstacles.get(i).get(2); j >= 0; j--){
                moves++;
            }
            int obsticle_r = obstacles.get(i).get(1);
            int obsticle_c = obstacles.get(i).get(2);
            while (obstacles.get(i).get(1) <= n && obstacles.get(i).get(2) <= n){
                moves++;
                obsticle_r++;
                obsticle_c++;
            }
            while (obstacles.get(i).get(1) >= 0 && obstacles.get(i).get(2) >= 0){
                moves++;
                obsticle_r--;
                obsticle_c--;
            }
        }
        return moves;
    }

}

public class main{
    public static void main(String[] args) {
        List<List<Integer>> obstacles = new ArrayList<>();
        obstacles.add(Arrays.asList(5, 4));
        obstacles.add(Arrays.asList(2, 3));
        int result = Result.queensAttack(5, 2, 4, 3, obstacles);
        System.out.println(result);
    }
}