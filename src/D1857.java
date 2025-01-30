import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D1857 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int tests = sc.nextInt();

            while (tests-- > 0) {
                int n = sc.nextInt();  // Считываем число n
                int[] first = new int[n];
                int[] second = new int[n];
                int[] result = new int[n];

                for (int i = 0; i < n; i++) {
                    first[i] = sc.nextInt();
                }

                for (int i = 0; i < n; i++) {
                    second[i] = sc.nextInt();
                }

                int maxC = Integer.MIN_VALUE;
                List<Integer> wise = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    result[i] = first[i] - second[i];
                    maxC = Math.max(maxC, result[i]);
                }
                for (int i = 0; i < n; i++) {
                    if (result[i] == maxC) {
                        wise.add(i + 1);
                    }
                }
                System.out.println(wise.size());
                for (int index : wise) {
                    System.out.print(index + " ");
                }
                System.out.println();
            }
            sc.close();
        }
    }
