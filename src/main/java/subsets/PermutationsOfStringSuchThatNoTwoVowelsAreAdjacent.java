package subsets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/permutations-of-string-such-that-no-two-vowels-are-adjacent/
 *
 * Given a string consisting of vowels and consonants. The task is to find the number of ways in which the characters of the string can be arranged such that no two vowels are adjacent to each other.
 *
 * Note: Given that No. of vowels <= No. of consonants.
 *
 * Input: str = "permutation"
 * Output : 907200
 *
 * Input: str = "geeksforgeeks"
 * Output: 3175200
 * Recommended: Please try your approach on {IDE} first, before moving on to the solution.
 * Approach:
 * Consider the above example string “permutation”:
 *
 * First place all of the consonants at the alternate places like below:
 * -- p -- r -- m -- t -- t -- n --
 * Number of ways to place consonants = 6! / 2!. as t appears twice and should be considered once.
 *
 * Then place the vowels at the remaining positions. We have 7 remaining positions and 5 vowels to fill these 7 places.
 * Therefore, number of ways to fill vowels = $7_{C_5} \times 5!$.
 * Total no. of ways =   (6! / 2!) \times 7_{C_5} \times 5!
 *                   = 907200
 * Suppose in a string number of vowels is vowelCount and the number of consonants is consonantCount.
 *
 * Therefore,
 *
 * Total ways = (consonantCount! / duplicateConsonant!) * C(consonantCount+1 , vowelCount) * (vowelCount! / duplicateVowel!)
 */
public class PermutationsOfStringSuchThatNoTwoVowelsAreAdjacent {
    static int factorial(int n)
    {

        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact = fact * i;

        return fact;
    }

    // Function to find c(n, r)
    static int ncr(int n, int r)
    {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // Function to count permutations of string
    // such that no two vowels are adjacent
    static int countWays(String str)
    {
        int freq[]=new int[26];

        for(int i=0;i<26;i++)
        {
            freq[i]=0;
        }

        int nvowels = 0, nconsonants = 0;

        int vplaces, cways, vways;

        // Finding the frequencies of
        // the characters
        for (int i = 0; i < str.length(); i++)
        {
            ++freq[str.charAt(i) - 'a'];
        }

        // finding the no. of vowels and
        // consonants in given word
        for (int i = 0; i < 26; i++) {

            if (i == 0 || i == 4 || i == 8
                    || i == 14 || i == 20)
                nvowels += freq[i];
            else
                nconsonants += freq[i];
        }
        // finding places for the vowels
        vplaces = nconsonants + 1;

        // ways to fill consonants 6! / 2!
        cways = factorial(nconsonants);
        for (int i = 0; i < 26; i++) {
            if (i != 0 && i != 4 && i != 8 && i != 14
                    && i != 20 && freq[i] > 1) {

                cways = cways / factorial(freq[i]);
            }
        }

        // ways to put vowels 7C5 x 5!
        vways = ncr(vplaces, nvowels) * factorial(nvowels);
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14
                    || i == 20 && freq[i] > 1) {
                vways = vways / factorial(freq[i]);
            }
        }

        return cways * vways;
    }

    // Driver code
    public static void main(String []args)
    {
        String str = "permutation";

        System.out.println(countWays(str));
        System.out.println(countWays2(str));

    }

    public static int countWays2(String str){
        Set<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u').stream().collect(Collectors.toSet());

        Map<Character, Integer> vowelMap = new HashMap<>();
        Map<Character, Integer> consonantMap = new HashMap<>();

        char[] arr = str.toCharArray();

        int consonantCount = 0;
        int vowelCount = 0;
        for (Character c : arr) {
            if(vowels.contains(c)){
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
                vowelCount++;
            } else{
                consonantMap.put(c, consonantMap.getOrDefault(c, 0) + 1);
                ++consonantCount;
            }
        }

        int consonantWays = factorial(consonantCount);
        int vowelWays = factorial(vowelCount);

        for (Map.Entry<Character, Integer> entry: consonantMap.entrySet()) {
            consonantWays/=factorial(entry.getValue());
        }

        for (Map.Entry<Character, Integer> entry: vowelMap.entrySet()) {
            vowelWays/=factorial(entry.getValue());
        }

        int ncr = ncr(consonantCount + 1, vowelMap.size());
        return consonantWays*vowelWays*ncr;
    }


}

