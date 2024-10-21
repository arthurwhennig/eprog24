import java.util.Arrays;

public class Sieb {
    public static void main(String[] args) {
        System.out.println(countPrimes(0));
        // outputs 15 because of
        // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
    }

    public static boolean[] sieb(int n) {
        boolean[] isNotPrime = new boolean[n+1];

        int curr = 2;
        while (curr <= Math.sqrt(n)) { // prime factors of n can be at most the square root of n
            for (int i = 2; i * curr <= n; i++) {
                isNotPrime[i*curr] = true;
            }
            int next = curr+1;
            while (isNotPrime[next]) {
                next++;
            }
            curr = next;
        }
        isNotPrime[0] = true; // 0 is not prime
        isNotPrime[1] = true; // 1 is not prime
        return isNotPrime;
    }

    public static int countPrimes(int limit) {
        // no prime numbers smaller than 2
        if (limit <= 1) return 0;
        // get a boolean array with 'false' if the index is prime and 'true' otherwise
        boolean[] isNotPrime = sieb(limit);
        int count = 0;
        // count the number of primes up to limit
        for (int i = 0; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) count++;
        }
        return count;
    }
}
