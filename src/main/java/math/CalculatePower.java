package math;

/**
 * https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 *
 * O(logn) solution
 */
public class CalculatePower {
    public static float calculate(int x, int n){
        if(n == 0){
            return 1;
        }

        float power = calculate(x, n/2);

        if(n %2 == 0){
            power = power * power;
        } else{
            if(n > 0){
                power = x * power * power;
            } else{
                power = (power * power)/x;
            }

        }
        return power;
    }

    public static void main(String[] args){
        System.out.println(calculate(2, 3));
        System.out.println(calculate(3, 4));
        System.out.println(calculate(2, -3));
    }
}
