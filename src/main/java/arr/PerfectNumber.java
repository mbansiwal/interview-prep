package arr;

public class PerfectNumber {
    static String Solve(int N){
        // Write your code here
        int sum = 0;
        for(int i=1; i <= Math.sqrt(N); ++i){
            if(N%i == 0){
                if(N/i == i){
                    sum+=i;
                }else{
                    sum += i + N/i;
                }
            }
        }
        sum-=N;
        if(sum == N){
            return "YES";
        } else{
            return "NO";
        }
    }

    public static void main(String[] args){
        System.out.println(Solve(3));
        System.out.println(Solve(5));
        System.out.println(Solve(6));
    }
}
