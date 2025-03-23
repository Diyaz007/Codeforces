import java.io.*;
import java.util.*;

public class A983 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            long p = Long.parseLong(parts[0]);
            long q = Long.parseLong(parts[1]);
            long b = Long.parseLong(parts[2]);

            if (p == 0) {
                writer.write("Finite\n");
                continue;
            }

            long g = gcd(p, q);
            long qPrime = q / g;

            if (checkFinite(qPrime, b)) {
                writer.write("Finite\n");
            } else {
                writer.write("Infinite\n");
            }
        }
        writer.flush();
    }

    private static boolean checkFinite(long qPrime, long b) {
        if (qPrime == 1) return true;
        long common = gcd(qPrime, b);
        while (common != 1) {
            qPrime /= common;
            common = gcd(qPrime, common);
            if (qPrime == 0) break;
        }
        return qPrime == 1;
    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int shift = Long.numberOfTrailingZeros(a | b);
        a >>= Long.numberOfTrailingZeros(a);

        do {
            b >>= Long.numberOfTrailingZeros(b);
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }
            b -= a;
        } while (b != 0);

        return a << shift;
    }
}
