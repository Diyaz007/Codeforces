import java.util.*;

public class B707 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Количество городов
        int m = sc.nextInt(); // Количество дорог
        int k = sc.nextInt(); // Количество пекарен

        List<int[]> roads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int l = sc.nextInt();
            roads.add(new int[]{u, v, l});
        }

        Set<Integer> storage = new HashSet<>();
        for (int i = 0; i < k; i++) {
            storage.add(sc.nextInt());
        }

        int minDistance = Integer.MAX_VALUE;

        for (int[] road : roads) {
            int u = road[0], v = road[1], l = road[2];
            if ((storage.contains(u) && !storage.contains(v)) || (storage.contains(v) && !storage.contains(u))) {
                minDistance = Math.min(minDistance, l);
            }
        }

        System.out.println(minDistance == Integer.MAX_VALUE ? -1 : minDistance);
    }
}



