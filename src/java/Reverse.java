package interview;

public class Reverse {
    public void solution(int N) {
        int enable_print = 0;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
}

/**
 * Example test:   54321
 * OK
 *
 * Example test:   10011
 * OK
 *
 * Example test:   1
 * OK
 *
 * Your test case: [1011011000]
 * Output:
 * 1101101
 */