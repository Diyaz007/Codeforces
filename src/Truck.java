import java.util.*;
class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class Truck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int W = scanner.nextInt();
            graph.get(A).add(new Edge(B, W));
        }

        int S = scanner.nextInt();
        int T = scanner.nextInt();

        int[] capacity = new int[N + 1];
        Arrays.fill(capacity, Integer.MIN_VALUE);
        capacity[S] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{S, capacity[S]});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int currentCapacity = current[1];

            if (city == T) {
                break;
            }

            if (currentCapacity < capacity[city]) {
                continue;
            }

            for (Edge edge : graph.get(city)) {
                int nextCity = edge.to;
                int nextCapacity = Math.min(currentCapacity, edge.weight);

                if (nextCapacity > capacity[nextCity]) {
                    capacity[nextCity] = nextCapacity;
                    pq.offer(new int[]{nextCity, nextCapacity});
                }
            }
        }
        System.out.println(capacity[T]);
    }
}

