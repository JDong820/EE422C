/* Student Name: Joshua Dong, Lab Section: 1  */
package assignment1;

//import java.util.CopyOnWriteArraySet;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class PalFinder {
    private final StringFilter filter;


    PalFinder() {
        filter = (c) -> ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }


    /**
     * Parses input to find all maximal palindromes (no sub-palindromes).
     *
     * @param inputString String parsed for palindromes.
     *
     * @return Set of palindromes found.
     */
    public Set<String> parse(String rawInput) {
        final String input = applyFilter(rawInput);
        // With a maximum input length of 60 and minimum palindrome length of
        // 3, 32 seems to be a fair upper bound for results.
        Set<String> results = new HashSet<String>(32);
        // TODO: Parallelize.
        // Consider CopyOnWriteArraySet for threaded application.
        for (int i = 1; i < input.length() - 1; ++i) {
            String oddResult = searchOddPalindromes(input, i);
            String evenResult = searchEvenPalindromes(input, i);
            if (oddResult != null) {
                results.add(oddResult);
            }
            if (evenResult != null) {
                results.add(evenResult);
            }
        }
        return removeSubPalindromes(results);
    }

    private String searchOddPalindromes(String space, int center) {
        String bestPalindrome = null;
        // TODO: Find out if this assignment is nessasary.
        int maxSearch = Math.min(center, space.length() - 1 - center);
        for (int i = 1; i <= maxSearch; ++i) {
            String test = space.substring(center - i, center + i + 1);
            if (isPalindrome(test)) {
                bestPalindrome = test;
            } else {
                break;
            }
        }
        return bestPalindrome;
    }

    private String searchEvenPalindromes(String space, int leftCenter) {
        String bestPalindrome = null;
        int maxSearch = Math.min(leftCenter, space.length() - 2 - leftCenter);
        for (int i = 1; i <= maxSearch; ++i) {
            String test = space.substring(leftCenter - i, leftCenter + i + 2);
            if (isPalindrome(test)) {
                bestPalindrome = test;
            } else {
                break;
            }
        }
        return bestPalindrome;
    }

    /**
     * Filter a string using the class's StringFilter.
     */
    private String applyFilter(String input) {
        // TODO: use stream API .filter()
        StringBuilder buf = new StringBuilder();
        for (char c: input.toCharArray()) {
            if (filter.pass(c)) {
                buf.append(c);
            }
        }
        return buf.toString().toUpperCase();
    }

    /**
     * Check if the first argument is a proper sub-palindrome of the second
     * argument.
     */
    private static boolean isSubPalindrome(String test, String target) {
        int offset = (target.length() - test.length())/2;
        // Only check for proper sub-palindromes.
        return test.length() < target.length() && // Proper sub-palindromes.
            test.length() % 2 == target.length() % 2 && // Pairity must match.
            test.equals(target.substring(offset, offset+test.length()));
    }

    /**
     * Remove sub-palindromes.
     */
    private static Set<String> removeSubPalindromes(Set<String> palindromes) {
        // TODO: Parallelize.
        Set<String> desired = new HashSet<String>(palindromes.size());
        // Note: n**2
        for (String palindrome: palindromes) {
            boolean notSub = true;
            for (String test: palindromes) {
                if (isSubPalindrome(palindrome, test)) {
                    notSub = false;
                    break;
                }
            }
            if (notSub) {
                desired.add(palindrome);
            }
        }
        return desired;
    }

    private static boolean isPalindrome(String test) {
        // Could be more efficient.
        final String frontHalf = test.substring(0, test.length()/2);
        final String backHalf = test.substring(test.length()/2 +
                (test.length() % 2 == 0 ? 0:1));
        return frontHalf.equals(new StringBuilder(backHalf).reverse().toString());
    }
}
