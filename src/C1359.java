import java.util.*;

public class C1359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int hot = sc.nextInt();
            int cold = sc.nextInt();
            int target = sc.nextInt();

            int avg = (hot + cold) / 2;
            if (target <= avg) {
                System.out.println(2);
                continue;
            }

            long left = 0, right = (long) 1e12, best = 0;
            long minDiff = Long.MAX_VALUE, minCups = 1;

            while (left <= right) {
                long mid = (left + right) / 2;
                long cups = 2 * mid + 1;
                long tempSum = (mid + 1) * hot + mid * cold;

                long diff = Math.abs(tempSum - target * cups);
                long totalCups = cups;

                if (diff * minCups < minDiff * totalCups ||
                        (diff * minCups == minDiff * totalCups && cups < best)) {
                    minDiff = diff;
                    minCups = totalCups;
                    best = cups;
                }

                if (tempSum > target * cups) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            long evenCups = 2;
            long evenTemp = hot + cold;
            long evenDiff = Math.abs(evenTemp - target * evenCups);

            if (evenDiff * minCups < minDiff * evenCups ||
                    (evenDiff * minCups == minDiff * evenCups && evenCups < best)) {
                best = evenCups;
            }

            System.out.println(best);
        }
    }
}
