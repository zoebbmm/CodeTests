package AlgorithmAndDataStructureTests.TestPrimeNumber;

/**
 * Created by weizhou on 6/1/16.
 */
public class Main {
    public static void main(String[] args) {
        findPrimes(16);
        System.out.println(isPrime(16));
    }

    public static void findPrimes(long n) {
        long number = 2;
        Boolean isPrime = true;

        while (number <= n) {
            for (int subNumber = 2; subNumber <= Math.sqrt(number); subNumber++) {
                if (number % subNumber == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                System.out.println(number + " is a Prime");
            }

            number++;
        }
    }

    public static Boolean isPrime(long n) {
        Boolean isPrime = true;

        for (int number = 2; number <= Math.sqrt(n); number++) {
            if (n % number == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
