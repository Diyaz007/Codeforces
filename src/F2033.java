import java.util.*;

public class F2033 {
    static final long MOD = (long) 1e9 + 7;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    static int randomNum(int l, int r) {
        return l + random.nextInt(r - l + 1);
    }

    static int binaryPower(int a, int n) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = (int) ((res * 1L * a) % MOD);
            a = (int) ((a * 1L * a) % MOD);
            n >>= 1;
        }
        return res;
    }

    static int inverse(int a) {
        return binaryPower(a, (int) (MOD - 2));
    }

    static void solve() {
        long n = scanner.nextLong() % MOD;
        long k = scanner.nextLong();

        if (k == 1) {
            System.out.println(n);
            return;
        }

        int[] fib = {1, 1, 0};
        int cnt = 0;

        for (int i = 2; i <= 10 * k; i++) {
            fib[i % 3] = (fib[(i + 2) % 3] + fib[(i + 1) % 3]) % (int) k;
            if (fib[i % 3] == 0) cnt++;
            if (fib[i % 3] == 1 && fib[(i + 2) % 3] == 0) {
                System.out.println(i * n % MOD * inverse(cnt) % MOD);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) solve();
    }
}
