package math.reverse;

public class Reverse {
    public void solution(int N) {
        int enablePrint = 0;
        while (N > 0) {
            if (enablePrint == 0 && N % 10 != 0) {
                enablePrint = 1;
            }
            if (enablePrint == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    void main(String[] args) {
        solution(54321);
        System.out.println();
        solution(10011);
        System.out.println();
        solution(1);
        System.out.println();
        solution(1011011000);
        System.out.println();
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
