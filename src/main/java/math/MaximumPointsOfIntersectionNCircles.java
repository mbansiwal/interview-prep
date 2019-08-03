package math;

/**
 * https://www.geeksforgeeks.org/maximum-points-intersection-n-circles/
 *
 * As we can see in above diagram, for each pair of circles, there can be maximum two intersectuib points. Therefore if we have n circles then there can be nC2 pairs of circles in which each pair will have two intersections. So by this we can conclude that by looking at all possible pairs of circles the mathematical formula can be made for the maximum number of intersection by n circles is given by 2 * nC2.
 *
 * 2 * nC2 = 2 * n * (n – 1)/2 = n * (n-1)
 *
 */
public class MaximumPointsOfIntersectionNCircles {
    public static int findMax(int n){
        return n * (n-1);
    }

    public static void main(String[] args){
        System.out.println(findMax(3));
    }
}
